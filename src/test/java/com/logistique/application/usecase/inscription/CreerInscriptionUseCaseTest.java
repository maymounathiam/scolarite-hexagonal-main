package com.logistique.application.usecase.inscription;

import com.logistique.application.command.classe.CreerClasseCommand;
import com.logistique.application.port.out.repository.*;
import com.logistique.application.port.out.repository.impl.InMemoryAnneeAcademiqueRepository;
import com.logistique.application.port.out.repository.impl.InMemoryClasseRepository;
import com.logistique.application.port.out.repository.impl.InMemoryFiliereRepository;
import com.logistique.application.port.out.repository.impl.InMemoryInscriptionRepository;
import com.logistique.application.usecase.classe.CreerClasseService;
import com.logistique.application.command.iscription.CreerInscriptionCommand;
import com.logistique.application.port.in.inscription.CreerInscriptionUseCase;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreerInscriptionUseCaseTest {
    /*
    @Test
    void inscription_reussie() {

        ClasseRepository classeRepo = new InMemoryClasseRepository();
        InscriptionRepository inscRepo = new InMemoryInscriptionRepository();
        FiliereRepository filiereRepository = new InMemoryFiliereRepository();
        AnneeAcademiqueRepository anneeAcademiqueRepository = new InMemoryAnneeAcademiqueRepository() ;

        // prérequis : on crée une classe
        new CreerClasseService(classeRepo, filiereRepository).executer(
                new CreerClasseCommand("L3-INFO-A","Licence 3 Info A","INFO",
                        BigDecimal.TEN, BigDecimal.TEN, BigDecimal.TEN)
        );

        CreerInscriptionUseCase useCase =
                new CreerInscriptionService(classeRepo, inscRepo, anneeAcademiqueRepository);

        useCase.executer(new CreerInscriptionCommand(
                "L3-INFO-A",
                "ETU-2024-001",
                "2024-2025"
        ));

        assertTrue(
                inscRepo.findByMatriculeAndAnnee("ETU-2024-001","2024-2025").isPresent()
        );
    }

     */




}
