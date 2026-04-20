package com.logistique.application.command.paiement;

import com.logistique.domain.entity.academic.MoisAcademique;

import java.util.List;

public record EtatInscriptionData(

        String matricule,
        String nom,
        String classe,

        String fraisInscription,
        String fraisDivers,

        String dernierMois,
        String montantDernierMois,
        String natureDernierMois,

        List<MoisAcademique> mensualites,

        String totalAPayer,
        String totalPaye,
        String resteGlobal

) {}
