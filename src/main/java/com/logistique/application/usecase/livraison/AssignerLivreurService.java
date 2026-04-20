package com.logistique.application.usecase.livraison;

import com.logistique.application.command.livraison.AssignerLivreurCommand;
import com.logistique.application.port.in.livraison.AssignerLivreurUseCase;
import com.logistique.application.port.out.repository.LivraisonRepository;
import com.logistique.application.port.out.repository.LivreurRepository;
import com.logistique.domain.entity.livraison.Livraison;
import com.logistique.domain.entity.livraison.LivraisonId;
import com.logistique.domain.entity.livreur.LivreurId;
import com.logistique.domain.exception.LogistiqueNotFoundException;
import com.logistique.domain.policy.livraison.LivraisonPolicy;
import org.springframework.stereotype.Service;

@Service
public class AssignerLivreurService implements AssignerLivreurUseCase {

    private final LivraisonRepository livraisonRepository;
    private final LivreurRepository livreurRepository;
    private final LivraisonPolicy livraisonPolicy;

    public AssignerLivreurService(
            LivraisonRepository livraisonRepository,
            LivreurRepository livreurRepository,
            LivraisonPolicy livraisonPolicy
    ) {
        this.livraisonRepository = livraisonRepository;
        this.livreurRepository = livreurRepository;
        this.livraisonPolicy = livraisonPolicy;
    }

    @Override
    public void executer(AssignerLivreurCommand command) {
        Livraison livraison = livraisonRepository.findById(new LivraisonId(command.livraisonId()))
                .orElseThrow(() -> new LogistiqueNotFoundException("Livraison introuvable"));
        livreurRepository.findById(new LivreurId(command.livreurId()))
                .orElseThrow(() -> new LogistiqueNotFoundException("Livreur introuvable"));

        int actives = livraisonRepository.compterLivraisonsActivesPour(new LivreurId(command.livreurId()));
        LivreurId livreurId = new LivreurId(command.livreurId());
        livraison.assigner(livreurId, livraisonPolicy, actives);
        livraisonRepository.save(livraison);
    }
}
