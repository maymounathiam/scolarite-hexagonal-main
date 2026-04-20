package com.logistique.application.command.livraison;

import java.util.UUID;

public record ConfirmerLivraisonCommand(UUID livraisonId) {
}
