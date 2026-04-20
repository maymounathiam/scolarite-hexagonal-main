package com.logistique.application.port.out.repository.impl;

import com.logistique.application.port.out.repository.LivreurRepository;
import com.logistique.domain.entity.livreur.Livreur;
import com.logistique.domain.entity.livreur.LivreurId;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
@Profile({"inmemory", "test"})
public class InMemoryLivreurRepository implements LivreurRepository {

    private final Map<LivreurId, Livreur> data = new HashMap<>();

    @Override
    public void save(Livreur livreur) {
        data.put(livreur.getId(), livreur);
    }

    @Override
    public Optional<Livreur> findById(LivreurId id) {
        return Optional.ofNullable(data.get(id));
    }
}
