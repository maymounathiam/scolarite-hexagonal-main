package com.logistique.application.command.iscription;

import com.logistique.application.command.paiement.DeclarerPaiementCommand;
import com.logistique.domain.entity.paiement.CanalPaiement;
import com.logistique.domain.entity.paiement.NombreDeMois;

import java.time.LocalDate;
import java.time.LocalTime;

public record CreerInscriptionCommand(
        String codeClasse,
        String matricule,
        String anneeAcademique,
        // données étudiant (optionnelles)
        String nom,
        String prenom,
        LocalDate dateNaissance,
        String typePaiement,
        CanalPaiement canalPaiement,
        String operateurMobileMoney,
        String referenceMobileMoney,
        String nomBanque,
        String referenceBancaire,
        double montantPaye,
        LocalDate datePaiement,
        LocalTime heurePaiement,
        String preuvePaiement,
        Integer nombreDeMois
) {}
