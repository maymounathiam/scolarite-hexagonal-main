package com.logistique.infrastructure.persistence.etudiant.adapter;

import com.logistique.application.port.out.repository.EtudiantRepository;
import com.logistique.domain.entity.student.Etudiant;
import com.logistique.infrastructure.persistence.anneeacademique.repository.AnneeAcademiqueJpaRepository;
import com.logistique.infrastructure.persistence.etudiant.mapper.EtudiantPersistenceMapper;
import com.logistique.infrastructure.persistence.etudiant.repository.EtudiantJpaRepository;
import com.logistique.infrastructure.persistence.inscription.repository.InscriptionJpaRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("mysql")
public class EtudiantMysqlRepositoryAdapter implements EtudiantRepository {
    private final EtudiantPersistenceMapper etudiantPersistenceMapper;
    private final EtudiantJpaRepository etudiantJpaRepository;
    public EtudiantMysqlRepositoryAdapter(InscriptionJpaRepository inscriptionJpaRepository, EtudiantJpaRepository etudiantJpaRepository, AnneeAcademiqueJpaRepository anneeAcademiqueJpaRepository, EtudiantPersistenceMapper etudiantPersistenceMapper) {
        this.etudiantJpaRepository = etudiantJpaRepository;
        this.etudiantPersistenceMapper = etudiantPersistenceMapper;
    }


    @Override
    public boolean existsByMatricule(String matricule) {
        return etudiantJpaRepository.existsByMatricule(matricule);
    }

    @Override
    public void save(Etudiant etudiant) {
        etudiantJpaRepository.save(etudiantPersistenceMapper.toJpa(etudiant));
    }
}
