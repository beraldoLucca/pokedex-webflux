package com.webflux.pokedex.app.repository;

import com.webflux.pokedex.app.model.Pokemon;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface IPokemonRepository extends ReactiveCrudRepository<Pokemon, String> {

    Mono<Pokemon> findPokemonByName(String title);
}
