package com.logistique.infrastructure.persistence.livreur.mapper;

import com.logistique.domain.entity.livreur.Livreur;
import com.logistique.domain.entity.livreur.LivreurId;
import com.logistique.domain.entity.livreur.NomLivreur;
import com.logistique.infrastructure.persistence.livreur.entity.LivreurJpaEntity;
import org.springframework.stereotype.Component;

@Component
public class LivreurPersistenceMapper {

    public Livreur toDomain(LivreurJpaEntity entity) {
        return new Livreur(
                new LivreurId(entity.getId()),
                new NomLivreur(entity.getNom())
        );
    }

    public LivreurJpaEntity toJpa(Livreur domain) {
        LivreurJpaEntity entity = new LivreurJpaEntity();
        entity.setId(domain.getId().value());
        entity.setNom(domain.getNom().value());
        return entity;
    }
}
