package com.logistique.domain.entity.livraison;

import com.logistique.domain.shared.EntityId;

import java.util.UUID;

public final class LivraisonId extends EntityId<UUID> {

    public LivraisonId(UUID value) {
        super(value);
    }

    public static LivraisonId generer() {
        return new LivraisonId(UUID.randomUUID());
    }
}
