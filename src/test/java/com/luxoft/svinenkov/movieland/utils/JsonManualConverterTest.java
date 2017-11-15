package com.luxoft.svinenkov.movieland.utils;

import com.luxoft.svinenkov.movieland.entity.Movie;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JsonManualConverterTest {

    @Test
    public void testCityToJson() {
        // {"id", "name", "origName", "year", "description", "rating", "price"};
        String expectedJson = "{\"id\":\"1\",\"name\":\"Movie Name\",\"origName\":\"Original Movie Name\",\"year\":\"2017\",\"description\":\"Movie Description\",\"rating\":\"5.0\",\"price\":\"70.0\"}";
        JsonManualConverter jsonManualConverter = new JsonManualConverter();

        Movie movie = new Movie();
        movie.setId(1);
        movie.setName("Movie Name");
        movie.setOrigName("Original Movie Name");
        movie.setYear(2017);
        movie.setDescription("Movie Description");
        movie.setRating(5);
        movie.setPrice(70);

        String actualJson = jsonManualConverter.toJson(movie);
        assertEquals(expectedJson, actualJson);
    }
}
