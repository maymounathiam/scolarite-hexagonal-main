package com.logistique.application.port.in.livraison;

import com.logistique.application.command.livraison.AssignerLivreurCommand;

public interface AssignerLivreurUseCase {

    void executer(AssignerLivreurCommand command);
}
