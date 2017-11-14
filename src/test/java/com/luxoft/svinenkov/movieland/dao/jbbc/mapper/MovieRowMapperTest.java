package com.luxoft.svinenkov.movieland.dao.jbbc.mapper;

import com.luxoft.svinenkov.movieland.entity.Movie;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class MovieRowMapperTest {

    @Test
    public void testMapRowWithProperCity() throws SQLException {
        ResultSet resultSet = mock(ResultSet.class);

        when(resultSet.getInt(any())).thenReturn(1).thenReturn(2017);
        when(resultSet.getString(any())).thenReturn("Test name").thenReturn("Test description");

        MovieRowMapper movieMapper = new MovieRowMapper();
        Movie actualCity = movieMapper.mapRow(resultSet, 0);
        assertEquals(actualCity.getId(), 1);
        assertEquals(actualCity.getName(), "Test name");
        assertEquals(actualCity.getDescription(), "Test description");
        assertEquals(actualCity.getYear(), 2017);
    }
}
