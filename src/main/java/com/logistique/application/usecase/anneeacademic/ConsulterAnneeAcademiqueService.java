package com.logistique.application.usecase.anneeacademic;

import com.logistique.application.mapper.AnneeAcademiqueMapper;
import com.logistique.application.port.out.repository.AnneeAcademiqueRepository;
import com.logistique.application.query.anneeacademique.AnneeAcademiqueView;
import com.logistique.application.port.in.anneeacademique.ConsulterAnneeAcademiqueUseCase;
import com.logistique.domain.entity.academic.AnneeAcademique;
import com.logistique.domain.entity.academic.AnneeAcademiqueId;
import com.logistique.domain.exception.ScolariteNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ConsulterAnneeAcademiqueService
        implements ConsulterAnneeAcademiqueUseCase {

    private final AnneeAcademiqueRepository repository;
    private final AnneeAcademiqueMapper mapper;


    public ConsulterAnneeAcademiqueService(
            AnneeAcademiqueRepository repository, AnneeAcademiqueMapper mapper
    ) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public AnneeAcademiqueView executer(String code) {

        AnneeAcademiqueId id = new AnneeAcademiqueId(
                Integer.parseInt(code)
        );

        AnneeAcademique annee = repository.findByCode(id.value())
                .orElseThrow(() -> new ScolariteNotFoundException(
                        "Année académique inexistante"
                ));

        return mapper.toView(annee);
    }
}

