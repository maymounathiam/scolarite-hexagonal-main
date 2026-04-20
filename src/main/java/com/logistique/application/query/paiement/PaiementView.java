package com.logistique.application.query.paiement;

import com.logistique.domain.entity.paiement.CanalPaiement;

import java.time.LocalDate;
import java.time.LocalTime;

public record PaiementView(
        String typePaiement,
        CanalPaiement canalPaiement,
        double montantPaye,
        LocalDate datePaiement,
        String mois,
        String annee
) {
}
