package com.logistique.infrastructure.web.livraison;

import com.logistique.application.port.in.livreur.CreerLivreurUseCase;
import com.logistique.infrastructure.web.livraison.request.CreerLivreurRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/livreurs")
public class LivreurController {

    private final CreerLivreurUseCase creerLivreurUseCase;
    private final LivraisonWebMapper mapper;

    public LivreurController(CreerLivreurUseCase creerLivreurUseCase, LivraisonWebMapper mapper) {
        this.creerLivreurUseCase = creerLivreurUseCase;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<Map<String, UUID>> creer(@Valid @RequestBody CreerLivreurRequest request) {
        UUID id = creerLivreurUseCase.executer(mapper.toCommand(request));
        return ResponseEntity.created(URI.create("/api/livreurs/" + id))
                .body(Map.of("livreurId", id));
    }
}
