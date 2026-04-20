package com.logistique.application.port.in.classe;

import com.logistique.application.command.classe.ModifierMensualiteClasseCommand;

public interface ModifierMensualiteClasseUseCase {
    void executer(ModifierMensualiteClasseCommand command);
}
