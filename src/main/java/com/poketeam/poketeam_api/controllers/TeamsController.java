package com.poketeam.poketeam_api.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.util.UriComponentsBuilder;

import com.poketeam.poketeam_api.models.Pokemon;
import com.poketeam.poketeam_api.models.Team;
import com.poketeam.poketeam_api.models.dtos.TeamData;
import com.poketeam.poketeam_api.requests.TeamRequest;
import com.poketeam.poketeam_api.requests.UpdateRequest;
import com.poketeam.poketeam_api.respositories.PokemonsRepository;
import com.poketeam.poketeam_api.respositories.TeamsRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/teams")
public class TeamsController {
  @Autowired
  TeamsRepository teamsRepository;
  @Autowired
  PokemonsRepository pokemonsRepository;

  @GetMapping
  public ResponseEntity<List<Team>> getAllTeams() {
    List<Team> allTeams = teamsRepository
        .findAll();

    return ResponseEntity.ok(allTeams);
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<?> getTeamById(@PathVariable Integer id) {
    Optional<Team> maybeTeam = teamsRepository.findById(id);

    if (maybeTeam.isPresent())
      return ResponseEntity.ok(maybeTeam.get());

    return ResponseEntity.notFound().build();
  }

  @PostMapping
  public ResponseEntity<TeamData> postTeam(@Valid @RequestBody TeamRequest teamRequest, UriComponentsBuilder uri) {
    List<Pokemon> pokemons = new ArrayList<>();
    System.out.println(teamRequest.name());
    for (Pokemon pokemon : teamRequest.pokemons()) {
      var maybePokemon = pokemonsRepository.findById(pokemon.getId());
      System.out.println(maybePokemon);
      if (maybePokemon.isPresent())
        pokemons.add(maybePokemon.get());
      else {
        pokemonsRepository.save(pokemon);
        pokemons.add(pokemon);
      }
    }

    var newTeam = new Team(teamRequest.name(), pokemons);
    var result = teamsRepository.save(newTeam);
    var path = uri.path("teams/{id}").buildAndExpand(result.getId()).toUri();
    return ResponseEntity
        .created(path)
        .body(result.data());
  }

  @PatchMapping(path = "/{id}")
  public ResponseEntity<?> updateTeam(@PathVariable Integer id, @RequestBody UpdateRequest updateRequest,
      UriComponentsBuilder uri) {
    if (teamsRepository.existsById(id)) {
      var team = teamsRepository.getReferenceById(id);
      team.update(updateRequest);
      return ResponseEntity.ok(team);
    }

    return ResponseEntity.notFound().build();
  }

  @DeleteMapping(path = "/{id}")
  public ResponseEntity<?> deleteTeam(@PathVariable Integer id) {
    if (teamsRepository.existsById(id)) {
      teamsRepository.deleteById(id);
      return ResponseEntity.noContent().build();
    }

    return ResponseEntity.notFound().build();
  }
}
