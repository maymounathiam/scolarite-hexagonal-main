package com.logistique.application.usecase.classe;

import com.logistique.application.command.classe.ModifierAutresFraisClasseCommand;
import com.logistique.application.port.in.classe.ModifierAutresFraisClasseUseCase;
import com.logistique.application.port.out.repository.ClasseRepository;
import com.logistique.domain.entity.school.Classe;
import com.logistique.domain.entity.school.CodeClasse;
import com.logistique.domain.entity.school.Montant;
import com.logistique.domain.exception.ScolariteNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ModifierAutresFraisClasseService implements ModifierAutresFraisClasseUseCase {

    private final ClasseRepository repository;

    public ModifierAutresFraisClasseService(ClasseRepository repository) {
        this.repository = repository;
    }

    @Override
    public void executer(ModifierAutresFraisClasseCommand cmd) {

        CodeClasse code = new CodeClasse(cmd.codeClasse());

        Classe classe = repository.findById(code)
                .orElseThrow(() -> new ScolariteNotFoundException(
                        "Classe introuvable : " + cmd.codeClasse()
                ));

        // Création des nouveaux Value Objects
        Montant nouveauxAutresFrais = new Montant(cmd.nouveauxAutresFrais());

        // Règles métier déléguées à l’agrégat
        classe.modifierAutresFrais(nouveauxAutresFrais);

        // Sauvegarde de l’état cohérent
        repository.save(classe);
    }
}
