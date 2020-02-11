package fr.rli.freecodecamp.boundary.domain;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;

public class RandomPoemPicker {
    private Random random;

    public RandomPoemPicker() {
        this.random = new Random();
    }

    public Optional<Poem> pickPoem(List<Poem> poems) {
        Objects.requireNonNull(poems);

        if (poems.size() == 0) {
            return Optional.empty();
        }

        int randomIndex = random.nextInt(poems.size());
        Poem randomPoem = poems.get(randomIndex);
        return Optional.of(randomPoem);
    }
}