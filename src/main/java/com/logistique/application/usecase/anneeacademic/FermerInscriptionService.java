package com.logistique.application.usecase.anneeacademic;

import com.logistique.application.command.anneeacademique.FermerInscriptionCommand;
import com.logistique.application.command.anneeacademique.OuvrirInscriptionCommand;
import com.logistique.application.port.in.anneeacademique.FermerInscriptionUseCase;
import com.logistique.application.port.in.anneeacademique.OuvrirInscriptionUseCase;
import com.logistique.application.port.out.event.DomainEventPublisher;
import com.logistique.application.port.out.repository.AnneeAcademiqueRepository;
import com.logistique.domain.entity.academic.AnneeAcademique;
import com.logistique.domain.entity.academic.AnneeAcademiqueId;
import com.logistique.domain.exception.ScolariteNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FermerInscriptionService
        implements FermerInscriptionUseCase {

    private final AnneeAcademiqueRepository repository;
    private final DomainEventPublisher eventPublisher;


    public FermerInscriptionService(
            AnneeAcademiqueRepository repository, DomainEventPublisher eventPublisher
    ) {
        this.repository = repository;
        this.eventPublisher = eventPublisher;
    }

    @Transactional
    @Override
    public void executer(FermerInscriptionCommand cmd) {

        AnneeAcademiqueId id =
                new AnneeAcademiqueId(cmd.codeAnnee()) ;

        AnneeAcademique annee = repository.findByCode(id.value())
                .orElseThrow(() ->
                        new ScolariteNotFoundException(
                                "Année académique introuvable"
                        )
                );

        annee.fermerInscriptions();
        repository.save(annee);
        annee.pullDomainEvents()
                .forEach(eventPublisher::publish);
    }
}

