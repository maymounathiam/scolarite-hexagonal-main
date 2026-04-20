package com.logistique.domain.entity.school;

import com.logistique.domain.shared.EntityId;

public final class CodeClasse extends EntityId<String> {
    public CodeClasse(String value) {
        super(value);
        value = value.trim().replaceAll("\\s+", " ").toUpperCase();

        if (!value.matches("[A-Z0-9-]+( [A-Z0-9-]+)*")) {
            throw new IllegalArgumentException(value);
        }
    }
}
