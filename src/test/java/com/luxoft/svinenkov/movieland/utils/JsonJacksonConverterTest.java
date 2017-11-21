package com.luxoft.svinenkov.movieland.utils;

import com.luxoft.svinenkov.movieland.entity.Movie;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JsonJacksonConverterTest {
    @Test
    public void testParseAddCityRequest() {
        String json = "{\"name\":\"Movie Name\",\"origName\":\"Original Movie Name\",\"year\":2017,\"description\":\"Movie Description\",\"rating\":5.0,\"price\":70.0}";
        JsonJacksonConverter converter = new JsonJacksonConverter();
        Movie movie = converter.parseMovie(json);

        // "id", "name", "origName", "year", "description", "rating", "price"
        assertEquals( "Movie Name", movie.getName() );
        assertEquals( "Original Movie Name", movie.getOrigName() );
        assertEquals( "2017", String.valueOf(movie.getYear()) );
        assertEquals( "Movie Description", movie.getDescription() );
        assertEquals( "5.0", String.valueOf(movie.getRating()) );
        assertEquals( "70.0", String.valueOf(movie.getPrice()) );
    }
}
