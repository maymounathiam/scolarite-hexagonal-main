package com.logistique.domain.shared;

public interface AggregateRoot<ID extends EntityId<?>> {
    ID getId();
}
