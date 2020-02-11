package fr.rli.hexaarchi.infrastructure.adapter.driven;

import fr.rli.hexaarchi.boundary.port.driven.IWriteLines;

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