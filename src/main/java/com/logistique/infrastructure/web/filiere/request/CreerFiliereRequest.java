package com.logistique.infrastructure.web.filiere.request;

import java.math.BigDecimal;

public record CreerFiliereRequest(
        String codeClasse,
        String nomClasse
) {}
