package fr.rli.alistairinhexagone;

import fr.rli.alistairinhexagone.domain.PoetryReader;
import fr.rli.alistairinhexagone.infra.adapter.driven.PoetryFileAdapter;
import fr.rli.alistairinhexagone.infra.adapter.driver.ConsoleAdapter;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        //1. Instantiate the "I need to go out" Adapters
        PoetryFileAdapter fileAdapter = null;
        try {
            fileAdapter = new PoetryFileAdapter("C:\\Users\\litte\\Documents");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //2. Instantiate the Hexagon
        PoetryReader poetryReader = new PoetryReader(fileAdapter);

        //3. Instantiate "I want to go inside the hexagone" Adapters
        ConsoleAdapter consoleAdapter = new ConsoleAdapter(poetryReader);

        consoleAdapter.ask();
    }
}
