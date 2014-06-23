package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Map;

/**
 * Created by richiethomas on 6/17/14.
 */
public class Library {
    Map<String,Book> bookList;

    private PrintStream printStream;
    private BufferedReader reader;
    private Map<String, Movie> movieList;

    public Library(PrintStream printStream, BufferedReader reader, Map<String, Book> bookList, Map<String, Movie> movieList) {
        this.bookList = bookList;
        this.printStream = printStream;
        this.reader = reader;
        this.movieList = movieList;
    }

  public String booksToString(){
    String temp = "";
    for(Book book : bookList.values()){
        if(book.isCheckedOut()) continue;
        temp += outputOneLine(book.getTitle()) + "|  ";
        temp += outputOneLine(book.getAuthor()) + "|  ";
        temp += Integer.toString(book.getYear()) + "\n";
    }
    return temp;
  }


    public String moviesToString(){
        String temp = "";
        for(Movie movie : movieList.values()){
            temp += outputOneLine(movie.getTitle()) + "|  ";
            temp += outputOneLine(movie.getDirector()) + "|  ";
            temp += Integer.toString(movie.getYear()) + " | ";
            temp += Integer.toString(movie.getRating()) + "\n";
        }
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

    public void displayBooks() {
        printStream.println(this.booksToString());
    }

    public void checkOutBook() throws IOException {
        Book book = findBook();
        if (book != null && !book.isCheckedOut()) {
            book.checkOut();
            printStream.println("Thank you! Enjoy the book");
        } else{
            printStream.println("That book is not available.");
        }

    }

    public void returnBook() throws IOException {
        Book book = findBook();
        if (book != null && book.isCheckedOut()) {
            book.returnBook();
            printStream.println("Thank you for returning the book");
        }
        else{
            printStream.println("That is not a valid book to return.");
        }
    }

    private Book findBook() throws IOException {
        printStream.println("What is the title of the book?");
        String bookString = reader.readLine();

        if(bookList.containsKey(bookString))
            return bookList.get(bookString);
        else
            return null;
    }

    public void displayMovies() {
        printStream.println(this.moviesToString());
    }

    public void checkOutMovie() throws IOException {
        Movie movie = findMovie();
        if (movie != null && !movie.isCheckedOut()) {
            movie.checkOut();
            printStream.println("Thank you! Enjoy the movie");
        } else{
            printStream.println("That movie is not available.");
        }
    }

    private Movie findMovie() throws IOException {
        printStream.println("What is the title of the movie?");
        String movieString = reader.readLine();

        if(movieList.containsKey(movieString))
            return movieList.get(movieString);
        else
            return null;
    }
}
