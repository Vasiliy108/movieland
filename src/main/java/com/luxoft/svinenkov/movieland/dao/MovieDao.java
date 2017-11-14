package com.luxoft.svinenkov.movieland.dao;
import com.luxoft.svinenkov.movieland.entity.Movie;

public interface MovieDao {
    Movie getById(int id);

    void add(Movie movie);
}
