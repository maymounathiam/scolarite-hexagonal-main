package com.logistique.application.port.out.event;

import com.logistique.domain.event.shared.DomainEvent;

import java.util.List;

public interface DomainEventPublisher {
    void publish(DomainEvent events);
}
