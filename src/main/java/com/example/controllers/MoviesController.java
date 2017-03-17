package com.example.controllers;

import com.example.models.Movie;
import com.example.models.Search;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by localadmin on 3/17/17.
 */
@RestController
@RequestMapping("/movies")
public class MoviesController {
    private String hostName = "http://www.omdbapi.com/";

    @Autowired
    private ObjectMapper mapper;

    @GetMapping("")
    public List<Movie> searchQuery(@RequestParam("q") String query) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        List<Movie> movies = restTemplate.getForObject("http://www.omdbapi.com/?s=harry", Search.class).getMovies();
        return movies;
    }
}
