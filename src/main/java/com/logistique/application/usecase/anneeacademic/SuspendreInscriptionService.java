package com.logistique.application.usecase.anneeacademic;

import com.logistique.application.command.anneeacademique.OuvrirInscriptionCommand;
import com.logistique.application.command.anneeacademique.SuspendreInscriptionCommand;
import com.logistique.application.port.in.anneeacademique.OuvrirInscriptionUseCase;
import com.logistique.application.port.in.anneeacademique.SuspendreInscriptionUseCase;
import com.logistique.application.port.out.event.DomainEventPublisher;
import com.logistique.application.port.out.repository.AnneeAcademiqueRepository;
import com.logistique.domain.entity.academic.AnneeAcademique;
import com.logistique.domain.entity.academic.AnneeAcademiqueId;
import com.logistique.domain.exception.ScolariteNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SuspendreInscriptionService
        implements SuspendreInscriptionUseCase {

    private final AnneeAcademiqueRepository repository;
    private final DomainEventPublisher eventPublisher;


    public SuspendreInscriptionService(
            AnneeAcademiqueRepository repository, DomainEventPublisher eventPublisher
    ) {
        this.repository = repository;
        this.eventPublisher = eventPublisher;
    }

    @Override
    public void executer(SuspendreInscriptionCommand cmd) {

        AnneeAcademiqueId id =
                new AnneeAcademiqueId(cmd.codeAnnee()) ;

        AnneeAcademique annee = repository.findByCode(id.value())
                .orElseThrow(() ->
                        new ScolariteNotFoundException(
                                "Année académique introuvable"
                        )
                );

        annee.suspendreInscriptions();
        repository.save(annee);
        annee.pullDomainEvents()
                .forEach(eventPublisher::publish);
    }
}

