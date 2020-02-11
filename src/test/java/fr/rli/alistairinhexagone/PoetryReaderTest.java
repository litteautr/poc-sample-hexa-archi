package fr.rli.alistairinhexagone;

import fr.rli.alistairinhexagone.domain.PoetryReader;
import fr.rli.alistairinhexagone.domain.port.driver.IRequestVerses;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PoetryReaderTest {

    @Test
    public void should_giver_verses_when_asked_for_poetry() {
        IRequestVerses poetryReader = new PoetryReader();
        String verses = poetryReader.giveMePoetry();

        Assertions.assertEquals("this is poetry\n very beautiful one", verses);
    }
}