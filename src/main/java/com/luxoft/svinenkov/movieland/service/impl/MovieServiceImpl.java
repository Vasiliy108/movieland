package com.luxoft.svinenkov.movieland.service.impl;

import com.luxoft.svinenkov.movieland.dao.MovieDao;
import com.luxoft.svinenkov.movieland.entity.Movie;
import com.luxoft.svinenkov.movieland.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieDao movieDao;

    @Override
    public Movie getById(int id) {
        return movieDao.getById(id);
    }

    @Override
    public void add(Movie movie) {
        movieDao.add(movie);
    }

}
