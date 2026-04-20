package com.logistique.application.port.out.repository;


import com.logistique.domain.entity.school.Classe;
import com.logistique.domain.entity.school.CodeClasse;
import com.logistique.domain.entity.school.NomClasse;

import java.util.Optional;

public interface ClasseRepository {

    boolean existsByCode(CodeClasse code);

    boolean existsByNom(NomClasse nom);

    void save(Classe classe);

    Optional<Classe> findById(CodeClasse code);

    Optional<Classe> findByCode(CodeClasse code);
}
