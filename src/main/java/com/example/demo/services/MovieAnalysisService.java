package com.example.demo.services;

import com.example.demo.models.Movie;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MovieAnalysisService {

    List<Movie> movieList;

    public MovieAnalysisService() {

        File movieFile = new File("src/main/resources/static/film-new.csv");

        try {
            Scanner scanOfMovieFile = new Scanner(movieFile);
            movieList = fullMovieList(scanOfMovieFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private List<Movie> fullMovieList(Scanner fileSc) {
        List<Movie> movieList = new ArrayList<>();
        fileSc.nextLine();
        fileSc.nextLine();

        while (fileSc.hasNextLine()) {

            // Split
            String[] firstMovieAsArray = fileSc.nextLine().split(";");

            Movie temp = new Movie(
                    firstMovieAsArray[0],
                    firstMovieAsArray[1],
                    firstMovieAsArray[2],
                    firstMovieAsArray[3],
                    Integer.parseInt(firstMovieAsArray[4]),
                    firstMovieAsArray[5]    // awards

            //0 = year, 1 = length, 2 = title, 3 = subject, 4 = popularity, 5 = awards
            );
            movieList.add(temp);
        }
        return movieList;
    }


    public Movie getFirstMovieOfList() {
        return movieList.get(0);
    }


    public Movie getRandomMovie() {
        int movieListSize = movieList.size();
        Random rand = new Random();
        int randomMovie = rand.nextInt(movieListSize);
        return movieList.get(randomMovie);
    }

    public String getTenSortByPopularity() {
        List<Movie> tenRandomMovies = new ArrayList<>();

        boolean dupli;

        for (int i = 0; i < 10; i++) {
            do {
                dupli = false;
                if (!(tenRandomMovies.contains(getRandomMovie()))) {
                    tenRandomMovies.add(getRandomMovie());
                }
                else dupli = true;
            } while (dupli);
        }
        Collections.sort(tenRandomMovies);

        StringBuilder movieListForPrint = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            movieListForPrint.append(tenRandomMovies.get(i).getInfo()).append("<br>");
        }
        return movieListForPrint.toString();
    }

    public int howManyWonAnAward(){

        int awardCount = 0;

        for (Movie movie : movieList) {
            if (movie.hasAwards().equalsIgnoreCase("yes")) {
                awardCount++;
            }
        }
        return awardCount;
    }
}
