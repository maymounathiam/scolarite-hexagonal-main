package com.logistique.infrastructure.persistence.paiement.repository;

import com.logistique.domain.entity.paiement.Paiement;
import com.logistique.domain.entity.paiement.PaiementId;
import com.logistique.domain.entity.paiement.StatutPaiement;
import com.logistique.domain.entity.paiement.TypePaiement;
import com.logistique.infrastructure.persistence.paiement.entity.PaiementJpaEntity;
import com.logistique.infrastructure.persistence.paiement.entity.StatutJpaPaiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface PaiementJpaRepository extends JpaRepository<PaiementJpaEntity, UUID> {
    List<PaiementJpaEntity> findByStatut(StatutJpaPaiement statut);
    //boolean existsByReferenceBancaire(String reference);
    //boolean existsByReferenceMobileMoney(String reference);
    List<PaiementJpaEntity> findByMatriculeAndAnneeAcademique(String matricule, String anneeAcademique);
    List<PaiementJpaEntity> findByMatriculeAndAnneeAcademiqueAndTypePaiementAndStatutInOrderByMoisAcademiqueAnneeAscMoisAcademiqueMoisAsc(
            String matricule,
            String anneeAcademique,
            TypePaiement typePaiement,
            List<StatutJpaPaiement> statuts
    );

    List<PaiementJpaEntity> findByMatriculeAndAnneeAcademiqueOrderByMoisAcademiqueAnneeAscMoisAcademiqueMoisAsc(String matricule, String anneeAcademique);

    List<PaiementJpaEntity> findByIdIn(List<UUID> paiements);

}
