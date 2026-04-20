package com.logistique.application.port.in.anneeacademique;

import com.logistique.application.command.anneeacademique.SuspendreInscriptionCommand;

public interface SuspendreInscriptionUseCase {
    void executer(SuspendreInscriptionCommand command);
}
