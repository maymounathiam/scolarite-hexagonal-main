package com.logistique.domain.entity.inscription;

import com.logistique.domain.entity.academic.MoisAcademique;
import com.logistique.domain.entity.paiement.PaiementSnapshot;
import com.logistique.domain.entity.school.CodeClasse;

import java.util.List;

public record InscriptionCreationSnapshot(
        InscriptionId inscriptionId,
        CodeClasse codeClasse,
        PaiementSnapshot paiementSnapshot,
        List<MoisAcademique> moisAcademiques,
        String sagaId
) {
}
