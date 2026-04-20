package com.logistique.application.port.in.inscription;

import com.logistique.application.command.iscription.TransfererEtudiantCommand;

public interface TransfererEtudiantUseCase {
    void executer(TransfererEtudiantCommand cmd);
}
