package com.logistique.domain.policy.inscription;

import com.logistique.domain.entity.school.CodeClasse;

import java.time.LocalDate;

public interface RegleTransfert {

    boolean estAutorise(
            LocalDate dateInscription,
            LocalDate dateTransfert,
            CodeClasse codeClasseOrigine,
            CodeClasse codeClasseDestination
    );
}
