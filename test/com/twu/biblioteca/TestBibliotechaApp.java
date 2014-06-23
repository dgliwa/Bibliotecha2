package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by derekgilwa on 6/18/14.
 */
public class TestBibliotechaApp {

    private CommandMenu commandMenu;
    private BibliotechaApp bibliotechaApp;

    @Before
    public void setUp() throws IOException {
        commandMenu = mock(CommandMenu.class);
        bibliotechaApp = new BibliotechaApp(commandMenu);

    }
    @Test
    public void testLibraryStartCallsWelcomeAndMenu() throws IOException {
        when(commandMenu.promptUser()).thenReturn("list");
        when(commandMenu.executeCommand("list")).thenReturn(true);
        bibliotechaApp.start();

        verify(commandMenu).displayWelcome();
        verify(commandMenu).listOptions();
        verify(commandMenu).promptUser();
        verify(commandMenu).executeCommand("list");
    }

    @Test
    public void shouldPromptUserforLogIn() {
        verify(commandMenu).userLoginIn();

    }
}
