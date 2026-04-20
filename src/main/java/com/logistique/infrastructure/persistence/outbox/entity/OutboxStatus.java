package com.logistique.infrastructure.persistence.outbox.entity;

public enum OutboxStatus {
    PENDING,
    PUBLISHED,
    FAILED
}
