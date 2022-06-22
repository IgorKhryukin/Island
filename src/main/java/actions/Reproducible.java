package actions;

import entity.map.Cell;

@FunctionalInterface
public interface Reproducible {
    void spawn(Cell currentCell);
}
