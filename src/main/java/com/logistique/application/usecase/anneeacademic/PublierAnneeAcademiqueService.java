package com.logistique.application.usecase.anneeacademic;

import com.logistique.application.command.anneeacademique.PublierAnneeAcademiqueCommand;
import com.logistique.application.port.in.anneeacademique.PublierAnneeAcademiqueUseCase;
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
public class PublierAnneeAcademiqueService
        implements PublierAnneeAcademiqueUseCase {

    private final AnneeAcademiqueRepository repository;
    private final DomainEventPublisher eventPublisher;


    public PublierAnneeAcademiqueService(AnneeAcademiqueRepository repository, DomainEventPublisher eventPublisher) {
        this.repository = repository;
        this.eventPublisher = eventPublisher;
    }

    @Override
    public void executer(PublierAnneeAcademiqueCommand cmd) {

        AnneeAcademiqueId id =
                new AnneeAcademiqueId(cmd.codeAnnee()) ;

        AnneeAcademique annee = repository.findByCode(id.value())
                .orElseThrow(() ->
                        new ScolariteNotFoundException("Année académique introuvable"));

        annee.publier();
        repository.save(annee);

        annee.pullDomainEvents()
                .forEach(eventPublisher::publish);
    }
}

