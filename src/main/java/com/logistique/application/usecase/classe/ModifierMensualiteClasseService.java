package com.logistique.application.usecase.classe;

import com.logistique.application.command.classe.ModifierMensualiteClasseCommand;
import com.logistique.application.port.in.classe.ModifierMensualiteClasseUseCase;
import com.logistique.application.port.out.repository.ClasseRepository;
import com.logistique.domain.entity.school.Classe;
import com.logistique.domain.entity.school.CodeClasse;
import com.logistique.domain.entity.school.Montant;
import com.logistique.domain.exception.ScolariteNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ModifierMensualiteClasseService implements ModifierMensualiteClasseUseCase {

    private final ClasseRepository repository;

    public ModifierMensualiteClasseService(ClasseRepository repository) {
        this.repository = repository;
    }

    @Override
    public void executer(ModifierMensualiteClasseCommand cmd) {

        CodeClasse code = new CodeClasse(cmd.codeClasse());

        Classe classe = repository.findById(code)
                .orElseThrow(() -> new ScolariteNotFoundException(
                        "Classe introuvable : " + cmd.codeClasse()
                ));

        // Création des nouveaux Value Objects
        Montant nouvelleMensualite = new Montant(cmd.nouvelleMensualite());
        classe.modifierFraisInscrition(nouvelleMensualite);

        // Sauvegarde de l’état cohérent
        repository.save(classe);
    }
}
