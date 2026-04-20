package com.logistique.infrastructure.event.outbox.publisher;

import com.logistique.application.port.out.event.DomainEventPublisher;
import com.logistique.domain.event.shared.DomainEvent;
import com.logistique.infrastructure.event.SpringDomainEventPublisher;
import com.logistique.infrastructure.event.outbox.OutboxDomainEventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("mysql")
@Primary
@RequiredArgsConstructor
public class CompositeDomainEventPublisher implements DomainEventPublisher {

    private final OutboxDomainEventPublisher outboxPublisher;
    private final SpringDomainEventPublisher springPublisher;

    @Override
    public void publish(DomainEvent event) {
        // 1. Outbox (inter-services)
        outboxPublisher.publish(event);

        // 2. Spring event (in-process)
        springPublisher.publish(event);
    }
}

