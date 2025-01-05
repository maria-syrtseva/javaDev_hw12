INSERT INTO client (name) VALUES ('Alice'), ('Bob'), ('Charlie'), ('Vitalik'), ('Eve'), ('Frank'), ('Grace'), ('Oksana'), ('Ivan'), ('Judy');

-- Add planets
INSERT INTO planet (id, name) VALUES ('MARS', 'Mars'), ('VEN', 'Venus'), ('EARTH', 'Earth'), ('JUP', 'Jupiter'), ('SAT', 'Saturn');

-- Add tickets
INSERT INTO ticket (client_id, from_planet_id, to_planet_id)
VALUES
(1, 'EARTH', 'MARS'),
(2, 'MARS', 'VEN'),
(3, 'VEN', 'EARTH'),
(4, 'EARTH', 'JUP'),
(5, 'JUP', 'SAT'),
(6, 'SAT', 'EARTH'),
(7, 'MARS', 'JUP'),
(8, 'VEN', 'SAT'),
(9, 'SAT', 'VEN'),
(10, 'EARTH', 'MARS');