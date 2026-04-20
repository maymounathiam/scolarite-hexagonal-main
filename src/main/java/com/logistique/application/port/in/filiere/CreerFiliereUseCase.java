package com.logistique.application.port.in.filiere;

import com.logistique.application.command.filiere.CreerFiliereCommand;

public interface CreerFiliereUseCase {
    public void executer(CreerFiliereCommand cmd);
}
