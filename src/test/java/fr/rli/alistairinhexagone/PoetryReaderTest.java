package fr.rli.alistairinhexagone;

import fr.rli.alistairinhexagone.domain.PoetryReader;
import fr.rli.alistairinhexagone.domain.port.driven.IObtainPoem;
import fr.rli.alistairinhexagone.infra.adapter.driven.PoetryDatabaseAdapter;
import fr.rli.alistairinhexagone.infra.adapter.driven.PoetryFileAdapter;
import fr.rli.alistairinhexagone.infra.adapter.driver.ConsolePublicationStrategy;
import fr.rli.alistairinhexagone.infra.adapter.driver.IwriteLine;
import fr.rli.alistairinhexagone.domain.port.driver.IRequestVerses;
import fr.rli.alistairinhexagone.infra.adapter.driver.ConsoleAdapter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class PoetryReaderTest {

    /**
     * 1. First left Side Adapter
     */
    @Test
    public void should_give_verses_when_asked_for_poetry() {
        IRequestVerses poetryReader = new PoetryReader();
        String verses = poetryReader.giveMePoetry();

        assertEquals("this is hard coded poetry", verses);
    }


    /**
     * 2. First Right Side Adapter
     */
    @Test
    public void should_give_verses_from_a_repository_when_asked_for_poetry() {
        IObtainPoem poetryLibrary = mock(IObtainPoem.class);
        when(poetryLibrary.giveMePoem()).thenReturn("this is poetry from the stub library");

        PoetryReader poetryReader = new PoetryReader(poetryLibrary);
        String verses = poetryReader.giveMePoetry();

        assertEquals("this is poetry from the stub library", verses);
    }

    /**
     * 3. Left Side  Adapter : a Console
     */
    @Test
    public void should_give_verses_from_a_repository_when_asked_for_poetry_with_a_console() {
        //1. Instantiate the "I need to go out" Adapters
        IObtainPoem poetryLibrary = mock(IObtainPoem.class);
        when(poetryLibrary.giveMePoem()).thenReturn("this is poetry from the stub library");

        //2. Instantiate the Hexagon
        PoetryReader poetryReader = new PoetryReader(poetryLibrary);

        //3. Instantiate "I want to go inside the hexagone" Adapters
        IwriteLine publicationStrategy = mock(IwriteLine.class);
        ConsoleAdapter consoleAdapter = new ConsoleAdapter(poetryReader, publicationStrategy);
        consoleAdapter.ask();

        //Check call of console.writeLine
        verify(publicationStrategy).writeLine("this is poetry from the stub library");
    }

    /**
     * 4. Right side adapter : a file
     */
    @Test
    public void should_give_verses_from_a_file_when_asked_for_poetry() {
        //1. Instantiate the "I need to go out" Adapters
        PoetryFileAdapter fileAdapter = new PoetryFileAdapter("poem.txt");

        //2. Instantiate the Hexagon
        PoetryReader poetryReader = new PoetryReader(fileAdapter);
        String verses = poetryReader.giveMePoetry();

        assertEquals("this is a poem from the file", verses);
    }

    /**
     * Double loop test US
     */
    @Test
    public void us_1_should_give_verses_from_a_file_when_asked_for_poetry_with_a_console() {
        // I want to go out
        IObtainPoem poemGetter = new PoetryFileAdapter("poem.txt");

        // Hexagon
        PoetryReader hexagone = new PoetryReader(poemGetter);
        String poem = hexagone.giveMePoetry();
        assertEquals("this is a poem from the file", poem);

        // I want to go in
        IwriteLine strategy = mock(ConsolePublicationStrategy.class);
        ConsoleAdapter console = new ConsoleAdapter(hexagone, strategy);
        console.ask();

        verify(strategy).writeLine("this is a poem from the file");
    }

    /**
     * 5. Right side adapter : a database
     */
    @Test
    public void should_give_verses_from_a_database_when_asked_for_poetry() {
        IObtainPoem dbAdapter = mock(PoetryDatabaseAdapter.class);
        when(dbAdapter.giveMePoem()).thenReturn("this is a poem from the database");

        PoetryReader reader = new PoetryReader(dbAdapter);
        String poem = reader.giveMePoetry();

        assertEquals("this is a poem from the database", poem);
    }
}