package utils;

import entity.animals.herbivores.Horse;
import entity.animals.organisms.Organism;
import entity.animals.predators.Bear;
import entity.animals.predators.Wolf;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class EntityFactoryData {
    public EntityFactoryData(){

    }

    public static Organism[] createPrototypes(Class<?>[] TYPES) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Organism[] organisms = new Organism[TYPES.length];
        int index = 0;
        for (Class<?> type : TYPES) {
            Method getBirth = type.getDeclaredMethod("birth");
            organisms[index++] = (Organism) getBirth.invoke(type);
        }
        /*organisms[0] = Horse.birth();
        organisms[1] = Wolf.birth();
        organisms[2] = Bear.birth();*/
        //System.out.println(Arrays.toString(organisms));
        return organisms;
    }
}
