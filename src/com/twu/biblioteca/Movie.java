package com.twu.biblioteca;

/**
 * Created by derekgilwa on 6/23/14.
 */
public class Movie {
    private final String title;
    private final String director;
    private final int year;
    private final int rating;
    private boolean checkout;

    public Movie(String title, String director, int year, int rating, boolean checkout) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.checkout = checkout;
    }

    public boolean isCheckedOut() {
        return checkout;
    }

    public void checkOut(){
        checkout = true;
    }

    @Override
    public String toString(){
        String titleString = String.format("%-40s", title.substring(0, title.length()));
        String directorString = String.format("%-40s", director.substring(0, director.length()));
        return String.format("%s|  %s|  %d | %d\n", titleString, directorString, year, rating);
    }


}
