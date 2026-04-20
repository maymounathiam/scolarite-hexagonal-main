package com.logistique.application.port.out.repository;

import com.logistique.domain.entity.school.CodeFiliere;
import com.logistique.domain.entity.school.Filiere;

import java.util.Optional;

public interface FiliereRepository {
    boolean existsByCode(CodeFiliere code);
    void save(Filiere filiere);
    Optional<Filiere> findByCode(CodeFiliere code);
}
