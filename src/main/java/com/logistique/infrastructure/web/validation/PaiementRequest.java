package com.logistique.infrastructure.web.validation;

import com.logistique.domain.entity.paiement.CanalPaiement;

public interface PaiementRequest {

    CanalPaiement canalPaiement();

    String operateurMobileMoney();

    String referenceMobileMoney();

    String nomBanque();

    String referenceBancaire();

    String preuvePaiement();
}