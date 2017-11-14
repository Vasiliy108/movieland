package com.luxoft.svinenkov.movieland.service;

import com.luxoft.svinenkov.movieland.entity.Movie;

public interface MovieService {
    Movie getById(int id);

    void add(Movie movie);
}
