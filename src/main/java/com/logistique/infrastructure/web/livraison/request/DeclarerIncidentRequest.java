package com.logistique.infrastructure.web.livraison.request;

import jakarta.validation.constraints.NotBlank;

public record DeclarerIncidentRequest(@NotBlank String motif) {
}
