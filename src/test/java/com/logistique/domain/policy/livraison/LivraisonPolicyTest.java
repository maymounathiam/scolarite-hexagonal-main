package com.logistique.domain.policy.livraison;

import com.logistique.domain.exception.LogistiqueException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LivraisonPolicyTest {

    private final LivraisonPolicy policy = new LivraisonPolicy();

    @Test
    void capacite_ok_en_dessous_du_plafond() {
        assertDoesNotThrow(() -> policy.verifierCapaciteLivreur(0));
        assertDoesNotThrow(() -> policy.verifierCapaciteLivreur(LivraisonPolicy.MAX_LIVRAISONS_SIMULTANEES_PAR_LIVREUR - 1));
    }

    @Test
    void capacite_refusee_au_plafond() {
        assertThrows(
                LogistiqueException.class,
                () -> policy.verifierCapaciteLivreur(LivraisonPolicy.MAX_LIVRAISONS_SIMULTANEES_PAR_LIVREUR)
        );
    }
}
