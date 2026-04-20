package com.logistique.application.port.in.paiement;

import com.logistique.application.query.paiement.ConsulterPaiementQuery;
import com.logistique.application.query.paiement.PaiementView;

import java.util.List;

public interface ConsulterPaiementsUseCase {
    List<PaiementView> execute(ConsulterPaiementQuery consulterPaiementQuery);
}
