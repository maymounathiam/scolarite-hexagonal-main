package com.logistique.domain.entity.academic;

import com.logistique.domain.event.anneeacademic.AnneeAcademiqueClotureeEvent;
import com.logistique.domain.event.anneeacademic.InscriptionsOuvertesEvent;
import com.logistique.domain.exception.ScolariteException;

public class InscriptionsSuspendues extends AbstractEtatAnnee {

    @Override
    public void ouvrirInscriptions(AnneeAcademique annee) {
        annee.changerEtat(new InscriptionsOuvertes());
    }

    @Override
    public void cloturer(AnneeAcademique annee) {
        annee.changerEtat(new AnneeCloturee());
    }

    @Override
    public void fermerInscriptions(AnneeAcademique annee) {

    }
}

