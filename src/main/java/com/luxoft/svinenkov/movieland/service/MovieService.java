package com.luxoft.svinenkov.movieland.service;

import com.luxoft.svinenkov.movieland.entity.Movie;

import java.util.List;

public interface MovieService {
    Movie getById(int id);

    List <Movie> getAllMovies();
}
