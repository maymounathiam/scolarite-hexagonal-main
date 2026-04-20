package com.logistique.domain.entity.livreur;

import com.logistique.domain.shared.EntityId;

public final class NomLivreur extends EntityId<String> {

    public NomLivreur(String value) {
        super(value == null ? "" : value.trim());
        if (value().isBlank()) {
            throw new IllegalArgumentException("Nom du livreur obligatoire");
        }
    }
}
