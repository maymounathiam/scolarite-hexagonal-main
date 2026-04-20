package com.logistique.domain.event.inscription;

import com.logistique.domain.entity.inscription.InscriptionId;

public class InscriptionConfirmeeEvent extends InscriptionEvent{
    public InscriptionConfirmeeEvent(InscriptionId inscriptionId){
        super(inscriptionId);
    }
}
