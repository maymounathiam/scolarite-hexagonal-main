package com.logistique.infrastructure.web.classe.request;

import java.math.BigDecimal;

public record ModifierMensualiteRequest(
        BigDecimal nouvelleMensualite
) {}
