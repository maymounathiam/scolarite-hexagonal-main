package com.logistique.application.command.iscription;

import java.time.LocalDate;

public record TransfererEtudiantCommand(
        String matricule,
        String codeClasseOrigine,
        String codeNouvelleClasse,
        String anneeAcademique,
        LocalDate dateTransfert
) {}
