package com.logistique.infrastructure.web.livraison.request;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record AssignerLivreurRequest(
        @NotNull UUID livreurId
) {
}
