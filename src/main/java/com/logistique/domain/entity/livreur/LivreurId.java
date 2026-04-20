package com.logistique.domain.entity.livreur;

import com.logistique.domain.shared.EntityId;

import java.util.UUID;

public final class LivreurId extends EntityId<UUID> {

    public LivreurId(UUID value) {
        super(value);
    }

    public static LivreurId generer() {
        return new LivreurId(UUID.randomUUID());
    }
}
