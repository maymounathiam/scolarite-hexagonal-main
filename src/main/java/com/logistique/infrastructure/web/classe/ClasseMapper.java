package com.logistique.infrastructure.web.classe;

import com.logistique.application.command.classe.CreerClasseCommand;
import com.logistique.application.command.classe.ModifierAutresFraisClasseCommand;
import com.logistique.application.command.classe.ModifierMensualiteClasseCommand;
import com.logistique.application.command.classe.ModifierFraisInscriptionClasseCommand;
import com.logistique.infrastructure.web.classe.request.CreerClasseRequest;
import com.logistique.infrastructure.web.classe.request.ModifierAutresFraisRequest;
import com.logistique.infrastructure.web.classe.request.ModifierFraisInscriptionRequest;
import com.logistique.infrastructure.web.classe.request.ModifierMensualiteRequest;
import org.springframework.stereotype.Component;

@Component
public class ClasseMapper {

    public CreerClasseCommand toCommand(CreerClasseRequest request) {
        return new CreerClasseCommand(
                request.codeClasse(),
                request.nomClasse(),
                request.codeFiliere(),
                request.fraisInscription(),
                request.mensualite(),
                request.autresFrais()
        );
    }

    public ModifierFraisInscriptionClasseCommand toCommand(ModifierFraisInscriptionRequest request, String codeClasse) {
        return new ModifierFraisInscriptionClasseCommand(codeClasse, request.nouveauMontant());
    }

    public ModifierMensualiteClasseCommand toCommand(ModifierMensualiteRequest request, String codeClasse) {
        return new ModifierMensualiteClasseCommand(codeClasse, request.nouvelleMensualite());
    }

    public ModifierAutresFraisClasseCommand toCommand(ModifierAutresFraisRequest request, String codeClasse) {
        return new ModifierAutresFraisClasseCommand(codeClasse, request.nouveauxAutresFrais());
    }
}
