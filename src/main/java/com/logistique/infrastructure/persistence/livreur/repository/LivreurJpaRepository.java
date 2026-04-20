package com.logistique.infrastructure.persistence.livreur.repository;

import com.logistique.infrastructure.persistence.livreur.entity.LivreurJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LivreurJpaRepository extends JpaRepository<LivreurJpaEntity, UUID> {
}
