package com.logistique.application.port.out.repository;


import com.logistique.application.result.paiement.PaiementResult;
import com.logistique.domain.entity.paiement.Paiement;
import com.logistique.domain.entity.paiement.PaiementId;
import com.logistique.domain.entity.paiement.PaiementSnapshot;
import com.logistique.infrastructure.persistence.paiement.adapter.PaiementPersistenceContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public interface PaiementRepository {

    Paiement save(Paiement paiement, PaiementPersistenceContext paiementPersistenceContext);

    default void saveAll(
            List<Paiement> paiements,
            List<PaiementPersistenceContext> contexts
    ) {
        try {
            AtomicInteger i = new AtomicInteger();
            paiements.forEach(p -> {
                save(p, contexts.get(i.get()));
                i.getAndIncrement();
            });
        } catch (Exception e) {
            throw e;
        }
    }

    Paiement findById(PaiementId id);

    List<Paiement> findByMatriculeAndAnneeAcademique(
            String matricule,
            String anneeAcademique
    );

    public List<Paiement> findMensualitesImpayees(
            String matricule,
            String anneeAcademique
    );

    List<Paiement> findByMatriculeAndAnneeAcademiqueOrdered(
            String matricule,
            String anneeAcademique
    );

    List<Paiement> findByIdIn(List<UUID> paiements);
}

