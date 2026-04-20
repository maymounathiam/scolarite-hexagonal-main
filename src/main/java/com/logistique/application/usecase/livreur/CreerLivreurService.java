package com.logistique.application.usecase.livreur;

import com.logistique.application.command.livreur.CreerLivreurCommand;
import com.logistique.application.port.in.livreur.CreerLivreurUseCase;
import com.logistique.application.port.out.repository.LivreurRepository;
import com.logistique.domain.entity.livreur.Livreur;
import com.logistique.domain.entity.livreur.NomLivreur;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CreerLivreurService implements CreerLivreurUseCase {

    private final LivreurRepository livreurRepository;

    public CreerLivreurService(LivreurRepository livreurRepository) {
        this.livreurRepository = livreurRepository;
    }

    @Override
    public UUID executer(CreerLivreurCommand command) {
        Livreur livreur = Livreur.creer(new NomLivreur(command.nom()));
        livreurRepository.save(livreur);
        return livreur.getId().value();
    }
}
