package com.webflux.pokedex.app.service;

import com.webflux.pokedex.app.model.Pokemon;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.concurrent.ExecutionException;

public interface IPokedexService {

    Mono<Pokemon> findPokemonById(int id) throws ExecutionException, InterruptedException;
    Mono<Pokemon> findPokemonByName(String title);
    Flux<Pokemon> findAllPokemon();
    Mono<Pokemon> savePokemon(Pokemon todo);
    Mono<Void> deletePokemonById(int id);
}
