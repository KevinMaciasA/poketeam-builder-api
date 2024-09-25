INSERT INTO pokemons (id, name, img_url) VALUES
(1, 'Bulbasaur', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png'),
(4, 'Charmander', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/4.png'),
(7, 'Squirtle', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/7.png'),
(25, 'Pikachu', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/25.png'),
(39, 'Jigglypuff', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/39.png'),
(52, 'Meowth', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/52.png');

INSERT INTO teams (id, name, created_at) VALUES
(1, 'Team Rocket', NOW()),
(2, 'Team Ash', NOW());

-- Team Rocket <-> Pokemons
INSERT INTO team_pokemons (team_id, pokemon_id) VALUES
(1, 39), -- Jigglypuff
(1, 52); -- Meowth

-- Team Ash <-> Pokemons
INSERT INTO team_pokemons (team_id, pokemon_id) VALUES
(2, 1), -- Bulbasaur
(2, 4), -- Charmander
(2, 7), -- Squirtle
(2, 25); -- Pikachu
