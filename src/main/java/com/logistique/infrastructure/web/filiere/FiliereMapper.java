package com.logistique.infrastructure.web.filiere;

import com.logistique.application.command.filiere.CreerFiliereCommand;
import com.logistique.infrastructure.web.filiere.request.CreerFiliereRequest;
import org.springframework.stereotype.Component;

@Component
public class FiliereMapper {
    public CreerFiliereCommand toCommand(CreerFiliereRequest creerFiliereRequest){
        return new CreerFiliereCommand(
                creerFiliereRequest.codeClasse(),
                creerFiliereRequest.nomClasse()
        );
    }
}
