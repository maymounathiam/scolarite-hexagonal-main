package com.logistique.application.port.in.paiement;

import com.logistique.domain.entity.paiement.PaiementId;

public interface GenererRecuPaiementUseCase {
    byte[] execute(PaiementId paiementId);
}
