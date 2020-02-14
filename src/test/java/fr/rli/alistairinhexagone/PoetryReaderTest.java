package fr.rli.alistairinhexagone;

import fr.rli.alistairinhexagone.domain.PoetryReader;
import fr.rli.alistairinhexagone.domain.port.driven.IObtainPoem;
import fr.rli.alistairinhexagone.infra.adapter.driven.PoetryFileAdapter;
import fr.rli.alistairinhexagone.infra.adapter.driver.IwriteLine;
import fr.rli.alistairinhexagone.domain.port.driver.IRequestVerses;
import fr.rli.alistairinhexagone.infra.adapter.driver.ConsoleAdapter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class PoetryReaderTest {

    /**
     * First left Side Adapter
     */
    @Test
    public void should_give_verses_when_asked_for_poetry() {
        IRequestVerses poetryReader = new PoetryReader();
        String verses = poetryReader.giveMePoetry();

        Assertions.assertEquals("this is hard coded poetry", verses);
    }


    /**
     * First Right Side Adapter
     */
    @Test
    public void should_give_verses_from_a_repository_when_asked_for_poetry() {
        IObtainPoem poetryLibrary = mock(IObtainPoem.class);
        when(poetryLibrary.giveMePoem()).thenReturn("this is poetry from the stub library");

        PoetryReader poetryReader = new PoetryReader(poetryLibrary);
        String verses = poetryReader.giveMePoetry();

        Assertions.assertEquals("this is poetry from the stub library", verses);
    }

    /**
     * Left Side Console Adapter
     */
    @Test
    public void should_give_verses_from_when_asked_for_poetry_with_a_console() {
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
     * Right side file adapter
     */
    @Test
    public void should_give_verses_from_when_asked_for_poetry_from_a_file() {
        //1. Instantiate the "I need to go out" Adapters
        PoetryFileAdapter fileAdapter = new PoetryFileAdapter("poem.txt");

        //2. Instantiate the Hexagon
        PoetryReader poetryReader = new PoetryReader(fileAdapter);
        String verses = poetryReader.giveMePoetry();

        Assertions.assertEquals("this is a poem from the file", verses);
    }
}