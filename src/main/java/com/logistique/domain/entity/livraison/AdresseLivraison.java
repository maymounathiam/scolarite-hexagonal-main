package com.logistique.domain.entity.livraison;

import com.logistique.domain.shared.EntityId;

public final class AdresseLivraison extends EntityId<String> {

    public AdresseLivraison(String value) {
        super(value == null ? "" : value.trim());
        if (value().isBlank()) {
            throw new IllegalArgumentException("Adresse de livraison obligatoire");
        }
    }
}
