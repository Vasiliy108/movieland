package com.luxoft.svinenkov.movieland.utils;

import com.luxoft.svinenkov.movieland.entity.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class JsonManualConverter {
    private final Logger log = LoggerFactory.getLogger(getClass());
    private static final String COMMA_SEPARATOR = ",";
    private static final String COLON_SEPARATOR = ":";
    private static final String JSONS_DELIMITER = ",\n";
    private static final String JAVA_NUMBER_OBJECTS_TYPE_NAMES = "[java.lang.Byte], [java.lang.Short], [java.lang.Character], [java.lang.Integer], [java.lang.Long], [java.lang.Float], [java.lang.Double]";

    public String toJson(Movie movie) {
        log.info("Start converting movie {} to json", movie);
        StringBuilder json = new StringBuilder("{");
        String[] movieFieldNames = {"id", "nameRussian", "nameNative", "yearOfRelease", "rating", "price", "picturePath"};
        Object[] movieFields = { movie.getId(), movie.getName(), movie.getOrigName(), movie.getYear(), movie.getRating(), movie.getPrice(), movie.getPosterURL() };
        for (int i = 0; i < movieFieldNames.length; i++) {
            // Filed name --> ALWAYS should be inside quotes:
            json.append( surroundByQuotes(movieFieldNames[i]) );
            json.append(COLON_SEPARATOR);
            // Value --> only NON-NUMERIC values should be inside quotes:
            json.append( smartSurroundByQuotes(movieFields[i]) );
            if (i != movieFieldNames.length - 1) {
                json.append(COMMA_SEPARATOR);
            }
        }
        json.append("}");
        log.info("Receiving movie as json {}", json);
        return json.toString();
    }

    public String listToJson(List<Movie> moviesList) {
        log.info( "Start converting movie list with {} elements to json", moviesList.size() );
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        Iterator<Movie> moviesIterator = moviesList.iterator();
        while( moviesIterator.hasNext() ) {
            sb.append( toJson( moviesIterator.next() ) );
            if( moviesIterator.hasNext() ) {
                sb.append( JSONS_DELIMITER );
            }
        }

        sb.append("]");
        log.info( "Receiving movies list with {} elements as json", moviesList.size() );
        return sb.toString();
    }

    private String surroundByQuotes(Object value) {
        return "\"" + value + "\"";
    }
    private String smartSurroundByQuotes(Object value) {
        if( JAVA_NUMBER_OBJECTS_TYPE_NAMES.indexOf( "["+value.getClass().getTypeName()+"]" ) >= 0 ) {
            return value.toString();
        } else {
            return surroundByQuotes( value );
        }
    }
}