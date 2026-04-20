package com.logistique.application.usecase.livraison;

import com.logistique.application.command.livraison.ConfirmerLivraisonCommand;
import com.logistique.application.port.in.livraison.ConfirmerLivraisonUseCase;
import com.logistique.application.port.out.repository.LivraisonRepository;
import com.logistique.domain.entity.livraison.Livraison;
import com.logistique.domain.entity.livraison.LivraisonId;
import com.logistique.domain.exception.LogistiqueNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ConfirmerLivraisonService implements ConfirmerLivraisonUseCase {

    private final LivraisonRepository livraisonRepository;

    public ConfirmerLivraisonService(LivraisonRepository livraisonRepository) {
        this.livraisonRepository = livraisonRepository;
    }

    @Override
    public void executer(ConfirmerLivraisonCommand command) {
        Livraison livraison = livraisonRepository.findById(new LivraisonId(command.livraisonId()))
                .orElseThrow(() -> new LogistiqueNotFoundException("Livraison introuvable"));
        livraison.confirmer();
        livraisonRepository.save(livraison);
    }
}
