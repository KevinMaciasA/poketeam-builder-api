package com.poketeam.poketeam_api.models;

import java.time.LocalDateTime;
import java.util.List;

import com.poketeam.poketeam_api.models.dtos.TeamData;
import com.poketeam.poketeam_api.requests.UpdateRequest;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "teams")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Team {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Column(length = 255)
  private String name;
  @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
  @JoinTable(name = "team_pokemons", joinColumns = @JoinColumn(name = "team_id"), inverseJoinColumns = @JoinColumn(name = "pokemon_id"))
  private List<Pokemon> pokemons;
  @Column(nullable = false, updatable = false)
  private LocalDateTime createdAt;
  @Column(nullable = true)
  private LocalDateTime updatedAt;

  @PrePersist
  void onCreate() {
    this.createdAt = LocalDateTime.now();
  }

  @PreUpdate
  void onUpdate() {
    this.updatedAt = LocalDateTime.now();
  }

  public Team(String name, List<Pokemon> pokemons) {
    this.name = name;
    this.pokemons = pokemons;
    this.createdAt = LocalDateTime.now();
    this.updatedAt = LocalDateTime.now();
  }

  public void update(UpdateRequest updateRequest) {
    if (updateRequest.name() != null)
      this.name = updateRequest.name();
    if (updateRequest.pokemons() != null)
      this.pokemons = updateRequest.pokemons();

    this.updatedAt = LocalDateTime.now();
  }

  public TeamData data() {
    return new TeamData(
        this.id,
        this.name,
        this.createdAt);
  }
}
