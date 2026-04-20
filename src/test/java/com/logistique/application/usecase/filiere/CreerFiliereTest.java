package com.logistique.application.usecase.filiere;

import com.logistique.application.port.out.repository.FiliereRepository;
import com.logistique.application.port.out.repository.impl.InMemoryFiliereRepository;
import com.logistique.application.command.filiere.CreerFiliereCommand;
import com.logistique.domain.entity.school.CodeFiliere;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CreerFiliereTest {

    @Test
    public void creerUneFiliere(){
        FiliereRepository filiereRepository = new InMemoryFiliereRepository();
        new CreerFiliereService(filiereRepository).executer(
                new CreerFiliereCommand(
                        "GL",
                        "Génie Logiciel"
                )
        );

        boolean filiereExiste = filiereRepository.existsByCode(new CodeFiliere("GL"));

        assertTrue(filiereExiste);
    }

    @Test
    public void creerDeuxFiliereAvecLeMemeCode(){
        FiliereRepository filiereRepository = new InMemoryFiliereRepository();

        new CreerFiliereService(filiereRepository).executer(
                new CreerFiliereCommand(
                        "GL",
                        "Génie Logiciel"
                )
        );

        boolean filiereExiste = filiereRepository.existsByCode(new CodeFiliere("GL"));
        assertTrue(filiereExiste);

        assertThrows(IllegalStateException.class,
                () -> new CreerFiliereService(filiereRepository).executer(
                        new CreerFiliereCommand(
                                "GL",
                                "Marketing"
                        )
                )
        );


    }
}
