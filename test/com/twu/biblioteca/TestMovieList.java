package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by derekgilwa on 6/23/14.
 */
public class TestMovieList {

    Map<String, Movie> movieList;

    @Before
    public void setUp(){
        movieList = new HashMap<String,Movie>();
        movieList.put("Pulp Fiction", new Movie("Pulp Fiction", "Quentin Tarantino", 1994, 9, false));
        movieList.put("The Shining", new Movie("The Shining", "Stanley Kubrick", 1980, 8, false));
    }

    @Test
    public void testListMovies(){
        BufferedReader reader = mock(BufferedReader.class);
        PrintStream printStream = mock(PrintStream.class);
        Map<String, Book> bookList = mock(Map.class);
        Library library = new Library(printStream,reader,bookList, movieList);

        library.displayMovies();
        verify(printStream).println("The Shining                             |  Stanley Kubrick                         |  1980 | 8\n");
        verify(printStream).println("Pulp Fiction                            |  Quentin Tarantino                       |  1994 | 9\n");
    }
}
