package com.logistique.infrastructure.persistence.livreur.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "livreur")
public class LivreurJpaEntity {

    @Id
    private UUID id;

    @Column(length = 120, nullable = false)
    private String nom;
}
