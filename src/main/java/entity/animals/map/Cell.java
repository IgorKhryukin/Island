package entity.animals.map;

import entity.animals.organisms.Organism;

import java.lang.reflect.Type;
import java.util.Map;
import java.util.Set;

public class Cell {
    private final Map<Type, Set<Organism>> organismInCell;

    public Cell(Map<Type, Set<Organism>> organismInCell) {
        this.organismInCell = organismInCell;
    }

    public Map<Type, Set<Organism>> getOrganismInCell() {
        return organismInCell;
    }
}
