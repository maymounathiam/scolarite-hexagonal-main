package com.logistique.application.usecase.livraison;

import com.logistique.application.command.livraison.DeclarerIncidentCommand;
import com.logistique.application.command.livraison.ResoudreIncidentCommand;
import com.logistique.application.port.in.livraison.GererIncidentUseCase;
import com.logistique.application.port.out.repository.LivraisonRepository;
import com.logistique.domain.entity.livraison.Livraison;
import com.logistique.domain.entity.livraison.LivraisonId;
import com.logistique.domain.exception.LogistiqueNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class GererIncidentService implements GererIncidentUseCase {

    private final LivraisonRepository livraisonRepository;

    public GererIncidentService(LivraisonRepository livraisonRepository) {
        this.livraisonRepository = livraisonRepository;
    }

    @Override
    public void declarer(DeclarerIncidentCommand command) {
        Livraison livraison = livraisonRepository.findById(new LivraisonId(command.livraisonId()))
                .orElseThrow(() -> new LogistiqueNotFoundException("Livraison introuvable"));
        livraison.declarerIncident(command.motif());
        livraisonRepository.save(livraison);
    }

    @Override
    public void resoudre(ResoudreIncidentCommand command) {
        Livraison livraison = livraisonRepository.findById(new LivraisonId(command.livraisonId()))
                .orElseThrow(() -> new LogistiqueNotFoundException("Livraison introuvable"));
        livraison.resoudreIncident();
        livraisonRepository.save(livraison);
    }
}
