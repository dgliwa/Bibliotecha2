package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {

        Map<String,Book> bookList = new HashMap<String,Book>();
        bookList.put("Harry Potter", new Book("Harry Potter", "JK Rowling", 1995, false));
        bookList.put("The Shining", new Book("The Shining", "Stephen King", 1970, false));
        Map<String,Movie> movieList = new HashMap<String, Movie>();
        movieList.put("Pulp Fiction", new Movie("Pulp Fiction", "Quentin Tarantino", 1994, 9, false));
        movieList.put("The Shining", new Movie("The Shining", "Stanley Kubrick", 1980, 8, false));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Library library = new Library(System.out, reader, bookList, movieList);

        HashMap<String,Command> commands = new HashMap<String, Command>();
        commands.put("list books", new ListBooksCommand(library));
        commands.put("list movies", new ListMoviesCommand(library));
        commands.put("quit", new QuitCommand(System.out));
        commands.put("checkout books", new CheckoutBookCommand(library));
        commands.put("checkout movies", new CheckoutMovieCommand(library));
        commands.put("return", new ReturnBookCommand(library));

        CommandMenu menu = new CommandMenu(System.out, new BufferedReader(new InputStreamReader(System.in)),
                commands);

        BibliotechaApp bibliotechaApp = new BibliotechaApp(menu);
        bibliotechaApp.start();

  }

}
