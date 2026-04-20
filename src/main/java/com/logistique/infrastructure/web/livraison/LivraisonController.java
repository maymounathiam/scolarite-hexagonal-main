package com.logistique.infrastructure.web.livraison;

import com.logistique.application.command.livraison.ConfirmerLivraisonCommand;
import com.logistique.application.command.livraison.DemarrerLivraisonCommand;
import com.logistique.application.command.livraison.ResoudreIncidentCommand;
import com.logistique.application.port.in.livraison.*;
import com.logistique.infrastructure.web.livraison.request.*;
import com.logistique.infrastructure.web.livraison.response.LivraisonSuiviResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/livraisons")
public class LivraisonController {

    private final CreerLivraisonUseCase creerLivraisonUseCase;
    private final AssignerLivreurUseCase assignerLivreurUseCase;
    private final DemarrerLivraisonUseCase demarrerLivraisonUseCase;
    private final SuivreLivraisonUseCase suivreLivraisonUseCase;
    private final ConfirmerLivraisonUseCase confirmerLivraisonUseCase;
    private final GererIncidentUseCase gererIncidentUseCase;
    private final LivraisonWebMapper mapper;

    public LivraisonController(
            CreerLivraisonUseCase creerLivraisonUseCase,
            AssignerLivreurUseCase assignerLivreurUseCase,
            DemarrerLivraisonUseCase demarrerLivraisonUseCase,
            SuivreLivraisonUseCase suivreLivraisonUseCase,
            ConfirmerLivraisonUseCase confirmerLivraisonUseCase,
            GererIncidentUseCase gererIncidentUseCase,
            LivraisonWebMapper mapper
    ) {
        this.creerLivraisonUseCase = creerLivraisonUseCase;
        this.assignerLivreurUseCase = assignerLivreurUseCase;
        this.demarrerLivraisonUseCase = demarrerLivraisonUseCase;
        this.suivreLivraisonUseCase = suivreLivraisonUseCase;
        this.confirmerLivraisonUseCase = confirmerLivraisonUseCase;
        this.gererIncidentUseCase = gererIncidentUseCase;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<Map<String, UUID>> creer(@Valid @RequestBody CreerLivraisonRequest request) {
        UUID id = creerLivraisonUseCase.executer(mapper.toCommand(request));
        return ResponseEntity.created(URI.create("/api/livraisons/" + id))
                .body(Map.of("livraisonId", id));
    }

    @PostMapping("/{livraisonId}/assignation")
    public ResponseEntity<Void> assigner(
            @PathVariable UUID livraisonId,
            @Valid @RequestBody AssignerLivreurRequest request
    ) {
        assignerLivreurUseCase.executer(mapper.toAssignerCommand(livraisonId, request.livreurId()));
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{livraisonId}/demarrage")
    public ResponseEntity<Void> demarrer(@PathVariable UUID livraisonId) {
        demarrerLivraisonUseCase.executer(new DemarrerLivraisonCommand(livraisonId));
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{livraisonId}")
    public LivraisonSuiviResponse suivreParId(@PathVariable UUID livraisonId) {
        return mapper.toResponse(suivreLivraisonUseCase.consulterParId(livraisonId));
    }

    @GetMapping(params = "reference")
    public LivraisonSuiviResponse suivreParReference(@RequestParam String reference) {
        return mapper.toResponse(suivreLivraisonUseCase.consulterParReference(reference));
    }

    @PostMapping("/{livraisonId}/confirmation")
    public ResponseEntity<Void> confirmer(@PathVariable UUID livraisonId) {
        confirmerLivraisonUseCase.executer(new ConfirmerLivraisonCommand(livraisonId));
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{livraisonId}/incidents")
    public ResponseEntity<Void> declarerIncident(
            @PathVariable UUID livraisonId,
            @Valid @RequestBody DeclarerIncidentRequest request
    ) {
        gererIncidentUseCase.declarer(mapper.toDeclarerCommand(livraisonId, request.motif()));
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{livraisonId}/incidents/resolution")
    public ResponseEntity<Void> resoudreIncident(@PathVariable UUID livraisonId) {
        gererIncidentUseCase.resoudre(new ResoudreIncidentCommand(livraisonId));
        return ResponseEntity.noContent().build();
    }
}
