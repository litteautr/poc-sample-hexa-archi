package fr.rli.alistairinhexagone;

import fr.rli.alistairinhexagone.domain.PoetryReader;
import fr.rli.alistairinhexagone.infra.adapter.driven.PoetryFileAdapter;
import fr.rli.alistairinhexagone.infra.adapter.driver.ConsoleAdapter;

public class Main {

    public static void main(String[] args) {
        //1. Instantiate the "I need to go out" adapters
        PoetryFileAdapter fileAdapter = new PoetryFileAdapter("poem.txt");

        //2. Instantiate the Hexagon
        PoetryReader poetryReader = new PoetryReader(fileAdapter);

        //3. Instantiate "I want to go inside the hexagone" adapters
        ConsoleAdapter consoleAdapter = new ConsoleAdapter(poetryReader);

        consoleAdapter.ask();
    }
}
