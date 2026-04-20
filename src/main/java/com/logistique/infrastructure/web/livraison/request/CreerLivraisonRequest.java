package com.logistique.infrastructure.web.livraison.request;

import jakarta.validation.constraints.NotBlank;

public record CreerLivraisonRequest(
        @NotBlank String referenceColis,
        @NotBlank String adresse
) {
}
