package com.example.demo.services;

import com.example.demo.models.Movie;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MovieAnalysisService {

    public Movie getFirstMovieOfList() throws FileNotFoundException {
        //Instantiated a file from film-new.csv
        File movieList = new File("src/main/resources/static/film-new.csv");
        //Scanner
        Scanner sc = new Scanner(movieList);
        //Skip 2 lines
        sc.nextLine();
        sc.nextLine();
        //Split
        String[] firstMovieAsArray = sc.nextLine().split(";");
        //Created a model from data
        Movie firstMovie = new Movie(
                Integer.parseInt(firstMovieAsArray[0]), Integer.parseInt(firstMovieAsArray[1]), firstMovieAsArray[2]
        );
        return firstMovie;
    }

    public Movie getRandomMovie() throws FileNotFoundException {
        ArrayList<Movie> allMovies = new ArrayList<Movie>();

        File file = new File("src/main/resources/static/film-new.csv");

        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            String[] movieArr = sc.nextLine().split(";");

            Movie ranMovie = new Movie(movieArr[2]);
            allMovies.add(ranMovie);

        }
        Random rand = new Random();
        int intRandom = rand.nextInt(allMovies.size() - 1);
        return (allMovies.get(intRandom));
    }

    public ArrayList<Movie> getTenRandom() throws FileNotFoundException {
        ArrayList<Movie> allMovies = new ArrayList<>();

        File file = new File("src/main/resources/static/film-new.csv");

        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            String[] movieArr = sc.nextLine().split(";");

            Movie ranMovie = new Movie(movieArr[2], Integer.parseInt(movieArr[4]));
            allMovies.add(ranMovie);
        }

        Random rand = new Random();

        ArrayList<Movie> tenRanMovies = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int intRandom = rand.nextInt(allMovies.size() - 1);
            tenRanMovies.add(allMovies.get(intRandom));
        }
        Collections.sort(tenRanMovies);
        return tenRanMovies;
    }
}
