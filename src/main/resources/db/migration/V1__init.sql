CREATE TABLE IF NOT EXISTS generos (
id SERIAL,
nombre VARCHAR(100) NOT NULL,
ciudad VARCHAR(100) NOT NULL,
PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS peliculas (
id SERIAL,
titulo VARCHAR(100) NOT NULL,
productor VARCHAR(100) NOT NULL,
PRIMARY KEY (id),
generos_id INT NOT NULL,
FOREIGN KEY (generos_id ) REFERENCES generos(id)
);

