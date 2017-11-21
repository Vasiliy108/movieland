package com.luxoft.svinenkov.movieland.dao;
import com.luxoft.svinenkov.movieland.entity.Movie;

import java.util.List;

public interface MovieDao {
    Movie getById(int id);

    List <Movie> getAllMovies();
}
