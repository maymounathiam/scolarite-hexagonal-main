package com.logistique.application.port.in.paiement;

import com.logistique.application.command.paiement.DeclarerPaiementCommand;
import jakarta.validation.Valid;
import org.springframework.web.multipart.MultipartFile;

public interface DeclarerPaiementUseCase {
    void execute(DeclarerPaiementCommand command, @Valid MultipartFile preuvePaiement);
}
