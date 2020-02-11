package fr.rli.alistairinhexagone.domain;

import fr.rli.alistairinhexagone.domain.port.driver.IRequestVerses;

public class PoetryReader implements IRequestVerses {
    @Override
    public String giveMePoetry() {
        return "this is poetry\n very beautiful one";
    }
}
