package fr.rli.alistairinhexagone.domain;

import fr.rli.alistairinhexagone.domain.port.driven.IObtainPoem;
import fr.rli.alistairinhexagone.domain.port.driver.IRequestVerses;

/**
 * HEXAGONE
 */
public class PoetryReader implements IRequestVerses {

    private IObtainPoem poetryLibrary;

    public PoetryReader(IObtainPoem poetryLibrary) {
        this.poetryLibrary = poetryLibrary;
    }

    public PoetryReader() {
        poetryLibrary = new HardcodedPoetryLibrary();
    }

    @Override
    public String giveMePoetry() {
        return poetryLibrary.giveMePoem();
    }
}
