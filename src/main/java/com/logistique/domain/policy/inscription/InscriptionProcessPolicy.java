package com.logistique.domain.policy.inscription;


import com.logistique.domain.entity.academic.AnneeAcademique;
import org.springframework.stereotype.Component;

@Component
public class InscriptionProcessPolicy {
    public void verifierInscriptionAutorisee(AnneeAcademique annee) {
        annee.verifierInscriptionsOuvertes();
    }
}

