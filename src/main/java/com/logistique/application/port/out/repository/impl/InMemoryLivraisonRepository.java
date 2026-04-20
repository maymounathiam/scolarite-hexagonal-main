package com.logistique.application.port.out.repository.impl;

import com.logistique.application.port.out.repository.LivraisonRepository;
import com.logistique.domain.entity.livraison.Livraison;
import com.logistique.domain.entity.livraison.LivraisonId;
import com.logistique.domain.entity.livraison.ReferenceColis;
import com.logistique.domain.entity.livraison.StatutLivraison;
import com.logistique.domain.entity.livreur.LivreurId;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
@Profile({"inmemory", "test"})
public class InMemoryLivraisonRepository implements LivraisonRepository {

    private final Map<LivraisonId, Livraison> data = new HashMap<>();

    @Override
    public void save(Livraison livraison) {
        data.put(livraison.getId(), livraison);
    }

    @Override
    public Optional<Livraison> findById(LivraisonId id) {
        return Optional.ofNullable(data.get(id));
    }

    @Override
    public Optional<Livraison> findByReference(ReferenceColis reference) {
        return data.values().stream()
                .filter(l -> l.getReference().equals(reference))
                .findFirst();
    }

    @Override
    public boolean existsByReference(ReferenceColis reference) {
        return data.values().stream().anyMatch(l -> l.getReference().equals(reference));
    }

    @Override
    public int compterLivraisonsActivesPour(LivreurId livreurId) {
        return (int) data.values().stream()
                .filter(l -> livreurId.equals(l.getLivreurId()))
                .filter(l -> estActif(l.getStatut()))
                .count();
    }

    private static boolean estActif(StatutLivraison statut) {
        return statut == StatutLivraison.ASSIGNEE
                || statut == StatutLivraison.EN_COURS
                || statut == StatutLivraison.BLOQUEE_PAR_INCIDENT;
    }
}
