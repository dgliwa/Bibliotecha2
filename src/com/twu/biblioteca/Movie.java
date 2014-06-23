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

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public int getYear() {
        return year;
    }

    public int getRating() {
        return rating;
    }

    public boolean isCheckedOut() {
        return checkout;
    }

    public void checkOut(){
        checkout = true;
    }

    public String moviesToString(){
        String temp = "";

            temp += outputOneLine(getTitle()) + "|  ";
            temp += outputOneLine(getDirector()) + "|  ";
            temp += Integer.toString(getYear()) + " | ";
            temp += Integer.toString(getRating()) + "\n";

        return temp;
    }

    private String outputOneLine(String str) {

        int lengthOfString;
        if(str.length() >= 40) {
            lengthOfString = 40;
        } else {
            lengthOfString = str.length();
        }
        return String.format("%-40s", str.substring(0, lengthOfString));
    }


}
