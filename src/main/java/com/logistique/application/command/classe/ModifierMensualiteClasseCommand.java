package com.logistique.application.command.classe;

import java.math.BigDecimal;

public record ModifierMensualiteClasseCommand(
        String codeClasse,
        BigDecimal nouvelleMensualite
) {}
