package com.twu.biblioteca;

/**
 * Created by richiethomas on 6/17/14.
 */
public class Book {

    private String title;
    private String author;
    private int year;
    private boolean checkedOut;

    public Book(String title, String author, int year, boolean checkedOut) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.checkedOut = checkedOut;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void checkOut() {
        checkedOut = true;
    }

    public void returnBook() {
        checkedOut = false;
    }

    @Override
    public String toString(){
        String titleString = String.format("%-40s", title.substring(0, title.length()));
        String authorString = String.format("%-40s", author.substring(0, author.length()));
        return String.format("%s|  %s|  %d\n", titleString, authorString, year);
    }

}
