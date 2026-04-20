package com.logistique.infrastructure.persistence.filiere.mapper;

import com.logistique.domain.entity.school.CodeFiliere;
import com.logistique.domain.entity.school.Filiere;
import com.logistique.domain.entity.school.NomFiliere;
import com.logistique.infrastructure.persistence.filiere.entity.FiliereJpaEntity;
import org.springframework.stereotype.Component;
@Component
public class FilierePersistenceMapper {

    public Filiere toDomain(FiliereJpaEntity entity){
        return new Filiere(
                new CodeFiliere(entity.getCode()),
                new NomFiliere(entity.getNom())
        );
    }

    public FiliereJpaEntity toJpa(Filiere domain){
        FiliereJpaEntity entity = new FiliereJpaEntity();
        entity.setCode(domain.getCodeFiliere().value());
        entity.setNom(domain.getNomFiliere().value());
        return entity;
    }

}
