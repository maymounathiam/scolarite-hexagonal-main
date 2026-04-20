package com.logistique.domain.event.paiement;

import com.logistique.domain.entity.inscription.InscriptionId;
import com.logistique.domain.event.shared.DomainEvent;

import java.time.LocalDateTime;

public class PaiementInitialValideEvent implements DomainEvent{
    private final InscriptionId inscriptionId;
    private final String sagaId;

    public PaiementInitialValideEvent(InscriptionId inscriptionId, String sagaId) {
        this.inscriptionId = inscriptionId;
        this.sagaId = sagaId;
    }

    @Override
    public String aggregateId() {
        return "";
    }

    @Override
    public String aggregateType() {
        return "";
    }

    @Override
    public LocalDateTime occurredAt() {
        return null;
    }
}
