package com.logistique.application.port.in.livraison;

import com.logistique.application.command.livraison.DemarrerLivraisonCommand;

public interface DemarrerLivraisonUseCase {

    void executer(DemarrerLivraisonCommand command);
}
