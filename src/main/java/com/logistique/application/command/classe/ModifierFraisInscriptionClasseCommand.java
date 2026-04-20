package com.logistique.application.command.classe;

import java.math.BigDecimal;

public record ModifierFraisInscriptionClasseCommand(
        String codeClasse,
        BigDecimal nouveauxFraisInscription
) {}
