package com.logistique.infrastructure.web.classe.request;

import java.math.BigDecimal;

public record CreerClasseRequest(
        String codeClasse,
        String nomClasse,
        String codeFiliere,
        String nomFiliere,
        BigDecimal fraisInscription,
        BigDecimal mensualite,
        BigDecimal autresFrais
) {}
