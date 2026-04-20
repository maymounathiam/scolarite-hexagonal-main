package com.logistique.domain.entity.school;

import com.logistique.domain.shared.EntityId;

public final class NomFiliere extends EntityId<String> {
    public NomFiliere(String value) {
        super(value);
        value = value.trim().replaceAll("\\s+", " ").toUpperCase();
    }
}