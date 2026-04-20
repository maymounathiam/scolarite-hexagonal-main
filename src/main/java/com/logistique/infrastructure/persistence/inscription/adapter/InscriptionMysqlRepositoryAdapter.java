package com.logistique.infrastructure.persistence.inscription.adapter;

import com.logistique.application.port.out.repository.InscriptionRepository;
import com.logistique.domain.entity.inscription.Inscription;
import com.logistique.domain.entity.inscription.InscriptionId;
import com.logistique.infrastructure.persistence.anneeacademique.repository.AnneeAcademiqueJpaRepository;
import com.logistique.infrastructure.persistence.etudiant.repository.EtudiantJpaRepository;
import com.logistique.infrastructure.persistence.inscription.entity.InscriptionJpaEntity;
import com.logistique.infrastructure.persistence.inscription.mapper.InscriptionPersistenceMapper;
import com.logistique.infrastructure.persistence.inscription.repository.InscriptionJpaRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
@Profile("mysql")
public class InscriptionMysqlRepositoryAdapter  implements InscriptionRepository {
    private final InscriptionJpaRepository inscriptionJpaRepository;
    private final InscriptionPersistenceMapper inscriptionPersitenceMapper;
    private final EtudiantJpaRepository etudiantJpaRepository;
    private final AnneeAcademiqueJpaRepository anneeAcademiqueJpaRepository;
    public InscriptionMysqlRepositoryAdapter(InscriptionJpaRepository inscriptionJpaRepository, InscriptionPersistenceMapper inscriptionPersitenceMapper, EtudiantJpaRepository etudiantJpaRepository, AnneeAcademiqueJpaRepository anneeAcademiqueJpaRepository) {
        this.inscriptionJpaRepository = inscriptionJpaRepository;
        this.inscriptionPersitenceMapper = inscriptionPersitenceMapper;
        this.etudiantJpaRepository = etudiantJpaRepository;
        this.anneeAcademiqueJpaRepository = anneeAcademiqueJpaRepository;
    }

    @Override
    public void save(Inscription inscription) {

        InscriptionJpaEntity entity =
                inscriptionPersitenceMapper.toJpa(inscription);

        inscriptionJpaRepository.save(entity);
    }
    @Override
    public Optional<Inscription> findByMatriculeAndAnnee(String matricule, String anneeAcademic) {
        return inscriptionJpaRepository
                .findByEtudiant_MatriculeAndAnneeAcademique_Code(matricule, anneeAcademic)
                .map(inscriptionPersitenceMapper::toDomain);
    }

    @Override
    public boolean existsByMatriculeAndAnnee(String matricule, String anneeAcademic) {
        return inscriptionJpaRepository.existsByEtudiant_MatriculeAndAnneeAcademique_Code(
                matricule, anneeAcademic
        );
    }

    @Override
    public long count() {
        return inscriptionJpaRepository.count();
    }

    @Override
    public List<Inscription> all() {
        return inscriptionJpaRepository
                .findAll()
                .stream()
                .map(inscriptionPersitenceMapper::toDomain)
                .toList();
    }

    @Override
    public void delete(Inscription inscription) {
        inscriptionJpaRepository.delete(
                inscriptionJpaRepository.findByEtudiant_MatriculeAndAnneeAcademique_Code(
                inscription.getId().getMatricule().value(),
                inscription.getId().getAnneeAcademiqueId().value()
        ).get());
    }
}
