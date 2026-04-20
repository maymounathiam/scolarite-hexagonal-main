package com.logistique.domain.entity.academic;

import com.logistique.domain.exception.ScolariteException;
import com.logistique.domain.shared.EntityId;

public final class AnneeAcademiqueId extends EntityId<String> {
    private final int debut;
    private final int fin;

    public AnneeAcademiqueId(int debut) {
        super(validerEtConstruire(debut, debut + 1));
        this.debut = debut;
        this.fin = debut + 1;
    }

    private static String validerEtConstruire(int debut, int fin) {
        if (fin != debut + 1) {
            throw new ScolariteException(
                    "Une année académique doit couvrir deux années consécutives"
            );
        }
        return debut + "-" + fin;
    }

    public int debut() {
        return debut;
    }

    public int fin() {
        return fin;
    }

    @Override
    public String toString() {
        return debut + "-" + fin;
    }
}
