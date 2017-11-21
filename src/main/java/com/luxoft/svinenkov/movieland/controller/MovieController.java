package com.luxoft.svinenkov.movieland.controller;

import com.luxoft.svinenkov.movieland.entity.Movie;
import com.luxoft.svinenkov.movieland.service.MovieService;
import com.luxoft.svinenkov.movieland.utils.JsonManualConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping(path = "/movie", produces = "application/json; charset=utf-8")
public class MovieController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private MovieService movieService;

    @Autowired
    private JsonManualConverter jsonConverter;

    //@Autowired
    //private JsonJacksonConverter jsonJacksonConverter;

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

    @RequestMapping()
    @ResponseBody
    public String getAllMovies() {
        log.info("Sending request to get all movies");
        long startTime = System.currentTimeMillis();

        /*
        "id"            : 1,
        "nameRussian"   : "Побег из Шоушенка",
        "nameNative"    : "The Shawshank Redemption",
        "yearOfRelease" : "1994",
        "rating"        : 8.89,
        "price"         : 123.45,
        "picturePath"   : "https://images-na.ssl-images-amazon.com/images/M/MV5BODU4MjU4NjIwNl5BMl5BanBnXkFtZTgwMDU2MjEyMDE@._V1._SY209_CR0,0,140,209_.jpg"
        */

        List<Movie> moviesList = movieService.getAllMovies();
        String moviesJsons = jsonConverter.listToJson(moviesList);

        log.info("Movies \n{}\n are received. It took {} ms", moviesJsons, System.currentTimeMillis() - startTime);
        return moviesJsons;
    }

    public void setJsonConverter(JsonManualConverter jsonConverter) {
        this.jsonConverter = jsonConverter;
    }
}