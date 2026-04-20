package com.logistique.application.port.in.anneeacademique;

import com.logistique.application.command.anneeacademique.CreerAnneeAcademiqueCommand;

public interface CreerAnneeAcademiqueUseCase {
    void executer(CreerAnneeAcademiqueCommand command);
}
