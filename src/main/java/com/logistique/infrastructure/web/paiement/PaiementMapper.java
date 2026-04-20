package com.logistique.infrastructure.web.paiement;

import com.logistique.application.command.paiement.DeclarerPaiementCommand;
import com.logistique.application.query.paiement.PaiementView;
import com.logistique.domain.entity.paiement.TypePaiement;
import com.logistique.infrastructure.web.paiement.request.DeclarerPaiementRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PaiementMapper {
    public DeclarerPaiementCommand toCommand(DeclarerPaiementRequest request) {
        return new DeclarerPaiementCommand(
                request.matricule(),
                request.anneeAcademique(),
                TypePaiement.MENSUALITE.name(),
                request.canalPaiement(),
                request.operateurMobileMoney(),
                request.referenceMobileMoney(),
                request.nomBanque(),
                request.referenceBancaire(),
                request.montantPaye(),
                request.datePaiement(),
                request.heurePaiement(),
                request.preuvePaiement()
        );
    }
}
