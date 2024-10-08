CREATE TABLE teams (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE pokemons (
  id INT NOT NULL PRIMARY KEY,
  name VARCHAR(255) NOT NULL UNIQUE COLLATE utf8mb4_unicode_ci,
  img_url VARCHAR(2048) DEFAULT ""
);

CREATE TABLE team_pokemons (
  team_id INT NOT NULL,
  pokemon_id INT NOT NULL,
  PRIMARY KEY (team_id, pokemon_id),
  CONSTRAINT fk_team FOREIGN KEY (team_id) REFERENCES teams(id) ON DELETE CASCADE,
  CONSTRAINT fk_pokemon FOREIGN KEY (pokemon_id) REFERENCES pokemons(id) ON DELETE CASCADE
);
