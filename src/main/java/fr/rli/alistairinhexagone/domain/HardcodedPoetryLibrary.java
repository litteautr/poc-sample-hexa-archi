package fr.rli.alistairinhexagone.domain;

import fr.rli.alistairinhexagone.domain.port.driven.IObtainPoem;

public class HardcodedPoetryLibrary implements IObtainPoem {

    @Override
    public String giveMePoem() {
        return "this is hard coded poetry";
    }
}
