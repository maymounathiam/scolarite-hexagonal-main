package com.logistique.infrastructure.event.outbox;

import com.logistique.application.port.out.event.DomainEventPublisher;
import com.logistique.domain.event.shared.DomainEvent;
import com.logistique.infrastructure.persistence.outbox.mapper.OutboxEventMapper;
import com.logistique.infrastructure.persistence.outbox.repository.OutboxEventJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("mysql")
@RequiredArgsConstructor
public class OutboxDomainEventPublisher implements DomainEventPublisher {

    private final OutboxEventJpaRepository repository;
    private final OutboxEventMapper mapper;

    @Override
    public void publish(DomainEvent event) {
        repository.save(mapper. toJpa(event));
    }
}
