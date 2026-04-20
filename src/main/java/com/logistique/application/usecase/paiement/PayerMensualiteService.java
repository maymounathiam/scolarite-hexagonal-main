package com.logistique.application.usecase.paiement;


import com.logistique.application.command.paiement.DeclarerPaiementCommand;
import com.logistique.application.port.in.paiement.DeclarerPaiementUseCase;
import com.logistique.application.port.out.event.DomainEventPublisher;
import com.logistique.application.port.out.repository.ClasseRepository;
import com.logistique.application.port.out.repository.InscriptionRepository;
import com.logistique.application.port.out.repository.PaiementRepository;
import com.logistique.application.service.paiement.PaiementApplicationService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class PayerMensualiteService implements DeclarerPaiementUseCase {

    private final PaiementRepository paiementRepository;
    private final InscriptionRepository inscriptionRepository;
    private final ClasseRepository classeRepository;
    private final DomainEventPublisher eventPublisher;
    private final PaiementApplicationService paiementApplicationService1;

    public PayerMensualiteService(PaiementRepository paiementRepository, InscriptionRepository inscriptionRepository, ClasseRepository classeRepository, DomainEventPublisher eventPublisher, PaiementApplicationService paiementApplicationService1) {
        this.paiementRepository = paiementRepository;
        this.inscriptionRepository = inscriptionRepository;
        this.classeRepository = classeRepository;
        this.eventPublisher = eventPublisher;
        this.paiementApplicationService1 = paiementApplicationService1;
    }

    @Override
    public void execute(DeclarerPaiementCommand cmd, MultipartFile preuvePaiement) {
        String nomFichier = "";
        if (!preuvePaiement.isEmpty()) {
            nomFichier = preuvePaiement.getOriginalFilename();
        }
        paiementApplicationService1.payerMensualite(cmd, nomFichier);

    }
}
