package com.logistique.application.query.livraison;

import com.logistique.domain.entity.livraison.StatutLivraison;

import java.util.UUID;

public record LivraisonSuiviView(
        UUID livraisonId,
        String referenceColis,
        String adresse,
        StatutLivraison statut,
        UUID livreurId,
        String motifIncident
) {
}
