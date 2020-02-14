package fr.rli.alistairinhexagone.infra.adapter.driver;

public class ConsolePublicationStrategy implements IwriteLine {
    @Override
    public void writeLine(String s) {
        System.out.println(s);
    }
}