package com.logistique.application.port.in.livraison;

import com.logistique.application.command.livraison.CreerLivraisonCommand;

import java.util.UUID;

public interface CreerLivraisonUseCase {

    UUID executer(CreerLivraisonCommand command);
}
