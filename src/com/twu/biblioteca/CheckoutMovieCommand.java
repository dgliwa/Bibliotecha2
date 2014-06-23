package com.twu.biblioteca;

import java.io.IOException;

/**
 * Created by thomasmorris on 6/23/14.
 */
public class CheckoutMovieCommand implements Command {

    private Library library;

    public CheckoutMovieCommand(Library library) {
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
