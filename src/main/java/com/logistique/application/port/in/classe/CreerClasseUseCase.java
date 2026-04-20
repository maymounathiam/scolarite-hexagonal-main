package com.logistique.application.port.in.classe;

import com.logistique.application.command.classe.CreerClasseCommand;

public interface CreerClasseUseCase {
    void executer(CreerClasseCommand command);
}
