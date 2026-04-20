package com.logistique.domain.entity.academic;

import com.logistique.domain.event.anneeacademic.AnneeAcademiqueClotureeEvent;
import com.logistique.domain.event.anneeacademic.InscriptionsOuvertesEvent;

public class InscriptionsFermees extends AbstractEtatAnnee{
    @Override
    public void ouvrirInscriptions(AnneeAcademique annee) {
        annee.changerEtat(new InscriptionsOuvertes());
    }

    @Override
    public void cloturer(AnneeAcademique annee) {
        annee.changerEtat(new AnneeCloturee());
    }

}
