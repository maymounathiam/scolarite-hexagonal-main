package com.logistique.infrastructure.web.livraison;

import com.logistique.application.command.livraison.*;
import com.logistique.application.command.livreur.CreerLivreurCommand;
import com.logistique.application.query.livraison.LivraisonSuiviView;
import com.logistique.infrastructure.web.livraison.request.CreerLivraisonRequest;
import com.logistique.infrastructure.web.livraison.request.CreerLivreurRequest;
import com.logistique.infrastructure.web.livraison.response.LivraisonSuiviResponse;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class LivraisonWebMapper {

    public CreerLivraisonCommand toCommand(CreerLivraisonRequest request) {
        return new CreerLivraisonCommand(request.referenceColis(), request.adresse());
    }

    public CreerLivreurCommand toCommand(CreerLivreurRequest request) {
        return new CreerLivreurCommand(request.nom());
    }

    public AssignerLivreurCommand toAssignerCommand(UUID livraisonId, UUID livreurId) {
        return new AssignerLivreurCommand(livraisonId, livreurId);
    }

    public DeclarerIncidentCommand toDeclarerCommand(UUID livraisonId, String motif) {
        return new DeclarerIncidentCommand(livraisonId, motif);
    }

    public LivraisonSuiviResponse toResponse(LivraisonSuiviView view) {
        return new LivraisonSuiviResponse(
                view.livraisonId(),
                view.referenceColis(),
                view.adresse(),
                view.statut(),
                view.livreurId(),
                view.motifIncident()
        );
    }
}
