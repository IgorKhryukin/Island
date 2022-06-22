package services;

import entity.animals.Animal;
import entity.animals.organisms.Organism;
import entity.map.Cell;
import entity.map.GameMap;

import java.lang.reflect.Type;
import java.util.Set;

public class OrganismWorker implements Runnable {

    private final Organism prototype;
    private final GameMap gameMap;

    public OrganismWorker(Organism prototype, GameMap gameMap) {
        this.prototype = prototype;
        this.gameMap = gameMap;
    }

    @Override
    public void run() {
        Cell[][] cells = gameMap.getCells();
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                Type type = prototype.getClass();
                Set<Organism> organisms = cell.getResidents().get(type);
                for (Organism organism : organisms) {
                    if (organism instanceof Animal animal) {
                        Cell destination = animal.move(cell);
                        //animal.eat(destination);
                        //animal.spawn(destination);
                    } else {
                        prototype.spawn(cell);
                    }
                }
            }
        }
    }
}
