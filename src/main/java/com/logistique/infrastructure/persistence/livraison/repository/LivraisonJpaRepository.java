package com.logistique.infrastructure.persistence.livraison.repository;

import com.logistique.infrastructure.persistence.livraison.entity.LivraisonJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface LivraisonJpaRepository extends JpaRepository<LivraisonJpaEntity, UUID> {

    @Query("""
            select l from LivraisonJpaEntity l
            left join fetch l.livreur
            where l.id = :id
            """)
    Optional<LivraisonJpaEntity> findWithLivreurById(@Param("id") UUID id);

    @Query("""
            select l from LivraisonJpaEntity l
            left join fetch l.livreur
            where l.referenceColis = :referenceColis
            """)
    Optional<LivraisonJpaEntity> findWithLivreurByReferenceColis(@Param("referenceColis") String referenceColis);

    boolean existsByReferenceColis(String referenceColis);

    @Query("""
            select count(l) from LivraisonJpaEntity l
            where l.livreur.id = :livreurId
            and l.statut in ('ASSIGNEE','EN_COURS','BLOQUEE_PAR_INCIDENT')
            """)
    long compterActivesPour(@Param("livreurId") UUID livreurId);
}
