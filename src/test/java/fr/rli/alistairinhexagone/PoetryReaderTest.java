package fr.rli.alistairinhexagone;

import fr.rli.alistairinhexagone.domain.PoetryReader;
import fr.rli.alistairinhexagone.domain.port.driven.IObtainPoem;
import fr.rli.alistairinhexagone.domain.port.driver.IRequestVerses;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PoetryReaderTest {

    @Test
    /**
     * First Adapter
     */
    public void should_give_verses_when_asked_for_poetry() {
        IRequestVerses poetryReader = new PoetryReader();
        String verses = poetryReader.giveMePoetry();

        Assertions.assertEquals("this is hard coded poetry", verses);
    }

    @Test
    public void should_give_verses_from_a_repository_when_asked_for_poetry() {
        IObtainPoem poetryLibrary = mock(IObtainPoem.class);
        when(poetryLibrary.giveMePoem()).thenReturn("this is poetry from the stub library");

        PoetryReader poetryReader = new PoetryReader(poetryLibrary);
        String verses = poetryReader.giveMePoetry();

        Assertions.assertEquals("this is poetry from the stub library", verses);
    }
}