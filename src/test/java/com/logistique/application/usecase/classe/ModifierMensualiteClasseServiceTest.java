package com.logistique.application.usecase.classe;

import com.logistique.application.port.out.repository.ClasseRepository;
import com.logistique.application.port.out.repository.FiliereRepository;
import com.logistique.application.port.out.repository.impl.InMemoryClasseRepository;
import com.logistique.application.port.out.repository.impl.InMemoryFiliereRepository;
import com.logistique.application.command.classe.CreerClasseCommand;
import com.logistique.application.command.classe.ModifierMensualiteClasseCommand;
import com.logistique.domain.entity.school.Classe;
import com.logistique.domain.entity.school.CodeClasse;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ModifierMensualiteClasseServiceTest {

    @Test
    public void modifier_mensualite_met_a_jour_total() {
        ClasseRepository repo = new InMemoryClasseRepository();
        FiliereRepository filiereRepository = new InMemoryFiliereRepository();

        new CreerClasseService(repo, filiereRepository).executer(
                new CreerClasseCommand(
                        "L3-INFO-B", "Licence 3 Informatique B",
                        "INFO",
                        BigDecimal.valueOf(20000),
                        BigDecimal.valueOf(60000),
                        BigDecimal.valueOf(10000)
                )
        );

        new ModifierMensualiteClasseService(repo).executer(
                new ModifierMensualiteClasseCommand(
                        "L3-INFO-B", BigDecimal.valueOf(65000)
                )
        );

        Classe classe = repo.findById(new CodeClasse("L3-INFO-B")).get();

        assertEquals(
                BigDecimal.valueOf(95000), // 20000 + 65000 + 10000
                classe.montantTotalInscription().valeur()
        );
    }
}

