package com.logistique.application.usecase.classe;

import com.logistique.application.port.out.repository.ClasseRepository;
import com.logistique.application.port.out.repository.FiliereRepository;
import com.logistique.application.port.out.repository.impl.InMemoryClasseRepository;
import com.logistique.application.port.out.repository.impl.InMemoryFiliereRepository;
import com.logistique.application.command.classe.CreerClasseCommand;
import com.logistique.application.command.classe.ModifierFraisInscriptionClasseCommand;
import com.logistique.domain.entity.school.Classe;
import com.logistique.domain.entity.school.CodeClasse;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ModifierFraisInscriptionServiceTest {

    @Test
    public void modifier_frais_inscription_met_a_jour_total() {

        ClasseRepository repository = new InMemoryClasseRepository();
        FiliereRepository filiereRepository = new InMemoryFiliereRepository();

        // création de la classe
        new CreerClasseService(repository, filiereRepository).executer(
                new CreerClasseCommand(
                        "L3-INFO-A", "Licence 3 Informatique A",
                        "INFO",
                        BigDecimal.valueOf(20000),
                        BigDecimal.valueOf(60000),
                        BigDecimal.valueOf(10000)
                )
        );

        // modification des frais d'inscription
        var service = new ModifierFraisInscriptionClasseService(repository);
        service.executer(new ModifierFraisInscriptionClasseCommand(
                "L3-INFO-A", BigDecimal.valueOf(30000)
        ));

        Classe classe = repository.findById(new CodeClasse("L3-INFO-A")).get();

        assertEquals(
                BigDecimal.valueOf(100000), // 30000 + 60000 + 10000
                classe.montantTotalInscription().valeur()
        );
    }
}
