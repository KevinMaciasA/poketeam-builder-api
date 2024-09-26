package com.poketeam.poketeam_api.requests;

import java.util.List;

import com.poketeam.poketeam_api.models.Pokemon;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record TeamRequest(@NotBlank String name, @NotNull @Size(min = 0, max = 6) List<Pokemon> pokemons) {

}
