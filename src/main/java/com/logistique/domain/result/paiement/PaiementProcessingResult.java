package com.logistique.domain.result.paiement;

import com.logistique.domain.entity.paiement.Paiement;
import com.logistique.domain.entity.paiement.PaiementId;
import com.logistique.infrastructure.persistence.paiement.adapter.PaiementPersistenceContext;

import java.util.List;
import java.util.UUID;

public record PaiementProcessingResult(
        List<Paiement> paiements,
        List<PaiementPersistenceContext> contexts,
        List<UUID> paieds
) {}
