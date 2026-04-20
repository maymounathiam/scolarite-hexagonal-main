package com.logistique.application.port.out.repository;

import com.logistique.domain.entity.student.Etudiant;

public interface EtudiantRepository {
    public boolean existsByMatricule(String matricule);
    public void save(Etudiant etudiant);
}
