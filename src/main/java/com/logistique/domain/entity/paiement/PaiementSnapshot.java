package com.logistique.domain.entity.paiement;

import com.logistique.domain.entity.academic.AnneeAcademiqueId;
import com.logistique.domain.entity.school.Montant;
import com.logistique.domain.entity.student.Matricule;

import java.time.LocalDate;
import java.time.LocalTime;

public record PaiementSnapshot(
        Matricule matricule,
        AnneeAcademiqueId anneeAcademiqueId,
        TypePaiement typePaiement,
        CanalPaiement canalPaiement,
        String operateurMobileMoney,
        String referenceMobileMoney,
        String nomBanque,
        String referenceBancaire,
        Montant montantPaye,
        LocalDate datePaiement,
        LocalTime heurePaiement,
        String urlPreuve,
        Integer periodePaiement
) {}

