package factory;

import entity.organisms.Organism;
import entity.map.Cell;

import java.util.List;

public interface Factory {
    Cell createRandomCell();

    List<Organism> getAllPrototypes();
}
