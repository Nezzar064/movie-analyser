package com.example.demo.models;

public class Movie {
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

    public String getTitle(){
        return this.title;
    }
}
