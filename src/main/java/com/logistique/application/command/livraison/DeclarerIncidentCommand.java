package com.logistique.application.command.livraison;

import java.util.UUID;

public record DeclarerIncidentCommand(UUID livraisonId, String motif) {
}
