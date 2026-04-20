package com.logistique.application.port.out.repository;

import com.logistique.domain.entity.academic.AnneeAcademique;

import java.util.Optional;


public interface AnneeAcademiqueRepository {
    Optional<AnneeAcademique> findByCode(String code);

    void save(AnneeAcademique anneeAcademique);
}
