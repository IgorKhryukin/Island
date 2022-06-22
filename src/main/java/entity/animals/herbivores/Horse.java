package entity.animals.herbivores;

import entity.animals.Animal;
import entity.animals.organisms.Limit;
import entity.animals.organisms.Organism;
import entity.animals.predators.Wolf;
import property.Setting;

public class Horse extends Animal {
    public Horse(String name, String icon, double weight, Limit limit) {
        super(name, icon, weight, limit);
    }

    public static Organism birth() {
        return new Horse(Setting.HORSE_NAME, Setting.HORSE_ICON, Setting.HORSE_WEIGHT, new Limit(Setting.HORSE_MAX_WEIGHT, Setting.HORSE_MAX_COUNT, Setting.HORSE_MAX_SPEED, Setting.HORSE_MAX_FOOD));
    }
}
