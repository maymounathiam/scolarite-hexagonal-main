package com.logistique.infrastructure.persistence.livraison.mapper;

import com.logistique.domain.entity.livraison.*;
import com.logistique.domain.entity.livreur.LivreurId;
import com.logistique.infrastructure.persistence.livraison.entity.LivraisonJpaEntity;
import com.logistique.infrastructure.persistence.livreur.entity.LivreurJpaEntity;
import com.logistique.infrastructure.persistence.livreur.repository.LivreurJpaRepository;
import org.springframework.stereotype.Component;

@Component
public class LivraisonPersistenceMapper {

    private final LivreurJpaRepository livreurJpaRepository;

    public LivraisonPersistenceMapper(LivreurJpaRepository livreurJpaRepository) {
        this.livreurJpaRepository = livreurJpaRepository;
    }

    public Livraison toDomain(LivraisonJpaEntity entity) {
        LivreurId livreurId = entity.getLivreur() != null
                ? new LivreurId(entity.getLivreur().getId())
                : null;
        return Livraison.reconstituer(
                new LivraisonId(entity.getId()),
                new ReferenceColis(entity.getReferenceColis()),
                new AdresseLivraison(entity.getAdresse()),
                entity.getStatut(),
                livreurId,
                entity.getMotifIncident()
        );
    }

    public LivraisonJpaEntity toJpa(Livraison domain) {
        LivraisonJpaEntity entity = new LivraisonJpaEntity();
        entity.setId(domain.getId().value());
        entity.setReferenceColis(domain.getReference().value());
        entity.setAdresse(domain.getAdresse().value());
        entity.setStatut(domain.getStatut());
        entity.setMotifIncident(domain.getMotifIncident());
        if (domain.getLivreurId() != null) {
            LivreurJpaEntity ref = livreurJpaRepository.getReferenceById(domain.getLivreurId().value());
            entity.setLivreur(ref);
        } else {
            entity.setLivreur(null);
        }
        return entity;
    }
}
