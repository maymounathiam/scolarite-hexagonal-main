package com.logistique.domain.entity.livreur;

import com.logistique.domain.shared.AggregateRoot;

import java.util.Objects;

public class Livreur implements AggregateRoot<LivreurId> {

    private final LivreurId id;
    private final NomLivreur nom;

    public Livreur(LivreurId id, NomLivreur nom) {
        this.id = Objects.requireNonNull(id);
        this.nom = Objects.requireNonNull(nom);
    }

    public static Livreur creer(NomLivreur nom) {
        return new Livreur(LivreurId.generer(), nom);
    }

    @Override
    public LivreurId getId() {
        return id;
    }

    public NomLivreur getNom() {
        return nom;
    }
}
