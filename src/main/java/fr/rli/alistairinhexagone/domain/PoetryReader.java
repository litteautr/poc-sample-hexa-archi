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

    }

    @Override
    public String giveMePoetry() {
        if (poetryLibrary != null) {
            return poetryLibrary.giveMePoem();
        }
        return "this is hard coded poetry";
    }
}
