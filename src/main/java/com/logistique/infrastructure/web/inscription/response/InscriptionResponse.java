package com.logistique.infrastructure.web.inscription.response;

public record InscriptionResponse(
        String matricule,
        String anneeAcademique,
        String codeClasse
) {}
