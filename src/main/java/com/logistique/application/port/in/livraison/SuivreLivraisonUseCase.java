package com.logistique.application.port.in.livraison;

import com.logistique.application.query.livraison.LivraisonSuiviView;

import java.util.UUID;

public interface SuivreLivraisonUseCase {

    LivraisonSuiviView consulterParId(UUID livraisonId);

    LivraisonSuiviView consulterParReference(String referenceColis);
}
