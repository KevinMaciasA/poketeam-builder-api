package com.poketeam.poketeam_api.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poketeam.poketeam_api.models.Pokemon;

public interface PokemonsRepository extends JpaRepository<Pokemon, Integer> {

}
