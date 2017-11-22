package com.luxoft.svinenkov.movieland.service.impl;

import com.luxoft.svinenkov.movieland.dao.MovieDao;
import com.luxoft.svinenkov.movieland.entity.Movie;
import com.luxoft.svinenkov.movieland.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieDao movieDao;

    public List <Movie> getAllMovies() {
        return movieDao.getAllMovies();
    }
}
