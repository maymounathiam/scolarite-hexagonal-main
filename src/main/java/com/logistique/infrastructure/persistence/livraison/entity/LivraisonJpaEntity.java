package com.logistique.infrastructure.persistence.livraison.entity;

import com.logistique.domain.entity.livraison.StatutLivraison;
import com.logistique.infrastructure.persistence.livreur.entity.LivreurJpaEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "livraison")
public class LivraisonJpaEntity {

    @Id
    private UUID id;

    @Column(length = 64, unique = true, nullable = false)
    private String referenceColis;

    @Column(length = 500, nullable = false)
    private String adresse;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 40)
    private StatutLivraison statut;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "livreur_id")
    private LivreurJpaEntity livreur;

    @Column(length = 500)
    private String motifIncident;
}
