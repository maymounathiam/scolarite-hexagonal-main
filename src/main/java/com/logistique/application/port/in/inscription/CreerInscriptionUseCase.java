package com.logistique.application.port.in.inscription;

import com.logistique.application.command.iscription.CreerInscriptionCommand;
import org.springframework.web.multipart.MultipartFile;

public interface CreerInscriptionUseCase {
    byte[] executer(CreerInscriptionCommand command, MultipartFile preuvePaiement);
}
