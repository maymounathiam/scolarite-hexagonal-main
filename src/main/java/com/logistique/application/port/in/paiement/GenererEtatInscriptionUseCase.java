package com.logistique.application.port.in.paiement;

import com.logistique.domain.entity.inscription.InscriptionId;

public interface GenererEtatInscriptionUseCase {
    byte[] execute(InscriptionId inscriptionId);
}
