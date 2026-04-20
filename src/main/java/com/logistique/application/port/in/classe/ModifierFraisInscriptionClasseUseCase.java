package com.logistique.application.port.in.classe;

import com.logistique.application.command.classe.ModifierFraisInscriptionClasseCommand;

public interface ModifierFraisInscriptionClasseUseCase {
    void executer(ModifierFraisInscriptionClasseCommand command);
}
