package com.example.demo.controllers;

import com.example.demo.models.Movie;
import com.example.demo.services.MovieAnalysisService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;


@Controller
public class MovieController {
    MovieAnalysisService movieService = new MovieAnalysisService();

    private final String goBack = "<br><a href=http://localhost:8080>Go to front page</a>";

    @ResponseBody
    @GetMapping("/")
    public String hello() {
        return "<title>MovieAnalyzer</title>\n" +
                "<h1>Welcome to MovieAnalyzer</h1>\n" +
                "<br>\n" +
                "<p>Movie Analyzer has the following endpoints available:</p>\n" +
                "<br>" +
                "<p>1. </p><a href=http://localhost:8080/getFirst> Finds the first movie from the list</a><br>" +
                "<p>2. </p><a href=http://localhost:8080/getRandom> Finds a single random movie from the list, and displays the title</a><br>" +
                "<p>3. </p><a href=http://localhost:8080/getTenRandom> Gets 10 random movies from a data-set, sorted in ascending order by popularity</a><br>" +
                "<p>4. </p><a href=http://localhost:8080/howManyWonAnAward> Prints how many of the movies from the data-set, that won an award.</a>";

    }

    @ResponseBody
    @GetMapping("/getFirst")
    public String getFirst() {
        Movie firstMovieOfList = movieService.getFirstMovieOfList();
        return firstMovieOfList.getInfo() + goBack;
    }

    @ResponseBody
    @GetMapping("/getRandom")
    public String getRandom() {
        Movie randomMovie = movieService.getRandomMovie();
        return randomMovie.getInfo() + goBack;
    }
    @ResponseBody
    @GetMapping("/getTenRandom")
    public String getTenRandom() {
        return movieService.getTenSortByPopularity() + goBack;
    }

    @ResponseBody
    @GetMapping("/howManyWonAnAward")
    public String howManyWonAnAward() {
        return movieService.howManyWonAnAward() + goBack;
    }


}
