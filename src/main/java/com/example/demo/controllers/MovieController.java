package com.example.demo.controllers;

import com.example.demo.models.Movie;
import com.example.demo.services.MovieAnalysisService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

//This is a bean - it is handled by the Spring framework
@Controller
public class MovieController {
    MovieAnalysisService movieService = new MovieAnalysisService();

    @ResponseBody
    @GetMapping("/")
    public String hello() {
        return "<title>MovieAnalyzer</title>\n" +
                "<h1>Welcome to MovieAnalyzer</h1>\n" +
                "<br>\n" +
                "<p>Movie Analyzer has the following endpoints available:</p>\n" +
                "<br>" +
                "<p>localhost:8080/getFirst : Finds the first movie from the list</p>\n" +
                "<p>localhost:8080/getRandom : Finds a single random movie from the list, and displays the title</p>\n" +
                "<p>localhost:8080/getTenSortByPopularity : Gets 10 random movies from a data-set, sorted in ascending order by popularity</p>\n" +
                "<p>localhost:8080/howManyWonAnAward : Prints how many of the movies from the data-set, that won an award.</p>\n";
    }

    @ResponseBody
    @GetMapping("/getFirst")
    public String getFirst() throws FileNotFoundException {
        Movie firstMovieOfList = movieService.getFirstMovieOfList();
        return firstMovieOfList.getTitle();
    }

    @ResponseBody
    @GetMapping("/getRandom")
    public String getRandom() throws FileNotFoundException {
        Movie randomMovie = movieService.getRandomMovie();
        return randomMovie.getTitle();
    }
    @ResponseBody
    @GetMapping("/getTenRandom")
    public String getTenRandom() throws FileNotFoundException {
        ArrayList<Movie> tenRandomMovie = movieService.getTenRandom();

    }

    /*
    @ResponseBody
    @GetMapping("/getTenSortByPopularity")
    public String getTenSortByPopularity() {

    }

    @ResponseBody
    @GetMapping("/howManyWonAnAward")
    public String howManyWonAnAward() {

    }

     */
}
