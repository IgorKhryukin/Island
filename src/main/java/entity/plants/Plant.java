package entity.plants;

import entity.animals.predators.Bear;
import entity.map.Cell;
import entity.organisms.Limit;
import entity.organisms.Organism;
import property.Setting;

import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Plant extends Organism {

    public Plant(String name, String icon, double weight, Limit limit) {
        super(name, icon, weight, limit);
    }

    public static Organism birth() {
        return new Plant(Setting.PLANT_NAME, Setting.PLANT_ICON, Setting.PLANT_MAX_WEIGHT, new Limit(Setting.PLANT_MAX_WEIGHT, Setting.PLANT_MAX_COUNT, Setting.PLANT_MAX_SPEED, Setting.PLANT_MAX_FOOD));
    }

    @Override
    public void spawn(Cell currentCell) {
        Cell nextCell = currentCell.getNextCells(1);
        safePlantSpawn(nextCell);
    }

    private void safePlantSpawn(Cell currentCell) {
        currentCell.getLock().lock();
        try {
            Set<Organism> plants = currentCell.getResidents().get(this.getType());
            double maxWeight = this.getLimit().getMaxWeight();
            if(Objects.nonNull(plants)){
                if (/*plants.contains(this) &&
                        */plants.size() < this.getLimit().getMaxCount()) {
                    Organism clone = this.clone();
                    clone.setWeight(this.getLimit().getMaxWeight());
                    plants.add(clone);
                }
            } else {
                Map<String, Set<Organism>> residents = currentCell.getResidents();
                residents.put(this.getType(), new HashSet<>());
                Set<Organism> organisms = residents.get(getType());
                organisms.add(this);
            }
        } finally {
            currentCell.getLock().unlock();
        }
    }
}
