package com.logistique.domain.event.paiement;

import com.logistique.domain.entity.inscription.InscriptionId;
import com.logistique.domain.event.shared.DomainEvent;

import java.time.LocalDateTime;

public class PaiementInitialEchoueEvent implements DomainEvent {
    private final InscriptionId inscriptionId;
    private final String sagaId;
    private final String message;

    public PaiementInitialEchoueEvent(InscriptionId inscriptionId, String sagaId, String message) {
        this.inscriptionId = inscriptionId;
        this.sagaId = sagaId;
        this.message = message;
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

    public InscriptionId getInscriptionId() {
        return inscriptionId;
    }

    public String getSagaId() {
        return sagaId;
    }

    public String getMessage() {
        return message;
    }
}
