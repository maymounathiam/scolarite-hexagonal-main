package com.logistique.application.port.in.anneeacademique;

import com.logistique.application.command.anneeacademique.FermerInscriptionCommand;
import com.logistique.application.command.anneeacademique.OuvrirInscriptionCommand;

public interface FermerInscriptionUseCase {
    void executer(FermerInscriptionCommand command);
}
