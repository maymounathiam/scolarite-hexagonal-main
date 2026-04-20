package com.logistique.domain.entity.livraison;

import com.logistique.domain.entity.livreur.LivreurId;
import com.logistique.domain.exception.LogistiqueException;
import com.logistique.domain.policy.livraison.LivraisonPolicy;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class LivraisonTest {

    private final LivraisonPolicy policy = new LivraisonPolicy();

    @Test
    void cycle_creee_assignee_en_cours_confirme() {
        Livraison l = Livraison.creer(
                new LivraisonId(UUID.randomUUID()),
                new ReferenceColis("COL-001"),
                new AdresseLivraison("Dakar Plateau")
        );
        assertEquals(StatutLivraison.CREEE, l.getStatut());

        LivreurId livreur = new LivreurId(UUID.randomUUID());
        l.assigner(livreur, policy, 0);
        assertEquals(StatutLivraison.ASSIGNEE, l.getStatut());

        l.demarrer();
        assertEquals(StatutLivraison.EN_COURS, l.getStatut());

        l.confirmer();
        assertEquals(StatutLivraison.CONFIRMEE, l.getStatut());
    }

    @Test
    void incident_bloque_puis_resolution_retour_en_cours() {
        Livraison l = livraisonEnCours();
        l.declarerIncident("Route barrée");
        assertEquals(StatutLivraison.BLOQUEE_PAR_INCIDENT, l.getStatut());
        assertEquals("Route barrée", l.getMotifIncident());

        l.resoudreIncident();
        assertEquals(StatutLivraison.EN_COURS, l.getStatut());
        assertNull(l.getMotifIncident());
    }

    @Test
    void confirmer_interdit_si_pas_en_cours() {
        Livraison l = Livraison.creer(
                new LivraisonId(UUID.randomUUID()),
                new ReferenceColis("COL-002"),
                new AdresseLivraison("Dakar")
        );
        assertThrows(LogistiqueException.class, l::confirmer);
    }

    @Test
    void assignation_refusee_si_capacite_max() {
        Livraison l = Livraison.creer(
                new LivraisonId(UUID.randomUUID()),
                new ReferenceColis("COL-003"),
                new AdresseLivraison("Dakar")
        );
        LivreurId livreur = new LivreurId(UUID.randomUUID());
        assertThrows(LogistiqueException.class, () -> l.assigner(livreur, policy, LivraisonPolicy.MAX_LIVRAISONS_SIMULTANEES_PAR_LIVREUR));
    }

    private static Livraison livraisonEnCours() {
        Livraison l = Livraison.creer(
                new LivraisonId(UUID.randomUUID()),
                new ReferenceColis("COL-ZZ"),
                new AdresseLivraison("Dakar")
        );
        l.assigner(new LivreurId(UUID.randomUUID()), new LivraisonPolicy(), 0);
        l.demarrer();
        return l;
    }
}
