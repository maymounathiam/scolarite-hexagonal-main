package com.logistique.domain.entity.paiement;

import com.logistique.domain.shared.EntityId;

import java.util.UUID;

public final class PaiementId extends EntityId<UUID> {

    public PaiementId(UUID value) {
        super(value);
    }

    public static PaiementId generate() {
        return new PaiementId(UUID.randomUUID());
    }
}

