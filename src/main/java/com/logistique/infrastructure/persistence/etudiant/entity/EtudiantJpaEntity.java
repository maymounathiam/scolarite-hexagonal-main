package com.logistique.infrastructure.persistence.etudiant.entity;

import com.logistique.infrastructure.persistence.anneeacademique.entity.AnneeAcademiqueJpaEntity;
import com.logistique.infrastructure.persistence.classe.entity.ClasseJpaEntity;
import com.logistique.infrastructure.persistence.inscription.entity.InscriptionJpaEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
public class EtudiantJpaEntity {
    @Id
    @Column(length = 15)
    private String matricule;
    @Column(length = 100)
    private String prenom;
    @Column(length = 50)
    private String nom;
    private LocalDate dateNaissance;
    @OneToMany(mappedBy = "etudiant")
    private List<InscriptionJpaEntity> inscriptionJpaEntityList;
}
