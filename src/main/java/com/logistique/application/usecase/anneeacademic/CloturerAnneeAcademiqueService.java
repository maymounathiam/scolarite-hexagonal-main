package com.logistique.application.usecase.anneeacademic;

import com.logistique.application.command.anneeacademique.CloturerAnneeAcademiqueCommand;
import com.logistique.application.port.in.anneeacademique.CloturerAnneeScolaireUseCase;
import com.logistique.application.port.out.event.DomainEventPublisher;
import com.logistique.application.port.out.repository.AnneeAcademiqueRepository;
import com.logistique.domain.entity.academic.AnneeAcademique;
import com.logistique.domain.entity.academic.AnneeAcademiqueId;
import com.logistique.domain.event.shared.DomainEvent;
import com.logistique.domain.exception.AnneeAcadiqueException;
import com.logistique.domain.exception.ScolariteNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CloturerAnneeAcademiqueService
        implements CloturerAnneeScolaireUseCase {

    private final AnneeAcademiqueRepository repository;
    private final DomainEventPublisher eventPublisher;

    public CloturerAnneeAcademiqueService(
            AnneeAcademiqueRepository repository,
            DomainEventPublisher eventPublisher
    ) {
        this.repository = repository;
        this.eventPublisher = eventPublisher;
    }

    @Override
    public void executer(CloturerAnneeAcademiqueCommand cmd) {

        AnneeAcademiqueId id =
                new AnneeAcademiqueId(cmd.codeAnnee()) ;

        AnneeAcademique annee = repository.findByCode(id.value())
                .orElseThrow(() ->
                        new ScolariteNotFoundException(
                                "Année académique introuvable"
                        )
                );

        annee.cloturer();

        repository.save(annee);
        annee.pullDomainEvents()
                .forEach(eventPublisher::publish);
    }
}

