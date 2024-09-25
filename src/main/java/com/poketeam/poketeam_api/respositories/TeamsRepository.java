package com.poketeam.poketeam_api.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poketeam.poketeam_api.models.Team;

public interface TeamsRepository extends JpaRepository<Team, Integer> {

}
