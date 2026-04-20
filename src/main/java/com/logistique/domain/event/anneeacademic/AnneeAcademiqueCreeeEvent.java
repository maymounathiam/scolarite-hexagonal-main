package com.logistique.domain.event.anneeacademic;

import com.logistique.domain.entity.academic.AnneeAcademique;
import com.logistique.domain.entity.academic.AnneeAcademiqueId;

public class AnneeAcademiqueCreeeEvent extends AnneeAcademiqueEvent {

    public AnneeAcademiqueCreeeEvent(AnneeAcademique annee) {
        super(annee);
    }
}

