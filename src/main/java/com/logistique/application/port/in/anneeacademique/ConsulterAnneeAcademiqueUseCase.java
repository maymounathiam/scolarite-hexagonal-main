package com.logistique.application.port.in.anneeacademique;

import com.logistique.application.query.anneeacademique.AnneeAcademiqueView;

public interface ConsulterAnneeAcademiqueUseCase {
    AnneeAcademiqueView executer(String code);
}
