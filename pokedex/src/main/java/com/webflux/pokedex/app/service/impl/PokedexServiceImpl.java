package com.webflux.pokedex.app.service.impl;

import com.webflux.pokedex.app.model.Pokemon;
import com.webflux.pokedex.app.repository.IPokemonRepository;
import com.webflux.pokedex.app.service.IPokedexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PokedexServiceImpl implements IPokedexService {

    private final IPokemonRepository repository;

    @Autowired
    public PokedexServiceImpl(IPokemonRepository repository) {
        this.repository = repository;
    }

    @Override
    public Mono<Pokemon> findPokemonById(int id) {
        return repository.findById(String.valueOf(id)).switchIfEmpty(Mono.error(new Exception(String.format("Todo not found. ID: %s", id))));
    }

    @Override
    public Mono<Pokemon> findPokemonByName(String title) {
        return repository.findPokemonByName(title);
    }

    @Override
    public Flux<Pokemon> findAllPokemon() {
        return repository.findAll();
    }

    @Override
    public Mono<Pokemon> savePokemon(Pokemon pokemon) {
        return repository.save(pokemon);
    }

    @Override
    public Mono<Void> deletePokemonById(int id) {
        return repository.deleteById(String.valueOf(id));
    }
}
