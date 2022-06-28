package services;

import entity.animals.organisms.Organism;

import java.util.function.Consumer;

public class Task {
    private final Organism organism;
    private final Consumer<Organism> operation;

    public Task(Organism organism, Consumer<Organism> operation) {
        this.organism = organism;
        this.operation = operation;
    }

    public void run() {
        operation.accept(organism);
    }
}
