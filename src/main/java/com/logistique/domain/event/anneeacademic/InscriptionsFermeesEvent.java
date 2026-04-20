package com.logistique.domain.event.anneeacademic;

import com.logistique.domain.entity.academic.AnneeAcademique;
import com.logistique.domain.entity.academic.AnneeAcademiqueId;

public class InscriptionsFermeesEvent extends AnneeAcademiqueEvent {
    public InscriptionsFermeesEvent(AnneeAcademique annee) {
        super(annee);
    }
}
