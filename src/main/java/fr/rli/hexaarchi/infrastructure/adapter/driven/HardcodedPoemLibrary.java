package fr.rli.hexaarchi.infrastructure.adapter.driven;

import fr.rli.hexaarchi.boundary.port.driven.IObtainPoems;

public class HardcodedPoemLibrary implements IObtainPoems {
    public String[] getMePoems(String language) {
        if ("de".equals(language)) {
            return new String[]{"poem_de_1","poem_de_2"};
        } else {
            return new String[]{ "poem_1","poem_2"};
        }
    }
}