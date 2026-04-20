package com.logistique.application.command.classe;

import java.math.BigDecimal;

public record ModifierAutresFraisClasseCommand(
        String codeClasse,
        BigDecimal nouveauxAutresFrais
) {}
