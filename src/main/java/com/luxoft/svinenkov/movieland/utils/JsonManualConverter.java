package com.luxoft.svinenkov.movieland.utils;

import com.luxoft.svinenkov.movieland.entity.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class JsonManualConverter {
    private final Logger log = LoggerFactory.getLogger(getClass());
    private static final String COMMA_SEPARATOR = ",";
    private static final String COLON_SEPARATOR = ":";

    public String toJson(Movie movie) {
        log.info("Start converting movie {} to json", movie);
        StringBuilder json = new StringBuilder("{");
        String[] movieFieldNames = {"id", "name", "origName", "year", "description", "rating", "price"};
        Object[] movieFields = { movie.getId(), movie.getName(), movie.getOrigName(), movie.getYear(), movie.getDescription(), movie.getRating(), movie.getPrice() };
        for (int i = 0; i < movieFieldNames.length; i++) {
            json.append(surroundByQuotes(movieFieldNames[i]));
            json.append(COLON_SEPARATOR);
            json.append(surroundByQuotes(movieFields[i]));
            if (i != movieFieldNames.length - 1) {
                json.append(COMMA_SEPARATOR);
            }
        }
        json.append("}");
        log.info("Receiving movie as json {}", json);
        return json.toString();
    }

    private String surroundByQuotes(Object value) {
        return "\"" + value + "\"";
    }
}