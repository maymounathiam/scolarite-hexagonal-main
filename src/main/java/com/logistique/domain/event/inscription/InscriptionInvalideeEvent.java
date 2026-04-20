package com.logistique.domain.event.inscription;

import com.logistique.domain.entity.inscription.InscriptionId;

public class InscriptionInvalideeEvent extends InscriptionEvent{
    private final String motif;
    public InscriptionInvalideeEvent(InscriptionId inscriptionId, String motif){
        super(inscriptionId);
        this.motif = motif;
    }

    public String getMotif() {
        return motif;
    }
}
