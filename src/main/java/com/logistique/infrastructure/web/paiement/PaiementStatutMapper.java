package com.logistique.infrastructure.web.paiement;

import com.logistique.domain.entity.paiement.StatutPaiement;
import com.logistique.infrastructure.persistence.paiement.entity.StatutJpaPaiement;

public class PaiementStatutMapper {

    public static StatutJpaPaiement toJpa(StatutPaiement statut) {
        return StatutJpaPaiement.valueOf(statut.name());
    }

    public static StatutPaiement toDomain(StatutJpaPaiement statut) {
        return StatutPaiement.valueOf(statut.name());
    }
}
