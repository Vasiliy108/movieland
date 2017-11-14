package com.luxoft.svinenkov.movieland.controller;

import com.luxoft.svinenkov.movieland.entity.Movie;
import com.luxoft.svinenkov.movieland.service.MovieService;
import com.luxoft.svinenkov.movieland.utils.JsonJacksonConverter;
import com.luxoft.svinenkov.movieland.utils.JsonManualConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@RequestMapping("/v1/movie")
@RequestMapping(path = "/v1/movie", produces = "application/json; charset=utf-8")
public class MovieController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private MovieService movieService;

    @Autowired
    private JsonManualConverter jsonConverter;

    @Autowired
    private JsonJacksonConverter jsonJacksonConverter;

    @RequestMapping("/{movieId}")
    @ResponseBody
    public String getMovieById(@PathVariable int movieId) {
        log.info("Sending request to get movie with id = {}", movieId);
        long startTime = System.currentTimeMillis();
        Movie movie = movieService.getById(movieId);
        String movieJson = jsonConverter.toJson(movie);
        log.info("Movie {} is received. It took {} ms", movieJson, System.currentTimeMillis() - startTime);
        return movieJson;
    }
}