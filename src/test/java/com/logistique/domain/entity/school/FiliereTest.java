package com.logistique.domain.entity.school;

import com.logistique.domain.entity.school.CodeFiliere;
import com.logistique.domain.entity.school.Filiere;
import com.logistique.domain.entity.school.NomFiliere;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class FiliereTest {
    @Test
    public void creerFiliereTest(){
        Filiere filiere1 = new Filiere(
                new CodeFiliere("GL"),
                new NomFiliere("Génie logiciel")
        );

        Filiere filiere2 = new Filiere(
                new CodeFiliere("GL"),
                new NomFiliere("Génie logiciel")
        );

        assertEquals(filiere1, filiere2);
        assertEquals(filiere1.hashCode(), filiere2.hashCode());

    }
}
