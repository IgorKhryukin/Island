package factory;

import entity.animals.herbivores.Horse;
import entity.animals.organisms.Organism;
import entity.map.Cell;
import entity.animals.predators.Wolf;
import utils.EntityFactoryData;
import utils.RandomValue;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.*;

public class EntityFactory implements Factory{
    private static final Class<?>[] TYPES = {Wolf.class, Horse.class};
    private static final Organism[] PROTOTYPES;

    static {
        try {
            PROTOTYPES = EntityFactoryData.createPrototypes(TYPES);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public EntityFactory() {

    }

    @Override
    public Cell createRandomCell() {
        Map<Type, Set<Organism>> residents = new HashMap<>();
        boolean fill = RandomValue.get(50);
        if (fill) {
            for (Organism prototype : PROTOTYPES) {
                Type type = prototype.getClass();
                boolean born = RandomValue.get(50);
                if (born) {
                    residents.putIfAbsent(type, new HashSet<>());
                    Set<Organism> organisms = residents.get(prototype.getClass());
                    int currentCount = organisms.size();
                    int max = prototype.getLimit().getMaxCount() - currentCount;
                    int count = RandomValue.random(0, max);
                    for (int i = 0; i < count; i++) {
                        organisms.add(prototype.clone());
                    }

                }
            }
        }
        Cell cell = new Cell(residents);
        cell.setNextCell(new ArrayList<>());
        return cell;
    }

    @Override
    public List<Organism> getAllPrototypes() {
        return Arrays.asList(PROTOTYPES);
    }
}
