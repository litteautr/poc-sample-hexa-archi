package fr.rli.freecodecamp.infrastructure.adapter.driven;

import fr.rli.freecodecamp.boundary.port.driven.IWriteLines;

import java.util.Objects;

public class ConsoleWriter implements IWriteLines {
    public void writeLines(String[] lines) {
        Objects.requireNonNull(lines);
        for (String line : lines) {
            System.out.println(line);
        }
        System.out.println("end");
    }
}