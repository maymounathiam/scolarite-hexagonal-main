package com.logistique.infrastructure.persistence.paiement.adapter;

import com.logistique.domain.entity.paiement.CanalPaiement;
import com.logistique.domain.entity.school.Montant;

import java.time.LocalTime;
import java.util.UUID;

public record PaiementPersistenceContext(
        // Identité
        UUID paiementId,
        int totalApapyer,
        // Canal & preuves (technique)
        CanalPaiement canalPaiement,
        String operateurMobileMoney,
        String referenceMobileMoney,
        String nomBanque,
        String referenceBancaire,
        String urlPreuve,
        LocalTime heurePaiement
) {}
