# logistique-hexagonal

API de **gestion de livraisons** (architecture hexagonale, Spring Boot 3, JPA MySQL ou dépôts en mémoire).

## Lancer

```bash
mvn spring-boot:run
```

Profil par défaut : **`mysql`** (`application.yml`). Pour les tests unitaires des cas d’usage sans base, les services utilisent directement `InMemoryLivraisonRepository` / `InMemoryLivreurRepository`.

## Structure `src/main/java/com/logistique`

| Zone | Contenu |
|------|---------|
| **domain** | `entity/livraison`, `entity/livreur`, `policy/livraison`, `exception` (logistique), `shared` (EntityId, AggregateRoot). |
| **application** | Commandes, ports in/out, services use case livraison/livreur, `LivraisonSuiviView`. |
| **infrastructure** | Contrôleurs REST `/api/livraisons`, `/api/livreurs`, persistance JPA `livraison` / `livreur`, adaptateurs MySQL + in-memory, `ValidationExceptionHandler`. |

## API REST

- `POST /api/livreurs` — créer un livreur  
- `POST /api/livraisons` — créer une livraison  
- `POST /api/livraisons/{id}/assignation` — assigner un livreur  
- `POST /api/livraisons/{id}/demarrage` — démarrer le parcours  
- `GET /api/livraisons/{id}` ou `GET /api/livraisons?reference=` — suivi  
- `POST /api/livraisons/{id}/confirmation` — confirmer  
- `POST /api/livraisons/{id}/incidents` et `.../incidents/resolution` — incidents  

## Tests

```bash
mvn test "-Dtest=LivraisonTest,LivraisonPolicyTest,LivraisonUseCaseTest"
```

## Ancien périmètre « scolarité »

Le code année académique, inscriptions, paiements, Kafka, outbox, PDF Thymeleaf et tests associés a été **retiré** du dépôt pour ne garder que la logistique.

Les fichiers `docker-compose*.yml` à la racine peuvent encore décrire Kafka ; ils ne sont plus requis par l’application Java actuelle.
