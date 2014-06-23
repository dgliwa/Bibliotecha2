package com.twu.biblioteca;

import java.io.IOException;

/**
 * Created by derekgilwa on 6/23/14.
 */
public class ListMoviesCommand implements Command {
    private Library library;

    public ListMoviesCommand(Library library) {
        this.library = library;
    }

    @Override
    public boolean execute() {
        try {
            library.checkOutMovie();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
