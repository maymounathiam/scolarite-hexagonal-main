package com.logistique.infrastructure.persistence.livraison.adapter;

import com.logistique.application.port.out.repository.LivraisonRepository;
import com.logistique.domain.entity.livraison.Livraison;
import com.logistique.domain.entity.livraison.LivraisonId;
import com.logistique.domain.entity.livraison.ReferenceColis;
import com.logistique.domain.entity.livreur.LivreurId;
import com.logistique.infrastructure.persistence.livraison.mapper.LivraisonPersistenceMapper;
import com.logistique.infrastructure.persistence.livraison.repository.LivraisonJpaRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Profile("mysql")
public class LivraisonMysqlRepositoryAdapter implements LivraisonRepository {

    private final LivraisonJpaRepository livraisonJpaRepository;
    private final LivraisonPersistenceMapper mapper;

    public LivraisonMysqlRepositoryAdapter(
            LivraisonJpaRepository livraisonJpaRepository,
            LivraisonPersistenceMapper mapper
    ) {
        this.livraisonJpaRepository = livraisonJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public void save(Livraison livraison) {
        livraisonJpaRepository.save(mapper.toJpa(livraison));
    }

    @Override
    public Optional<Livraison> findById(LivraisonId id) {
        return livraisonJpaRepository.findWithLivreurById(id.value()).map(mapper::toDomain);
    }

    @Override
    public Optional<Livraison> findByReference(ReferenceColis reference) {
        return livraisonJpaRepository.findWithLivreurByReferenceColis(reference.value()).map(mapper::toDomain);
    }

    @Override
    public boolean existsByReference(ReferenceColis reference) {
        return livraisonJpaRepository.existsByReferenceColis(reference.value());
    }

    @Override
    public int compterLivraisonsActivesPour(LivreurId livreurId) {
        return (int) livraisonJpaRepository.compterActivesPour(livreurId.value());
    }
}
