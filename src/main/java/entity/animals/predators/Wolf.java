package entity.animals.predators;

import entity.organisms.Limit;
import entity.organisms.Organism;
import entity.animals.Animal;
import property.Setting;

public class Wolf extends Animal {

    public Wolf(String name, String icon, double weight, Limit limit) {
        super(name, icon, weight, limit);
    }

    //@Override
    public static Organism birth() {
        return new Wolf(Setting.WOLF_NAME, Setting.WOLF_ICON, Setting.WOLF_WEIGHT, new Limit(Setting.WOLF_MAX_WEIGHT, Setting.WOLF_MAX_COUNT, Setting.WOLF_MAX_SPEED, Setting.WOLF_MAX_FOOD));
    }
}
