package com.example.demo.models;

public class Movie implements Comparable<Movie> {
    private int popularity;
    private int year;
    private int length;
    private String title;

    public Movie(int year, int length, String title){
        this.year = year;
        this.length = length;
        this.title = title;
    }

    public Movie(String title) {
        this.title = title;
    }

    public Movie(String title, int popularity) {
        this.title = title;
        this.popularity = popularity;
    }

    public String getTitle(){
        return this.title;
    }
    public int getPopularity() { return this.popularity;}

    @Override
    public int compareTo(Movie compareMovie) {
        int comparePop = ((Movie)compareMovie).popularity;
        /* For Ascending order*/
        return this.popularity - comparePop;

        /* For Descending order do like this */
        //return compareage-this.studentage;
    }
}
