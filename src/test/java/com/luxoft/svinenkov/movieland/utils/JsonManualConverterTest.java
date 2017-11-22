package com.luxoft.svinenkov.movieland.utils;

import com.luxoft.svinenkov.movieland.entity.Movie;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class JsonManualConverterTest {

    @Test
    public void toJson() throws Exception {
        // {"id", "nameRussian", "nameRussian", "yearOfRelease", "rating", "price", "picturePath"};
        String expectedJson = "{\"id\":1,\"nameRussian\":\"Movie Name\",\"nameNative\":\"Original Movie Name\",\"yearOfRelease\":2017,\"rating\":5.0,\"price\":70.0,\"picturePath\":\"http:\\\\some_url.com\"}";

        Movie movie = new Movie(
                1,
                "Movie Name",
                "Original Movie Name",
                2017,
                "Some movie description",
                5f,
                70f,
                "http:\\\\some_url.com"
        );

        String actualJson = JsonManualConverter.toJson(movie);
        assertEquals(
                "toJson() failed!",
                expectedJson,
                actualJson
        );
    }

    @Test
    public void listToJson() throws Exception {
        String expectedJson =
                "[" +
                "{\"id\":1,\"nameRussian\":\"Movie1 Name\",\"nameNative\":\"Original Movie1 Name\",\"yearOfRelease\":2017,\"rating\":5.0,\"price\":70.0,\"picturePath\":\"http:\\\\some_url.com\"},\n" +
                "{\"id\":2,\"nameRussian\":\"Movie2 Name\",\"nameNative\":\"Original Movie2 Name\",\"yearOfRelease\":2018,\"rating\":6.0,\"price\":99.0,\"picturePath\":\"http:\\\\another_url.com\"}" +
                "]"
                ;
        List <Movie> movieList = new ArrayList <>();
        movieList.add(new Movie(
                1,
                "Movie1 Name",
                "Original Movie1 Name",
                2017,
                "1st movie description",
                5f,
                70f,
                "http:\\\\some_url.com"
        ));
        movieList.add(new Movie(
                2,
                "Movie2 Name",
                "Original Movie2 Name",
                2018,
                "2nd movie description",
                6f,
                99f,
                "http:\\\\another_url.com"
        ));

        String actualJson = JsonManualConverter.listToJson(movieList);
        assertEquals(
                "listToJson() failed!",
                expectedJson,
                actualJson
        );
    }

}