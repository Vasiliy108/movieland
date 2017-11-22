package com.luxoft.svinenkov.movieland.dao.jbbc.mapper;

import com.luxoft.svinenkov.movieland.entity.Movie;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieRowMapper implements RowMapper<Movie> {

    @Override
    public Movie mapRow(ResultSet resultSet, int i) throws SQLException {
        Movie movie = new Movie();
        movie.setId(resultSet.getInt("id"));
        movie.setName(resultSet.getString("movie_name"));
        movie.setOrigName(resultSet.getString("movie_orig_name"));
        movie.setDescription(resultSet.getString("description"));
        movie.setYear(resultSet.getInt("year"));
        movie.setRating(resultSet.getFloat("rating"));
        movie.setPrice(resultSet.getFloat("price"));
        movie.setPosterUrl(resultSet.getString("poster_url"));
        return movie;
    }
}
