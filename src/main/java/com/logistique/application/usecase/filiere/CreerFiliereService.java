package com.logistique.application.usecase.filiere;

import com.logistique.application.command.filiere.CreerFiliereCommand;
import com.logistique.application.port.in.filiere.CreerFiliereUseCase;
import com.logistique.application.port.out.repository.FiliereRepository;
import com.logistique.domain.entity.school.CodeFiliere;
import com.logistique.domain.entity.school.Filiere;
import com.logistique.domain.entity.school.NomFiliere;
import org.springframework.stereotype.Service;

@Service
public class CreerFiliereService implements CreerFiliereUseCase {

    private final FiliereRepository repository;

    public CreerFiliereService(FiliereRepository repository) {
        this.repository = repository;
    }

    @Override
    public void executer(CreerFiliereCommand cmd) {

        CodeFiliere code = new CodeFiliere(cmd.codeFiliere());
        NomFiliere nom = new NomFiliere(cmd.nomFiliere());

        if (repository.existsByCode(code)) {
            throw new IllegalStateException("La filière existe déjà");
        }

        Filiere filiere = new Filiere(code, nom);

        repository.save(filiere);
    }
}
