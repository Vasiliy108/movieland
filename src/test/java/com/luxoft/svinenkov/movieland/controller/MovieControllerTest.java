package com.luxoft.svinenkov.movieland.controller;

import com.luxoft.svinenkov.movieland.entity.Movie;
import com.luxoft.svinenkov.movieland.service.impl.MovieServiceImpl;
import com.luxoft.svinenkov.movieland.utils.JsonManualConverter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(locations = "classpath:/spring-test-config.xml")
@WebAppConfiguration
public class MovieControllerTest {
    private MockMvc mockMvc;
    @Mock
    private MovieServiceImpl mockedMovieService;
    @Mock
    private JsonManualConverter jsonManualConverter;

    @InjectMocks
    private MovieController movieController;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(movieController).build();
    }

    @Test
    public void getAllMovies() throws Exception {
        List<Movie> mockedGetAllMoviesList = new ArrayList<>();
        mockedGetAllMoviesList.add(
                new Movie
                (
                        8,
                        "Бойцовский клуб",
                        "Fight Club",
                        1999,
                        null,
                        null,
                        "some description",
                        8.4f,
                        119.99f,
                        "https://images-na.ssl-images-amazon.com/images/M/MV5BZGY5Y2RjMmItNDg5Yy00NjUwLThjMTEtNDc2OGUzNTBiYmM1XkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1._SY209_CR0,0,140,209_.jpg"
                )
        );
        mockedGetAllMoviesList.add(
                new Movie
                        (
                                2,
                                "Зеленая миля",
                                "The Green Mile",
                                1999,
                                null,
                                null,
                                "Обвиненный в страшном преступлении, Джон Коффи оказывается в блоке смертников тюрьмы «Холодная гора». Вновь прибывший обладал поразительным ростом и был пугающе спокоен, что, впрочем, никак не влияло на отношение к нему начальника блока Пола Эджкомба, привыкшего исполнять приговор.",
                                8.9f,
                                134.67f,
                                "https://images-na.ssl-images-amazon.com/images/M/MV5BMTUxMzQyNjA5MF5BMl5BanBnXkFtZTYwOTU2NTY3._V1._SY209_CR0,0,140,209_.jpg"
                        )
        );
        when(mockedMovieService.getAllMovies()).thenReturn(mockedGetAllMoviesList);
        movieController.setJsonConverter(new JsonManualConverter());
        mockMvc.perform(get("/movie"))
                //.andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$[0].id").value(8))
                .andExpect(jsonPath("$[0].nameRussian").value("Бойцовский клуб"))
                .andExpect(jsonPath("$[0].nameNative").value("Fight Club"))
                .andExpect(jsonPath("$[0].yearOfRelease").value(1999))
                .andExpect(jsonPath("$[0].rating").value(8.4))
                .andExpect(jsonPath("$[0].price").value(119.99))
                .andExpect(jsonPath("$[0].picturePath").value("https://images-na.ssl-images-amazon.com/images/M/MV5BZGY5Y2RjMmItNDg5Yy00NjUwLThjMTEtNDc2OGUzNTBiYmM1XkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1._SY209_CR0,0,140,209_.jpg"))
                //---
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].nameRussian").value("Зеленая миля"))
                .andExpect(jsonPath("$[1].nameNative").value("The Green Mile"))
                .andExpect(jsonPath("$[1].yearOfRelease").value(1999))
                .andExpect(jsonPath("$[1].rating").value(8.9))
                .andExpect(jsonPath("$[1].price").value(134.67))
                .andExpect(jsonPath("$[1].picturePath").value("https://images-na.ssl-images-amazon.com/images/M/MV5BMTUxMzQyNjA5MF5BMl5BanBnXkFtZTYwOTU2NTY3._V1._SY209_CR0,0,140,209_.jpg"))
        ;
    }
}
