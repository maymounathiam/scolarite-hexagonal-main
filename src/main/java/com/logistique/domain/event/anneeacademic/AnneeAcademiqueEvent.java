package com.logistique.domain.event.anneeacademic;

import com.logistique.domain.entity.academic.AnneeAcademique;
import com.logistique.domain.entity.academic.AnneeAcademiqueId;
import com.logistique.domain.event.shared.DomainEvent;

import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class AnneeAcademiqueEvent implements DomainEvent {

    private final AnneeAcademique annee;
    private final LocalDateTime occurredAt;
    private static final String AGGREGATE_TYPE = "AnneeAcademique";

    protected AnneeAcademiqueEvent(AnneeAcademique annee) {
        this.annee = annee;
        this.occurredAt = LocalDateTime.now();
    }

    public AnneeAcademique getAnnee() {
        return annee;
    }

    @Override
    public String aggregateType() {
        return AGGREGATE_TYPE;
    }

    @Override
    public String aggregateId() {
        return annee.getId().value(); // ex: "2025-2026"
    }

    @Override
    public LocalDateTime occurredAt() {
        return occurredAt;
    }
}
