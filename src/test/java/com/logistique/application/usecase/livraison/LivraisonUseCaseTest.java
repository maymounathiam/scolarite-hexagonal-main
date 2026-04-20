package com.logistique.application.usecase.livraison;

import com.logistique.application.command.livraison.*;
import com.logistique.application.command.livreur.CreerLivreurCommand;
import com.logistique.application.port.out.repository.impl.InMemoryLivraisonRepository;
import com.logistique.application.port.out.repository.impl.InMemoryLivreurRepository;
import com.logistique.application.query.livraison.LivraisonSuiviView;
import com.logistique.application.usecase.livreur.CreerLivreurService;
import com.logistique.domain.entity.livraison.StatutLivraison;
import com.logistique.domain.policy.livraison.LivraisonPolicy;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LivraisonUseCaseTest {

    private final InMemoryLivraisonRepository livraisonRepository = new InMemoryLivraisonRepository();
    private final InMemoryLivreurRepository livreurRepository = new InMemoryLivreurRepository();
    private final LivraisonPolicy livraisonPolicy = new LivraisonPolicy();

    private final CreerLivraisonService creerLivraison = new CreerLivraisonService(livraisonRepository);
    private final CreerLivreurService creerLivreur = new CreerLivreurService(livreurRepository);
    private final AssignerLivreurService assigner = new AssignerLivreurService(livraisonRepository, livreurRepository, livraisonPolicy);
    private final DemarrerLivraisonService demarrer = new DemarrerLivraisonService(livraisonRepository);
    private final ConfirmerLivraisonService confirmer = new ConfirmerLivraisonService(livraisonRepository);
    private final GererIncidentService incidents = new GererIncidentService(livraisonRepository);
    private final SuivreLivraisonService suivre = new SuivreLivraisonService(livraisonRepository);

    @Test
    void flux_principal_creer_assigner_demarrer_confirmer_et_suivre() {
        UUID livreurId = creerLivreur.executer(new CreerLivreurCommand("Amadou Ndiaye"));

        UUID livraisonId = creerLivraison.executer(
                new CreerLivraisonCommand("REF-100", "Parcelles Assainies U15")
        );

        assigner.executer(new AssignerLivreurCommand(livraisonId, livreurId));
        demarrer.executer(new DemarrerLivraisonCommand(livraisonId));

        LivraisonSuiviView avant = suivre.consulterParId(livraisonId);
        assertEquals(StatutLivraison.EN_COURS, avant.statut());

        confirmer.executer(new ConfirmerLivraisonCommand(livraisonId));

        LivraisonSuiviView apres = suivre.consulterParReference("REF-100");
        assertEquals(StatutLivraison.CONFIRMEE, apres.statut());
    }

    @Test
    void incident_declare_puis_resolu_visible_au_suivi() {
        UUID livreurId = creerLivreur.executer(new CreerLivreurCommand("Fatou Diop"));
        UUID livraisonId = creerLivraison.executer(
                new CreerLivraisonCommand("REF-200", "Mermoz")
        );
        assigner.executer(new AssignerLivreurCommand(livraisonId, livreurId));
        demarrer.executer(new DemarrerLivraisonCommand(livraisonId));

        incidents.declarer(new DeclarerIncidentCommand(livraisonId, "Véhicule en panne"));
        assertEquals(StatutLivraison.BLOQUEE_PAR_INCIDENT, suivre.consulterParId(livraisonId).statut());

        incidents.resoudre(new ResoudreIncidentCommand(livraisonId));
        assertEquals(StatutLivraison.EN_COURS, suivre.consulterParId(livraisonId).statut());
    }
}
