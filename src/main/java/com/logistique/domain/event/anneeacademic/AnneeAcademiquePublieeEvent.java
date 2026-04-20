package com.logistique.domain.event.anneeacademic;

import com.logistique.domain.entity.academic.AnneeAcademique;
import com.logistique.domain.entity.academic.AnneeAcademiqueId;

public class AnneeAcademiquePublieeEvent extends AnneeAcademiqueEvent {


    public AnneeAcademiquePublieeEvent(AnneeAcademique annee) {
        super(annee);
    }

}

