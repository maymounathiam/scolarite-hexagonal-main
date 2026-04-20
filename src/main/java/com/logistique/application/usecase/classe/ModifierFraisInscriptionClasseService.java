package com.logistique.application.usecase.classe;

import com.logistique.application.command.classe.ModifierFraisInscriptionClasseCommand;
import com.logistique.application.port.in.classe.ModifierFraisInscriptionClasseUseCase;
import com.logistique.application.port.out.repository.ClasseRepository;
import com.logistique.domain.entity.school.Classe;
import com.logistique.domain.entity.school.CodeClasse;
import com.logistique.domain.entity.school.Montant;
import com.logistique.domain.exception.ScolariteNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ModifierFraisInscriptionClasseService implements ModifierFraisInscriptionClasseUseCase {

    private final ClasseRepository repository;

    public ModifierFraisInscriptionClasseService(ClasseRepository repository) {
        this.repository = repository;
    }

    @Override
    public void executer(ModifierFraisInscriptionClasseCommand cmd) {

        CodeClasse code = new CodeClasse(cmd.codeClasse());

        Classe classe = repository.findById(code)
                .orElseThrow(() -> new ScolariteNotFoundException(
                        "Classe introuvable : " + cmd.codeClasse()
                ));

        // Création des nouveaux Value Objects
        Montant nouveauxAutresFrais = new Montant(cmd.nouveauxFraisInscription());
        classe.modifierFraisInscrition(nouveauxAutresFrais);

        // Sauvegarde de l’état cohérent
        repository.save(classe);
    }
}
