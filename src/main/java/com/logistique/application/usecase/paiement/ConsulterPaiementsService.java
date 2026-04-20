package com.logistique.application.usecase.paiement;

import com.logistique.application.mapper.PaiementSnapshotMapper;
import com.logistique.application.port.in.paiement.ConsulterPaiementsUseCase;
import com.logistique.application.port.out.repository.InscriptionRepository;
import com.logistique.application.port.out.repository.PaiementRepository;
import com.logistique.application.query.paiement.ConsulterPaiementQuery;
import com.logistique.application.query.paiement.PaiementView;
import com.logistique.domain.entity.inscription.Inscription;
import com.logistique.domain.entity.paiement.Paiement;
import com.logistique.domain.exception.ScolariteNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ConsulterPaiementsService implements ConsulterPaiementsUseCase {
    private final InscriptionRepository inscriptionRepository;
    private final PaiementRepository paiementRepository;
    private final PaiementSnapshotMapper paiementSnapshotMapper;

    @Override
    public List<PaiementView> execute(ConsulterPaiementQuery consulterPaiementQuery) {
        // verfier s'il est inscrit
        inscriptionRepository.findByMatriculeAndAnnee(
                consulterPaiementQuery.matricule(),
                consulterPaiementQuery.anneeAcademqiue()
        ).orElseThrow(()-> new ScolariteNotFoundException("Inscription introuvable"));


        // recupérer les paiements
        return paiementRepository.findByMatriculeAndAnneeAcademiqueOrdered(
                consulterPaiementQuery.matricule(),
                consulterPaiementQuery.anneeAcademqiue()
        ).stream().map(paiementSnapshotMapper::PaiementToPaiementView).toList();

    }
}
