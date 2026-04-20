package com.logistique.application.port.in.anneeacademique;

import com.logistique.application.command.anneeacademique.OuvrirInscriptionCommand;

public interface OuvrirInscriptionUseCase {
    void executer(OuvrirInscriptionCommand command);
}
