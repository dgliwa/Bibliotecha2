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

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
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

    public String booksToString(){
        String temp = "";

            temp += outputOneLine(getTitle()) + "|  ";
            temp += outputOneLine(getAuthor()) + "|  ";
            temp += Integer.toString(getYear()) + "\n";

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
