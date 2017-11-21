package com.luxoft.svinenkov.movieland.dao.jbbc;

import com.luxoft.svinenkov.movieland.dao.MovieDao;
import com.luxoft.svinenkov.movieland.dao.jbbc.mapper.MovieRowMapper;
import com.luxoft.svinenkov.movieland.entity.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieDaoImpl implements MovieDao {
    private final Logger log = LoggerFactory.getLogger(getClass());
    private static final MovieRowMapper movieRowMapper = new MovieRowMapper();

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedJdbcTemplate;

    @Autowired
    private String getMovieByIdSQL;

    @Autowired
    private String getAllMovies;

    @Autowired
    private String addMovieSQL;

    @Override
    public Movie getById(int id) {
        log.info("Start query to get movie with id {} from DB", id);
        long startTime = System.currentTimeMillis();
        Movie movie = jdbcTemplate.queryForObject(getMovieByIdSQL, new Object[]{id}, movieRowMapper);
        log.info("Finish query to get movie with id {} from DB. It took {} ms", id, System.currentTimeMillis() - startTime);
        return movie;
    }

    @Override
    public List <Movie> getAllMovies() {
        log.info("Start query to get all movies from DB");
        long startTime = System.currentTimeMillis();
        List<Movie> moviesList = jdbcTemplate.query(getAllMovies, movieRowMapper);
        log.info("Finish query to get all movie from DB. It took {} ms", System.currentTimeMillis() - startTime);
        return moviesList;
    }

    @Override
    public void add(Movie movie) {

    }
}
