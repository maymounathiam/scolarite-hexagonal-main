package com.logistique.application.port.in.livraison;

import com.logistique.application.command.livraison.DeclarerIncidentCommand;
import com.logistique.application.command.livraison.ResoudreIncidentCommand;

public interface GererIncidentUseCase {

    void declarer(DeclarerIncidentCommand command);

    void resoudre(ResoudreIncidentCommand command);
}
