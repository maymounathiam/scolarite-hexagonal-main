package com.logistique.application.usecase.livraison;

import com.logistique.application.command.livraison.DemarrerLivraisonCommand;
import com.logistique.application.port.in.livraison.DemarrerLivraisonUseCase;
import com.logistique.application.port.out.repository.LivraisonRepository;
import com.logistique.domain.entity.livraison.Livraison;
import com.logistique.domain.entity.livraison.LivraisonId;
import com.logistique.domain.exception.LogistiqueNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DemarrerLivraisonService implements DemarrerLivraisonUseCase {

    private final LivraisonRepository livraisonRepository;

    public DemarrerLivraisonService(LivraisonRepository livraisonRepository) {
        this.livraisonRepository = livraisonRepository;
    }

    @Override
    public void executer(DemarrerLivraisonCommand command) {
        Livraison livraison = livraisonRepository.findById(new LivraisonId(command.livraisonId()))
                .orElseThrow(() -> new LogistiqueNotFoundException("Livraison introuvable"));
        livraison.demarrer();
        livraisonRepository.save(livraison);
    }
}
