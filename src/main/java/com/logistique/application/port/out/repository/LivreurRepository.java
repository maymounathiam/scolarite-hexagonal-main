package com.logistique.application.port.out.repository;

import com.logistique.domain.entity.livreur.Livreur;
import com.logistique.domain.entity.livreur.LivreurId;

import java.util.Optional;

public interface LivreurRepository {

    void save(Livreur livreur);

    Optional<Livreur> findById(LivreurId id);
}
