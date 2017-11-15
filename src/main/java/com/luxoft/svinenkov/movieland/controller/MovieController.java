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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
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

    @RequestMapping("")
    @ResponseBody
    public String getAllMovies() {
        final String jsonsDelimiter = ",\n";

        log.info("Sending request to get all movies");
        long startTime = System.currentTimeMillis();

        List<Movie> moviesList = movieService.getAllMovies();
        StringBuilder sb = new StringBuilder();

//        for ( Movie movie : moviesList ) {
//            sb.append( jsonConverter.toJson(movie) );
//            sb.append( jsonsDelimiter );
//        }
//        sb.delete( sb.length()-jsonsDelimiter.length(), sb.length() );

        Iterator<Movie> moviesIterator = moviesList.iterator();
        if( moviesIterator.hasNext() ) {
            sb.append( jsonConverter.toJson( moviesIterator.next() ) );
        }
        while( moviesIterator.hasNext() ) {
            sb.append( jsonsDelimiter );
            sb.append( jsonConverter.toJson( moviesIterator.next() ) );
        }

        log.info("Movies are received. It took {} ms", System.currentTimeMillis() - startTime);
        return sb.toString();
    }
}