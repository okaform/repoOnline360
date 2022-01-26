package com.test.week04;

public class videoGame {
    private String name;
    private String console;
    private int rating;
    private  int year;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setConsole(String console) {
        this.console = console;
    }

    public String getConsole() {
        return console;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Video Game [" +
                "name= " + name + '\'' +
                " Console= " + console + '\'' +
                " Rating= " + rating + '\'' +
                " Year= " + year +
                "]";
    }
}
