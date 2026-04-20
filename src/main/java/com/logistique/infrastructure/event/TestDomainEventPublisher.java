package com.logistique.infrastructure.event;

import com.logistique.application.port.out.event.DomainEventPublisher;
import com.logistique.domain.event.shared.DomainEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Profile("test")
public class TestDomainEventPublisher implements DomainEventPublisher {
    private final List<DomainEvent> publishedEvents = new ArrayList<>();

    @Override
    public void publish(DomainEvent event) {
        publishedEvents.add(event);
    }

    public List<DomainEvent> events() {
        return publishedEvents;
    }

    public void clear() {
        publishedEvents.clear();
    }
}
