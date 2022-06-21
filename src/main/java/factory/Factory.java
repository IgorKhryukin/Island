package factory;

import entity.animals.organisms.Organism;
import entity.map.Cell;

import java.util.List;

public interface Factory {
    Cell createRandomCell();

    List<Organism> getAllPrototypes();
}
