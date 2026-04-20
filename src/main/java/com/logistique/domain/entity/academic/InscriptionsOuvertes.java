package com.logistique.domain.entity.academic;

import com.logistique.domain.event.anneeacademic.InscriptionsFermeesEvent;
import com.logistique.domain.event.anneeacademic.InscriptionsSuspenduesEvent;

public class InscriptionsOuvertes extends AbstractEtatAnnee{

    @Override
    public void suspendreInscriptions(AnneeAcademique annee) {
        annee.changerEtat(new InscriptionsSuspendues());
    }

    @Override
    public void fermerInscriptions(AnneeAcademique annee) {
        annee.changerEtat(new InscriptionsFermees());
    }

    @Override
    public void verifierInscriptionsOuvertes() {

    }
}
