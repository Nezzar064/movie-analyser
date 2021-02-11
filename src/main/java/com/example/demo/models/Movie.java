package com.example.demo.models;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Movie implements Comparable<Movie> {
    private String year;
    private String length;
    private String title;
    private String subject;
    private int popularity;
    private String awards;

    public Movie(String year, String length, String title, String subject, int popularity, String awards) {
        this.year = year;
        this.length = length;
        this.title = title;
        this.subject = subject;
        this.popularity = popularity;
        this.awards = awards;
    }

    public Movie() {
    }

    public String getTitle(){
        return this.title;
    }

    public String hasAwards() {
        return awards;
    }

    public String getInfo(){
        return "Score: " + this.popularity + " / Title: " + this.title + " / Awards: " + this.awards;
    }

    public int getPopularity() { return this.popularity;}

    @Override
    public int compareTo(Movie compareMovie) {
        return Integer.compare(this.popularity, compareMovie.popularity);
    }
}
