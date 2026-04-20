package com.logistique.application.port.out.repository.impl;

import com.logistique.application.port.out.repository.FiliereRepository;
import com.logistique.domain.entity.school.CodeFiliere;
import com.logistique.domain.entity.school.Filiere;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class InMemoryFiliereRepository implements FiliereRepository {
    private final Map<CodeFiliere, Filiere> data = new HashMap<>();

    @Override
    public boolean existsByCode(CodeFiliere code) {
        return data.containsKey(code);
    }

    @Override
    public void save(Filiere filiere) {
        data.put(filiere.getCodeFiliere(), filiere);
    }

    @Override
    public Optional<Filiere> findByCode(CodeFiliere code) {
        return Optional.ofNullable(data.get(code));
    }
}
