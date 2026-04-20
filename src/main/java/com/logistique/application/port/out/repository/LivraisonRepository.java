package com.logistique.application.port.out.repository;

import com.logistique.domain.entity.livraison.Livraison;
import com.logistique.domain.entity.livraison.LivraisonId;
import com.logistique.domain.entity.livraison.ReferenceColis;
import com.logistique.domain.entity.livreur.LivreurId;

import java.util.Optional;

public interface LivraisonRepository {

    void save(Livraison livraison);

    Optional<Livraison> findById(LivraisonId id);

    Optional<Livraison> findByReference(ReferenceColis reference);

    boolean existsByReference(ReferenceColis reference);

    int compterLivraisonsActivesPour(LivreurId livreurId);
}
