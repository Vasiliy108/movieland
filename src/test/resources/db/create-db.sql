PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- Таблица: genre
DROP TABLE IF EXISTS genre;
CREATE TABLE genre (
    id         INTEGER       PRIMARY KEY AUTOINCREMENT,
    genre_name VARCHAR (200) 
);

-- Таблица: country
DROP TABLE IF EXISTS country;
CREATE TABLE country (
    id   INTEGER       PRIMARY KEY AUTOINCREMENT,
    name VARCHAR (300) 
);

-- Таблица: review
DROP TABLE IF EXISTS review;
CREATE TABLE review (
    id          INTEGER        PRIMARY KEY AUTOINCREMENT,
    movieid     NUMERIC        REFERENCES movie (id) ON DELETE NO ACTION
                                                     ON UPDATE NO ACTION,
    userid      NUMERIC        REFERENCES user (id) ON DELETE NO ACTION
                                                    ON UPDATE NO ACTION,
    review_text VARCHAR (4096) 
);


-- Таблица: user
DROP TABLE IF EXISTS user;
CREATE TABLE user (
    id       INTEGER       PRIMARY KEY AUTOINCREMENT,
    fullname VARCHAR (300),
    email    VARCHAR (300),
    password VARCHAR (300) 
);


-- Таблица: movie_genre
DROP TABLE IF EXISTS movie_genre;
CREATE TABLE movie_genre (
    id      INTEGER PRIMARY KEY AUTOINCREMENT,
    movieid NUMERIC REFERENCES movie (id) ON DELETE CASCADE
                                          ON UPDATE CASCADE,
    genreid NUMERIC REFERENCES genre (id) ON DELETE NO ACTION
                                          ON UPDATE NO ACTION
);


-- Таблица: movie
DROP TABLE IF EXISTS movie;
CREATE TABLE movie (
    id              INTEGER        PRIMARY KEY AUTOINCREMENT,
    movie_name      VARCHAR (500),
    movie_orig_name VARCHAR,
    year            NUMERIC,
    description     VARCHAR (4096),
    rating          NUMERIC (1, 1) CONSTRAINT ch_movie_rating CHECK ( ( (rating IS NULL) OR 
                                                                        (rating < 10) ) ),
    price           NUMERIC (7, 2) 
);

-- Таблица: movie_country
DROP TABLE IF EXISTS movie_country;
CREATE TABLE movie_country (
    id        INTEGER PRIMARY KEY AUTOINCREMENT,
    movieid   NUMERIC REFERENCES movie (id) ON DELETE CASCADE
                                            ON UPDATE CASCADE,
    countryid NUMERIC REFERENCES country (id) ON DELETE NO ACTION
                                              ON UPDATE NO ACTION
);

-- Таблица: poster
DROP TABLE IF EXISTS poster;
CREATE TABLE poster (
    id      INTEGER        PRIMARY KEY AUTOINCREMENT,
    movieid NUMERIC        REFERENCES movie (id) ON DELETE CASCADE
                                                 ON UPDATE CASCADE,
    url     VARCHAR (1000) 
);

COMMIT TRANSACTION;
PRAGMA foreign_keys = on;
