package com.logistique.application.port.in.anneeacademique;

import com.logistique.application.command.anneeacademique.CloturerAnneeAcademiqueCommand;

public interface CloturerAnneeScolaireUseCase {
    void executer(CloturerAnneeAcademiqueCommand command);
}
