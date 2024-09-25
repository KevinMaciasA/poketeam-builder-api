package com.poketeam.poketeam_api.requests;

import java.util.List;

import com.poketeam.poketeam_api.models.Pokemon;

public record UpdateRequest(String name, List<Pokemon> pokemons) {

}
