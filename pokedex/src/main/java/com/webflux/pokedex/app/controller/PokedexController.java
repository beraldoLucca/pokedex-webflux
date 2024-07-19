package com.webflux.pokedex.app.controller;

import com.webflux.pokedex.app.model.Pokemon;
import com.webflux.pokedex.app.service.IPokedexService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/v1/pokedex")
public class PokedexController {

    private final IPokedexService service;

    @Autowired
    public PokedexController(IPokedexService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find Pokemon by id.")
    Mono<ResponseEntity<Pokemon>> findTodoById(@PathVariable int id) throws ExecutionException, InterruptedException {
        return service.findPokemonById(id)
                .map(ResponseEntity::ok);
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Find all Todos")
    Flux<Pokemon> findAllPokemon() {
        return service.findAllPokemon();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create Pokemon.")
    Mono<ResponseEntity<Pokemon>> savePokemon(@RequestBody Pokemon pokemon) {
        return service.savePokemon(pokemon)
                .map(poke -> ResponseEntity.status(HttpStatus.CREATED).body(poke));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete Pokemon by id.")
    Mono<Void> deletePokemonById(@PathVariable int id) {
        return service.deletePokemonById(id);
    }

    @GetMapping("/search")
    @Operation(summary = "Search Pokemon by title.")
    Mono<ResponseEntity<Pokemon>> searchPokemonByTitle(@RequestParam String title) {
        return service.findPokemonByName(title)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
