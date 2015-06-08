package com.thoughtworks.library;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

public class LibraryTest {
    List<String> books;
    PrintStream printStream;
    Library library ;
    DateTimeFormatter dateTimeFormatter;

    @Before
    public void setUp(){
        books = new ArrayList<>();
        printStream = mock(PrintStream.class);
        dateTimeFormatter = mock(DateTimeFormatter.class);
        library = new Library(books, printStream, dateTimeFormatter);
    }

    /*

        List books tests. Implement the first three tests for the Verify exercise

     */
    @Test
    public void shouldPrintBookTitleWhenThereIsOneBook() {

        String title = "Book Title";
        books.add(title);

        library.listBooks();

        verify(printStream).println(title);
    }

    @Test
    public void shouldPrintNothingWhenThereAreNoBooks() {
        library.listBooks();
        verifyZeroInteractions(printStream);
    }

    @Test
    public void shouldPrintBothBookTitlesWhenThereAreTwoBooks() {
        String title = "Book Title 1";
        String title2 = "Harry Potter 2";
        books.add(title);
        books.add(title2);

        library.listBooks();

        verify(printStream).println(title);
        verify(printStream).println(title2);
    }

    /*

        Welcome message tests. Implement these tests for the when/thenReturn exercise

     */

    
    // This one is done for you
    @Test
    public void shouldWelcomeUser() {
        // We don't need to mock DateTime because it is a value object
        // We can't mock it because it is a final class
        DateTime time = new DateTime();

        library.welcome(time);
        
        verify(printStream).println(contains("Welcome"));
    }
    
    @Test
    public void shouldDisplayFormattedTime() {
        DateTime time = new DateTime();

        when(dateTimeFormatter.print(time)).thenReturn("2013-04-08 16:33:17");

        library.welcome(time);

        verify(printStream).println("Welcome to the library! The current time is 2013-04-08 16:33:17"); // Was I supposed to hardcode the welcome() portion
    }

    @Test
    /*
    Assuming this test is to display welcome when nothing is passed into the welcome method
     */
    public void shouldDisplayFormattedTimeWhenItIsAnEmptyString() {
        DateTime time = null;

        when(dateTimeFormatter.print(time)).thenReturn("2013-04-08 16:33:17");

        library.welcome(time);

        verify(printStream).println(contains("2013-04-08 16:33:17")); // Was I supposed to hardcode the welcome() portion

    }
}