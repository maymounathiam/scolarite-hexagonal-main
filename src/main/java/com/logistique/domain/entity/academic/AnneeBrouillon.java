package com.logistique.domain.entity.academic;

import com.logistique.domain.event.anneeacademic.AnneeAcademiqueCreeeEvent;
import com.logistique.domain.event.anneeacademic.AnneeAcademiquePublieeEvent;

public class AnneeBrouillon extends AbstractEtatAnnee {

    @Override
    public void creer(AnneeAcademique annee, DatesAnnee datesAnnee) {
        // règles métier avant publication
        annee.initialiserDates(datesAnnee);
        annee.verifierDureeAnnee();
        annee.recalculerMois(annee.genererMoisAcademiques());
    }

    @Override
    public void modifier(AnneeAcademique annee, DatesAnnee datesAnnee) {
        // règles métier avant publication
        annee.initialiserDates(datesAnnee);
        annee.verifierDureeAnnee();
        annee.recalculerMois(annee.genererMoisAcademiques());
    }

    @Override
    public void publier(AnneeAcademique annee) {
        annee.changerEtat(new AnneePubliee());
    }
}
