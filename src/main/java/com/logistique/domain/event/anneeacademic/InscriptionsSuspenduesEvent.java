package com.logistique.domain.event.anneeacademic;

import com.logistique.domain.entity.academic.AnneeAcademique;
import com.logistique.domain.entity.academic.AnneeAcademiqueId;

public class InscriptionsSuspenduesEvent extends AnneeAcademiqueEvent {

    public InscriptionsSuspenduesEvent(AnneeAcademique annee) {
        super(annee);
    }
}
