package com.logistique.domain.event.anneeacademic;

import com.logistique.domain.entity.academic.AnneeAcademique;
import com.logistique.domain.entity.academic.AnneeAcademiqueId;

public class AnneeAcademiqueModifieEvent extends AnneeAcademiqueEvent {
    public AnneeAcademiqueModifieEvent(AnneeAcademique annee) {
        super(annee);
    }
}
