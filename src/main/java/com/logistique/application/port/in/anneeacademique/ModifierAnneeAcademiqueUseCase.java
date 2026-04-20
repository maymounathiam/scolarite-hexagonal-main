package com.logistique.application.port.in.anneeacademique;

import com.logistique.application.command.anneeacademique.ModifierAnneeAcademiqueCommand;

public interface ModifierAnneeAcademiqueUseCase {
    void executer(ModifierAnneeAcademiqueCommand command);

}
