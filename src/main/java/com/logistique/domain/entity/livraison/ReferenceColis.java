package com.logistique.domain.entity.livraison;

import com.logistique.domain.shared.EntityId;

public final class ReferenceColis extends EntityId<String> {

    public ReferenceColis(String value) {
        super(value == null ? "" : value.trim());
        if (value().isBlank()) {
            throw new IllegalArgumentException("Référence colis obligatoire");
        }
    }
}
