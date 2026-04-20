package com.logistique.infrastructure.web.anneeacdemique;

import com.logistique.application.command.anneeacademique.CreerAnneeAcademiqueCommand;
import com.logistique.application.command.anneeacademique.ModifierAnneeAcademiqueCommand;
import com.logistique.infrastructure.web.anneeacdemique.request.CreerAnneeAcademiqueRequest;

public class AnneeAcademiqueMapper {
    public static CreerAnneeAcademiqueCommand toCommand(
            CreerAnneeAcademiqueRequest req
    ) {
        return new CreerAnneeAcademiqueCommand(
                Integer.parseInt(req.code()),
                req.dateDebut(),
                req.dateFin(),
                req.dateDebutInscriptions(),
                req.dateFinInscriptions()
        );
    }

    public static ModifierAnneeAcademiqueCommand toModiferCommand(
            ModifierAnneeAcademiqueCommand req
    ) {
        return new ModifierAnneeAcademiqueCommand(
                req.code(),
                req.dateDebut(),
                req.dateFin(),
                req.dateDebutInscriptions(),
                req.dateFinInscriptions()
        );
    }
}
