package com.logistique.application.result.paiement;

import com.logistique.domain.entity.paiement.Paiement;
import com.logistique.infrastructure.persistence.paiement.adapter.PaiementPersistenceContext;

import java.util.List;

public record PaiementResult(
        List<Paiement> paiements,
        List<PaiementPersistenceContext> contexts
) {
}
