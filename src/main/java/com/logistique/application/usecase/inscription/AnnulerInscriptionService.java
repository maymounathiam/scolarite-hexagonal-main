package com.logistique.application.usecase.inscription;

import com.logistique.application.port.in.inscription.AnnulerInscriptionUseCase;
import com.logistique.application.port.out.repository.InscriptionRepository;
import com.logistique.domain.entity.inscription.Inscription;
import com.logistique.domain.exception.ScolariteException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AnnulerInscriptionService implements AnnulerInscriptionUseCase {

    private final InscriptionRepository inscriptionRepository;

    public AnnulerInscriptionService(InscriptionRepository inscriptionRepository) {
        this.inscriptionRepository = inscriptionRepository;
    }

    @Override
    public void annuler(String matricule, String anneeAcademique, String raison) {

        Inscription inscription = inscriptionRepository
                .findByMatriculeAndAnnee(matricule, anneeAcademique)
                .orElseThrow(() ->
                        new ScolariteException("Inscription introuvable")
                );

        // 👉 OPTION 1 : suppression physique
        inscriptionRepository.delete(inscription);

        // 👉 OPTION 2 (recommandé métier) :
        // inscription.annuler(raison);
        // inscriptionRepository.save(inscription);
    }
}
