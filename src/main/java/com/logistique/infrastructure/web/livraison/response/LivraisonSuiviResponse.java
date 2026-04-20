package com.logistique.infrastructure.web.livraison.response;

import com.logistique.domain.entity.livraison.StatutLivraison;

import java.util.UUID;

public record LivraisonSuiviResponse(
        UUID livraisonId,
        String referenceColis,
        String adresse,
        StatutLivraison statut,
        UUID livreurId,
        String motifIncident
) {
}
