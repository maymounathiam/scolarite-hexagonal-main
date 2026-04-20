package com.logistique.application.port.in.anneeacademique;

import com.logistique.application.command.anneeacademique.PublierAnneeAcademiqueCommand;

public interface PublierAnneeAcademiqueUseCase {
    void executer(PublierAnneeAcademiqueCommand command);
}
