package com.luxoft.svinenkov.movieland.controller;

import com.luxoft.svinenkov.movieland.entity.Movie;
import com.luxoft.svinenkov.movieland.service.MovieService;
import com.luxoft.svinenkov.movieland.utils.JsonManualConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/movie", produces = "application/json; charset=utf-8")
public class MovieController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private MovieService movieService;

    @RequestMapping()
    @ResponseBody
    public String getAllMovies() {
        log.info("Sending request to get all movies");
        long startTime = System.currentTimeMillis();

        List<Movie> moviesList = movieService.getAllMovies();
        String moviesJsons = JsonManualConverter.listToJson(moviesList);

        log.info("Was received {} movies. It took {} ms", moviesJsons.length(), System.currentTimeMillis() - startTime);
        log.debug("Received movies list: \n{}\n ", moviesJsons);
        return moviesJsons;
    }
}