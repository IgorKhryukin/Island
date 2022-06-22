package entity.map;

import entity.animals.organisms.Organism;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Cell {
    private final Map<Type, Set<Organism>> residents;
    private List<Cell> nextCell;

    public Cell(Map<Type, Set<Organism>> residents) {
        this.residents = residents;
    }

    public Map<Type, Set<Organism>> getResidents() {
        return residents;
    }

    public void setNextCell(List<Cell> nextCell) {
        this.nextCell = nextCell;
    }

    public List<Cell> getNextCell() {
        return nextCell;
    }
}
