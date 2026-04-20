package com.logistique.application.port.in.livreur;

import com.logistique.application.command.livreur.CreerLivreurCommand;

import java.util.UUID;

public interface CreerLivreurUseCase {

    UUID executer(CreerLivreurCommand command);
}
