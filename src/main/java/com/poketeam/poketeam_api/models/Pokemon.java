package com.poketeam.poketeam_api.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pokemons")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pokemon {
  @Id
  private Integer id;
  @Column(nullable = false)
  private String name;
  @Column(nullable = true)
  private String imgUrl;
}
