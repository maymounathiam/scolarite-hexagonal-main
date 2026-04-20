package com.logistique.infrastructure.persistence.outbox.repository;

import com.logistique.infrastructure.persistence.outbox.entity.OutboxEventJpaEntity;
import com.logistique.infrastructure.persistence.outbox.entity.OutboxStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OutboxEventJpaRepository
        extends JpaRepository<OutboxEventJpaEntity, Long> {

    List<OutboxEventJpaEntity>
    findTop50ByStatusInOrderByOccurredAtAsc(
            List<OutboxStatus> statuses
    );
}
