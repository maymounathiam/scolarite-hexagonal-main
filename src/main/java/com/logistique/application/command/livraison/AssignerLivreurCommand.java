package com.logistique.application.command.livraison;

import java.util.UUID;

public record AssignerLivreurCommand(UUID livraisonId, UUID livreurId) {
}
