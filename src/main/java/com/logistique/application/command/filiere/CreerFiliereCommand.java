package com.logistique.application.command.filiere;

public record CreerFiliereCommand(
        String codeFiliere,
        String nomFiliere
) {}
