package com.twu.biblioteca;

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
        return false;
    }
}
