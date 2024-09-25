package com.poketeam.poketeam_api.requests;

import java.util.List;

import com.poketeam.poketeam_api.models.Pokemon;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateRequest(@NotBlank String name, @NotNull List<Pokemon> pokemons) {

}
