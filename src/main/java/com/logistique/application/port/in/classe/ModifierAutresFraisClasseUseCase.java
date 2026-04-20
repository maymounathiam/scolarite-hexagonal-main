package com.logistique.application.port.in.classe;

import com.logistique.application.command.classe.ModifierAutresFraisClasseCommand;

public interface ModifierAutresFraisClasseUseCase {
    void executer(ModifierAutresFraisClasseCommand command);
}
