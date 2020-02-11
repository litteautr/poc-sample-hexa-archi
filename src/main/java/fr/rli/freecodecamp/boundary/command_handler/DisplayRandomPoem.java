package fr.rli.freecodecamp.boundary.command_handler;

import fr.rli.freecodecamp.boundary.domain.Poem;
import fr.rli.freecodecamp.boundary.domain.RandomPoemPicker;
import fr.rli.freecodecamp.boundary.port.driven.IObtainPoems;
import fr.rli.freecodecamp.boundary.port.driven.IWriteLines;
import fr.rli.freecodecamp.command.AskForPoem;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class DisplayRandomPoem implements Consumer<AskForPoem> {
    private IObtainPoems poemObtainer;
    private RandomPoemPicker randomPoemPicker;
    private IWriteLines lineWriter;

    public DisplayRandomPoem(IObtainPoems poemObtainer, IWriteLines lineWriter) {
        this.poemObtainer = poemObtainer;
        this.randomPoemPicker = new RandomPoemPicker();
        this.lineWriter = lineWriter;
    }

    @Override
    public void accept(AskForPoem askForPoem) {
        List<Poem> poems = obtainPoems(askForPoem);
        Optional<Poem> poem = pickRandomPoem(poems);
        writeLines(poem);
    }

    private List<Poem> obtainPoems(AskForPoem askForPoem) {
        String language = askForPoem.getLanguage();
        String[] poems = poemObtainer.getMePoems(language);
        return Arrays.stream(poems)
                .map(Poem::new)
                .collect(Collectors.toList());
    }

    private Optional<Poem> pickRandomPoem(List<Poem> poemList) {
        Optional<Poem> randomPoem = randomPoemPicker.pickPoem(poemList);
        return randomPoem;
    }

    private void writeLines(Optional<Poem> poem) {
        poem.ifPresent(p -> lineWriter.writeLines(p.getVerses()));
    }
}