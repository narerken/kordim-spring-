INSERT INTO t_country (name) VALUES ('USA'), ('UK'), ('KZ');
INSERT INTO t_genre (name) VALUES ('Horror'), ('Sci-Fi'), ('Thriller');
INSERT INTO t_movie (title, year, country_id) VALUES
                                                  ('Inception', 2000, 1),
                                                  ('Catch Me If You Can', 1990, 2);
INSERT INTO movie_genres (movie_id, genre_id) VALUES (1, 1), (1, 2);