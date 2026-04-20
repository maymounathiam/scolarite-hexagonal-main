package com.logistique.application.usecase.livraison;

import com.logistique.application.port.in.livraison.SuivreLivraisonUseCase;
import com.logistique.application.port.out.repository.LivraisonRepository;
import com.logistique.application.query.livraison.LivraisonSuiviView;
import com.logistique.domain.entity.livraison.Livraison;
import com.logistique.domain.entity.livraison.LivraisonId;
import com.logistique.domain.entity.livraison.ReferenceColis;
import com.logistique.domain.exception.LogistiqueNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SuivreLivraisonService implements SuivreLivraisonUseCase {

    private final LivraisonRepository livraisonRepository;

    public SuivreLivraisonService(LivraisonRepository livraisonRepository) {
        this.livraisonRepository = livraisonRepository;
    }

    @Override
    public LivraisonSuiviView consulterParId(UUID livraisonId) {
        Livraison livraison = livraisonRepository.findById(new LivraisonId(livraisonId))
                .orElseThrow(() -> new LogistiqueNotFoundException("Livraison introuvable"));
        return versVue(livraison);
    }

    @Override
    public LivraisonSuiviView consulterParReference(String referenceColis) {
        Livraison livraison = livraisonRepository.findByReference(new ReferenceColis(referenceColis))
                .orElseThrow(() -> new LogistiqueNotFoundException("Livraison introuvable"));
        return versVue(livraison);
    }

    private static LivraisonSuiviView versVue(Livraison livraison) {
        return new LivraisonSuiviView(
                livraison.getId().value(),
                livraison.getReference().value(),
                livraison.getAdresse().value(),
                livraison.getStatut(),
                livraison.getLivreurId() != null ? livraison.getLivreurId().value() : null,
                livraison.getMotifIncident()
        );
    }
}
