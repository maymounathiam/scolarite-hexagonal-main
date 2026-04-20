package com.logistique.domain.event.inscription;

import com.logistique.domain.entity.academic.MoisAcademique;
import com.logistique.domain.entity.inscription.Inscription;
import com.logistique.domain.entity.inscription.InscriptionCreationSnapshot;
import com.logistique.domain.entity.inscription.InscriptionId;
import com.logistique.domain.entity.paiement.PaiementSnapshot;

import java.util.List;

public class InscriptionCreeeEvent extends InscriptionEvent{
    private final InscriptionCreationSnapshot inscriptionCreationSnapshot;

    public InscriptionCreeeEvent(InscriptionCreationSnapshot inscriptionCreationSnapshot) {
        super(inscriptionCreationSnapshot.inscriptionId());
        this.inscriptionCreationSnapshot = inscriptionCreationSnapshot;
    }

    public InscriptionCreationSnapshot getInscriptionCreationSnapshot() {
        return inscriptionCreationSnapshot;
    }

    public String getSagaId() {
        return inscriptionCreationSnapshot.sagaId();
    }
}
