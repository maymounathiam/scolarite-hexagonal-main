package com.logistique.domain.entity.livraison;

import com.logistique.domain.entity.livreur.LivreurId;
import com.logistique.domain.exception.LogistiqueException;
import com.logistique.domain.policy.livraison.LivraisonPolicy;
import com.logistique.domain.shared.AggregateRoot;

import java.util.Objects;

public class Livraison implements AggregateRoot<LivraisonId> {

    private final LivraisonId id;
    private final ReferenceColis reference;
    private final AdresseLivraison adresse;
    private StatutLivraison statut;
    private LivreurId livreurId;
    private String motifIncident;

    private Livraison(
            LivraisonId id,
            ReferenceColis reference,
            AdresseLivraison adresse,
            StatutLivraison statut,
            LivreurId livreurId,
            String motifIncident
    ) {
        this.id = Objects.requireNonNull(id);
        this.reference = Objects.requireNonNull(reference);
        this.adresse = Objects.requireNonNull(adresse);
        this.statut = Objects.requireNonNull(statut);
        this.livreurId = livreurId;
        this.motifIncident = motifIncident;
    }

    public static Livraison creer(LivraisonId id, ReferenceColis reference, AdresseLivraison adresse) {
        return new Livraison(id, reference, adresse, StatutLivraison.CREEE, null, null);
    }

    public static Livraison reconstituer(
            LivraisonId id,
            ReferenceColis reference,
            AdresseLivraison adresse,
            StatutLivraison statut,
            LivreurId livreurId,
            String motifIncident
    ) {
        return new Livraison(id, reference, adresse, statut, livreurId, motifIncident);
    }

    @Override
    public LivraisonId getId() {
        return id;
    }

    public ReferenceColis getReference() {
        return reference;
    }

    public AdresseLivraison getAdresse() {
        return adresse;
    }

    public StatutLivraison getStatut() {
        return statut;
    }

    public LivreurId getLivreurId() {
        return livreurId;
    }

    public String getMotifIncident() {
        return motifIncident;
    }

    public void assigner(LivreurId livreur, LivraisonPolicy policy, int livraisonsActivesPourCeLivreur) {
        verifierStatut(StatutLivraison.CREEE);
        policy.verifierCapaciteLivreur(livraisonsActivesPourCeLivreur);
        this.livreurId = Objects.requireNonNull(livreur);
        this.statut = StatutLivraison.ASSIGNEE;
    }

    public void demarrer() {
        verifierStatut(StatutLivraison.ASSIGNEE);
        this.statut = StatutLivraison.EN_COURS;
    }

    public void declarerIncident(String motif) {
        if (motif == null || motif.isBlank()) {
            throw new IllegalArgumentException("Motif d'incident obligatoire");
        }
        verifierStatut(StatutLivraison.ASSIGNEE, StatutLivraison.EN_COURS);
        this.motifIncident = motif.trim();
        this.statut = StatutLivraison.BLOQUEE_PAR_INCIDENT;
    }

    public void resoudreIncident() {
        verifierStatut(StatutLivraison.BLOQUEE_PAR_INCIDENT);
        this.motifIncident = null;
        this.statut = StatutLivraison.EN_COURS;
    }

    public void confirmer() {
        verifierStatut(StatutLivraison.EN_COURS);
        this.statut = StatutLivraison.CONFIRMEE;
    }

    private void verifierStatut(StatutLivraison... autorises) {
        for (StatutLivraison s : autorises) {
            if (this.statut == s) {
                return;
            }
        }
        throw new LogistiqueException(
                "Action interdite pour le statut " + this.statut
        );
    }
}
