package fr.rli.alistairinhexagone.infra.adapter.driver;

import fr.rli.alistairinhexagone.domain.PoetryReader;

public class ConsoleAdapter {

    private PoetryReader poetryReader;
    private IwriteLine publicationStrategy;

    public ConsoleAdapter(PoetryReader poetryReader, IwriteLine publicationStrategy) {
        this.poetryReader = poetryReader;
        this.publicationStrategy = publicationStrategy;
    }

    public ConsoleAdapter(PoetryReader poetryReader) {
        this.poetryReader = poetryReader;
        this.publicationStrategy = new ConsolePublicationStrategy();
    }

    public void ask() {
        // From infra to domain

        // Business Logic
        String verses = poetryReader.giveMePoetry();

        // From domain to infra
        publicationStrategy.writeLine(verses);
    }
}