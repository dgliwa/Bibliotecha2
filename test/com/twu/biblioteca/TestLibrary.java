package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by derekgilwa on 6/20/14.
 */
public class TestLibrary {


    private PrintStream printStream;
    private BufferedReader reader;
    Map<String,Book> bookList;
    Map<String,Movie> movieList;


    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        reader = mock(BufferedReader.class);
        bookList = new HashMap<String,Book>();
        movieList = mock(Map.class);

        bookList.put("Harry Potter", new Book("Harry Potter", "JK Rowling", 1995, false));
        bookList.put("The Shining", new Book("The Shining", "Stephen King", 1970, false));
    }

    @Test
    public void shouldRemoveBookFromBookListOnCheckout() throws IOException {
        PrintStream printStream = mock(PrintStream.class);
        BufferedReader reader = mock(BufferedReader.class);
        Map<String,Book> bookList = new HashMap<String,Book>();
        Book book = new Book("Harry Potter", "JK Rowling", 1995, false);
        bookList.put("Harry Potter", book);
        Library library = new Library(printStream,reader,bookList, movieList);
        when(reader.readLine()).thenReturn("Harry Potter");
        library.checkOutBook();

        assertThat(book.isCheckedOut(), is(true));
    }

    @Test
    public void shouldRemoveMovieFromMovieListOnCheckout() throws IOException {
        PrintStream printStream = mock(PrintStream.class);
        BufferedReader reader = mock(BufferedReader.class);
        Map<String,Movie> movieList = new HashMap<String,Movie>();
        Movie movie = new Movie("Pulp Fiction", "Quentin Tarantino", 1990, 9, false);
        movieList.put("Pulp Fiction", movie);
        Library library = new Library(printStream,reader,bookList, movieList);
        when(reader.readLine()).thenReturn("Pulp Fiction");
        library.checkOutMovie();

        assertThat(movie.isCheckedOut(), is(true));
    }

    @Test
    public void shouldAddBookToBookListOnReturn() throws IOException {
        PrintStream printStream = mock(PrintStream.class);
        BufferedReader reader = mock(BufferedReader.class);
        Map<String,Book> bookList = new HashMap<String,Book>();
        Book book = new Book("Harry Potter", "JK Rowling", 1995, true);
        bookList.put("Harry Potter", book);
        Library library = new Library(printStream,reader,bookList, movieList);
        when(reader.readLine()).thenReturn("Harry Potter");
        library.returnBook();

        assertThat(book.isCheckedOut(), is(false));
    }


    @Test
    public void shouldNotDisplayCheckedOutBooks() {
        Library library = new Library(printStream, reader, bookList, movieList);
        Book book = bookList.get("Harry Potter");
        book.checkOut();
        library.displayBooks();
        verify(printStream).println("The Shining                             |  Stephen King                            |  1970\n");
    }

    @Test
    public void shouldDisplayErrorForUnavailableBooks() throws IOException {
        Library library = new Library(printStream, reader, bookList, movieList);
        when(reader.readLine()).thenReturn("asldkfjaslkdj");
        library.checkOutBook();
        verify(printStream).println("What is the title of the book?");
        verify(printStream).println("That book is not available.");
    }

    @Test
    public void shouldDisplayErrorForCheckedOutBooks() throws IOException {
        Library library = new Library(printStream, reader, bookList, movieList);
        when(reader.readLine()).thenReturn("Harry Potter");
        Book book = bookList.get("Harry Potter");
        book.checkOut();


        library.checkOutBook();
        verify(printStream).println("What is the title of the book?");
        verify(printStream).println("That book is not available.");
    }

    @Test
    public void shouldDisplayCheckedOutBookMessageOnCheckout() throws IOException {
        Library library = new Library(printStream, reader, bookList, movieList);
        when(reader.readLine()).thenReturn("Harry Potter");
        library.checkOutBook();
        verify(printStream).println("What is the title of the book?");
        verify(printStream).println("Thank you! Enjoy the book");
    }

    @Test
    public void shouldDisplayReturnedBookMessageOnReturn() throws IOException {
        Library library = new Library(printStream, reader, bookList, movieList);
        when(reader.readLine()).thenReturn("Harry Potter");
        Book book = bookList.get("Harry Potter");
        book.checkOut();

        library.returnBook();
        verify(printStream).println("What is the title of the book?");
        verify(printStream).println("Thank you for returning the book");
    }

    @Test
     public void shouldDisplayErrorForBooksThatAreUnavailableToReturn() throws IOException {
        Library library = new Library(printStream, reader, bookList, movieList);
        when(reader.readLine()).thenReturn("asldkfjaslkdj");
        library.returnBook();
        verify(printStream).println("What is the title of the book?");
        verify(printStream).println("That is not a valid book to return.");
    }

    @Test
    public void shouldDisplayErrorForBooksThatAreAlreadyReturned() throws IOException {
        Library library = new Library(printStream, reader, bookList, movieList);
        when(reader.readLine()).thenReturn("Harry Potter");
        library.returnBook();
        verify(printStream).println("What is the title of the book?");
        verify(printStream).println("That is not a valid book to return.");
    }


}
