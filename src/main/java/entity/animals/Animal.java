package entity.animals;

import entity.animals.organisms.Limit;
import entity.animals.organisms.Organism;

public abstract class Animal extends Organism {
    public Animal(String name, String icon, double weight, Limit limit) {
        super(name, icon, weight, limit);
    }

}
