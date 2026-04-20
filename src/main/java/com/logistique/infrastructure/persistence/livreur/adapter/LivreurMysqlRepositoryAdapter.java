package com.logistique.infrastructure.persistence.livreur.adapter;

import com.logistique.application.port.out.repository.LivreurRepository;
import com.logistique.domain.entity.livreur.Livreur;
import com.logistique.domain.entity.livreur.LivreurId;
import com.logistique.infrastructure.persistence.livreur.mapper.LivreurPersistenceMapper;
import com.logistique.infrastructure.persistence.livreur.repository.LivreurJpaRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Profile("mysql")
public class LivreurMysqlRepositoryAdapter implements LivreurRepository {

    private final LivreurJpaRepository livreurJpaRepository;
    private final LivreurPersistenceMapper mapper;

    public LivreurMysqlRepositoryAdapter(
            LivreurJpaRepository livreurJpaRepository,
            LivreurPersistenceMapper mapper
    ) {
        this.livreurJpaRepository = livreurJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public void save(Livreur livreur) {
        livreurJpaRepository.save(mapper.toJpa(livreur));
    }

    @Override
    public Optional<Livreur> findById(LivreurId id) {
        return livreurJpaRepository.findById(id.value()).map(mapper::toDomain);
    }
}
