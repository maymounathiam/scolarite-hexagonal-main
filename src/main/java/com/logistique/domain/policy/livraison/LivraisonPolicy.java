package com.logistique.domain.policy.livraison;

import com.logistique.domain.exception.LogistiqueException;
import org.springframework.stereotype.Component;

@Component
public class LivraisonPolicy {

    public static final int MAX_LIVRAISONS_SIMULTANEES_PAR_LIVREUR = 3;

    public void verifierCapaciteLivreur(int livraisonsActivesPourLeLivreur) {
        if (livraisonsActivesPourLeLivreur >= MAX_LIVRAISONS_SIMULTANEES_PAR_LIVREUR) {
            throw new LogistiqueException(
                    "Le livreur ne peut pas avoir plus de "
                            + MAX_LIVRAISONS_SIMULTANEES_PAR_LIVREUR
                            + " livraisons simultanées"
            );
        }
    }
}
