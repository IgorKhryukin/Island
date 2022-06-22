package entity.map;

import entity.animals.organisms.Organism;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Cell {
    private final Map<Type, Set<Organism>> organismInCell;
    private List<Cell> nextCell;

    public Cell(Map<Type, Set<Organism>> organismInCell) {
        this.organismInCell = organismInCell;
    }

    public Map<Type, Set<Organism>> getOrganismInCell() {
        return organismInCell;
    }

    public void setNextCell(List<Cell> nextCell) {
        this.nextCell = nextCell;
    }

    public List<Cell> getNextCell() {
        return nextCell;
    }
}
