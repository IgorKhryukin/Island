package factory;

import entity.animals.organisms.Organism;
import entity.animals.map.Cell;
import entity.animals.predators.Wolf;
import utils.EntityFactoryData;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

public class EntityFactory implements Factory{
    private static final Class<?>[] TYPES = {Wolf.class};
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
        return null;
    }

    @Override
    public List<Organism> getAllPrototypes() {
        return Arrays.asList(PROTOTYPES);
    }
}
