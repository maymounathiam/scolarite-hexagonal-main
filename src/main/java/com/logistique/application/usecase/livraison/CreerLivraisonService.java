package com.logistique.application.usecase.livraison;

import com.logistique.application.command.livraison.CreerLivraisonCommand;
import com.logistique.application.port.in.livraison.CreerLivraisonUseCase;
import com.logistique.application.port.out.repository.LivraisonRepository;
import com.logistique.domain.entity.livraison.AdresseLivraison;
import com.logistique.domain.entity.livraison.Livraison;
import com.logistique.domain.entity.livraison.LivraisonId;
import com.logistique.domain.entity.livraison.ReferenceColis;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CreerLivraisonService implements CreerLivraisonUseCase {

    private final LivraisonRepository livraisonRepository;

    public CreerLivraisonService(LivraisonRepository livraisonRepository) {
        this.livraisonRepository = livraisonRepository;
    }

    @Override
    public UUID executer(CreerLivraisonCommand command) {
        ReferenceColis reference = new ReferenceColis(command.referenceColis());
        if (livraisonRepository.existsByReference(reference)) {
            throw new IllegalStateException("Référence colis déjà utilisée");
        }
        LivraisonId id = LivraisonId.generer();
        Livraison livraison = Livraison.creer(
                id,
                reference,
                new AdresseLivraison(command.adresse())
        );
        livraisonRepository.save(livraison);
        return id.value();
    }
}
