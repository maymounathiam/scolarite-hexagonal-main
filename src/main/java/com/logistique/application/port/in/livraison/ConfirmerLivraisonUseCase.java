package com.logistique.application.port.in.livraison;

import com.logistique.application.command.livraison.ConfirmerLivraisonCommand;

public interface ConfirmerLivraisonUseCase {

    void executer(ConfirmerLivraisonCommand command);
}
