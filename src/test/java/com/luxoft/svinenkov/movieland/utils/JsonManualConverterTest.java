package com.luxoft.svinenkov.movieland.utils;

import com.luxoft.svinenkov.movieland.entity.Movie;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JsonManualConverterTest {

    @Test
    public void testMovieToJson() {
        // {"id", "nameRussian", "nameRussian", "yearOfRelease", "rating", "price", "picturePath"};
        String expectedJson = "{\"id\":1,\"nameRussian\":\"Movie Name\",\"nameNative\":\"Original Movie Name\",\"yearOfRelease\":2017,\"rating\":5.0,\"price\":70.0,\"picturePath\":\"http:\\\\some_url.com\"}";
        JsonManualConverter jsonManualConverter = new JsonManualConverter();

        Movie movie = new Movie();
        movie.setId(1);
        movie.setName("Movie Name");
        movie.setOrigName("Original Movie Name");
        movie.setYear(2017);
        movie.setRating(5);
        movie.setPrice(70);
        movie.setPosterUrl("http:\\\\some_url.com");

        String actualJson = jsonManualConverter.toJson(movie);
        assertEquals(
                "testMovieToJson() failed!",
                expectedJson,
                actualJson
        );
    }
}
