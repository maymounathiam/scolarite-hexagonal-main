package com.logistique.infrastructure.persistence.anneeacademique.mapper;

import com.logistique.domain.entity.academic.AnneeAcademique;
import com.logistique.domain.entity.academic.MoisAcademique;
import com.logistique.domain.exception.ScolariteException;
import com.logistique.infrastructure.persistence.anneeacademique.entity.AnneeAcademiqueJpaEntity;
import com.logistique.infrastructure.persistence.anneeacademique.entity.AnneeMoisJpaEntity;
import com.logistique.infrastructure.persistence.anneeacademique.repository.AnneeMoisJpaRepository;
import org.springframework.stereotype.Component;

@Component
public class MoisAcademiquePersistenceMapper {
    private final AnneeMoisJpaRepository anneeMoisJpaRepository;

    public MoisAcademiquePersistenceMapper(AnneeMoisJpaRepository anneeMoisJpaRepository) {
        this.anneeMoisJpaRepository = anneeMoisJpaRepository;
    }

    /**
     * Synchronise les mois académiques du domaine
     * vers l'entité JPA AnneeAcademique.
     *
     * Règle importante :
     * - on vide puis on reconstruit la collection
     * - permet à JPA de gérer correctement orphanRemoval
     */
    public void mapMois(
            AnneeAcademique domain,
            AnneeAcademiqueJpaEntity jpa
    ) {
        jpa.getMoisAcademiques().clear();

        for (MoisAcademique mois : domain.getMoisAcademiques()) {
            jpa.getMoisAcademiques().add(
                    new AnneeMoisJpaEntity(
                            domain.getId().value(), // code année académique
                            mois.mois(),
                            mois.annee()
                    )
            );
        }
    }

    AnneeMoisJpaEntity toJpa(MoisAcademique m, String anneeCode) {
        return anneeMoisJpaRepository
                .findByAnneeAcademiqueCodeAndMoisAndAnnee(
                        anneeCode,
                        m.mois(),
                        m.annee()
                )
                .orElseThrow(() ->
                        new ScolariteException("Mois académique introuvable : "
                                + m.mois() + "-" + m.annee())
                );
    }

}
