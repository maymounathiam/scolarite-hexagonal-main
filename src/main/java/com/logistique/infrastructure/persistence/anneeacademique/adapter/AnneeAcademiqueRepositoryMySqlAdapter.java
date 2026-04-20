package com.logistique.infrastructure.persistence.anneeacademique.adapter;

import com.logistique.application.port.out.repository.AnneeAcademiqueRepository;
import com.logistique.domain.entity.academic.AnneeAcademique;
import com.logistique.infrastructure.persistence.anneeacademique.entity.AnneeAcademiqueJpaEntity;
import com.logistique.infrastructure.persistence.anneeacademique.mapper.AnneeAcademiquePersistenceMapper;
import com.logistique.infrastructure.persistence.anneeacademique.repository.AnneeAcademiqueJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Optional;

@AllArgsConstructor
@Component
@Profile("mysql")
public class AnneeAcademiqueRepositoryMySqlAdapter
        implements AnneeAcademiqueRepository {

    private final AnneeAcademiqueJpaRepository jpaRepository;
    private final AnneeAcademiquePersistenceMapper mapper;

    @Override
    public Optional<AnneeAcademique> findByCode(String code) {
        return jpaRepository.findByCode(code)
                .map(mapper::toDomain);
    }

    @Override
    public void save(AnneeAcademique annee) {
        AnneeAcademiqueJpaEntity entity =
                jpaRepository.findByCode(annee.getId().value())
                        .orElseGet(() ->
                                mapper.toJpa(annee) // CREATE
                        );

        if (entity.getCode() != null) {
            mapper.updateJpa(annee, entity); // UPDATE
        }

        jpaRepository.save(entity);
    }
}

