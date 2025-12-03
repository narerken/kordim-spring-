CREATE TABLE t_country(
    id SERIAL PRIMARY KEY,
    name TEXT NOT NULL
);

CREATE TABLE t_genre(
                          id SERIAL PRIMARY KEY,
                          name TEXT NOT NULL
);

CREATE TABLE t_movie (
                         id SERIAL PRIMARY KEY,
                         title TEXT NOT NULL,
                         year INT,
                         country_id INT,
                         CONSTRAINT fk_country FOREIGN KEY (country_id)
                             REFERENCES t_country(id) ON DELETE SET NULL
);

CREATE TABLE movie_genres (
                              movie_id INT NOT NULL,
                              genre_id INT NOT NULL,
                              PRIMARY KEY(movie_id, genre_id),
                              CONSTRAINT fk_movie FOREIGN KEY(movie_id) REFERENCES t_movie(id) ON DELETE CASCADE,
                              CONSTRAINT fk_genre FOREIGN KEY(genre_id) REFERENCES t_genre(id) ON DELETE CASCADE
);
