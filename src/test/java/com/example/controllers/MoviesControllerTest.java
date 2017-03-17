package com.example.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MoviesControllerTest {

    @Autowired
    MockMvc mvc;

    //Take a GET request to /movies with a query parameter named q for example:
    @Test
    public void searchQueryReturnsMovieInformation() throws Exception {
        //Set up
        String query = "harry";

        MockHttpServletRequestBuilder request = get("/movies/?q=" + query);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title", equalTo("Harry Potter and the Deathly Hallows: Part 2")))
                .andExpect(jsonPath("$[0].imdbId", equalTo("tt1201607")))
                .andExpect(jsonPath("$[0].poster", equalTo("https://images-na.ssl-images-amazon.com/images/M/MV5BMTY2MTk3MDQ1N15BMl5BanBnXkFtZTcwMzI4NzA2NQ@@._V1_SX300.jpg")))
                .andExpect(jsonPath("$[0].year", equalTo(2011)));
    }

    @Test
    public void searchQueryReturnsMovieInformationWithoutCapitalFields() throws Exception {
        //Set up
        String query = "harry";

        MockHttpServletRequestBuilder request = get("/movies/?q=" + query);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].Title").doesNotExist())
                .andExpect(jsonPath("$[0].Year").doesNotExist())
                .andExpect(jsonPath("$[0].imdbID").doesNotExist())
                .andExpect(jsonPath("$[0].Poster").doesNotExist());
    }

    @Test
    public void searchQueryReturnsMovieInformationWithoutTypeField() throws Exception {
        //Set up
        String query = "harry";

        MockHttpServletRequestBuilder request = get("/movies/?q=" + query);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].Type").doesNotExist());
    }
}

