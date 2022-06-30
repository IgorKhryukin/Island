package entity.animals;

import actions.Movable;
import actions.Reproducible;
import entity.animals.organisms.Limit;
import entity.animals.organisms.Organism;
import entity.map.Cell;

import java.lang.reflect.Type;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;

public abstract class Animal extends Organism implements Movable, Reproducible {
    public Animal(String name, String icon, double weight, Limit limit) {
        super(name, icon, weight, limit);
    }

    @Override
    public Cell move(Cell startCell) {
        int countStep = this.getLimit().getMaxSpeed();
        Cell destinationCell = startCell.getNextCells(countStep);
        removeMe(startCell);
        addMe(destinationCell);
        return destinationCell;

    }

    /*private Cell findLastCell(Cell startCell, int countCellForStep) {
        Cell newCell = new Cell(startCell.getResidents());
        Set<Cell> visitedCells = new HashSet<>();
        while (visitedCells.size() < countCellForStep) {
            var nextCells = startCell
                    .getNextCell()
                    .stream()
                    .filter(cell -> !visitedCells.contains(cell))
                    .toList();
            int countDirections = nextCells.size();
            if (countDirections > 0) {
                newCell = nextCells.get(ThreadLocalRandom.current().nextInt(countDirections));
                visitedCells.add(newCell);
            } else {
                break;
            }
        }
        return newCell;
    }*/

    private void addMe(Cell cell) {
        cell.getLock().lock();
        try {
            Set<Organism> set = cell.getResidents().get(getType());
            if (Objects.nonNull(set)) {
                int maxCount = getLimit().getMaxCount();
                set.add(this);
            } else {
                Map<String, Set<Organism>> residents = cell.getResidents();
                residents.put(this.getType(), new HashSet<>());
                Set<Organism> organisms = residents.get(getType());
                organisms.add(this);
            }

        } finally {
            cell.getLock().unlock();
        }
    }

    private void removeMe(Cell cell) {
        cell.getLock().lock();
        try {
            cell.getResidents().get(getType()).remove(this);
        } finally {
            cell.getLock().unlock();
        }
    }

    private void safeModification(Cell cell, Consumer<Cell> operation) {
        cell.getLock().lock();
        try {
            operation.accept(cell);
        } finally {
            cell.getLock().unlock();
        }
    }

    /*private void bornClone(Cell cell) {
        safeModification(cell, c -> c.getResidents().get(this.getClass()).add(this.clone()));
    }*/

    @Override
    public void spawn(Cell currentCell) {
        /*Set<Organism> organisms = currentCell.getResidents().get(this.getType());
        if (Objects.nonNull(organisms) && organisms.contains(this) && organisms.size() > 2) {
            //bornClone(currentCell);
            safeSpawnAnimal(currentCell);
        }*/
        safeSpawnAnimal(currentCell);
    }

    private void safeSpawnAnimal(Cell currentCell) {
        currentCell.getLock().lock();
        try {
            Set<Organism> organisms = currentCell.getResidents().get(this.getType());
            double maxWeight = this.getLimit().getMaxWeight();
            if (this.getWeight() > maxWeight / 2 &&
                    organisms.contains(this) &&
                    organisms.size() >= 2 &&
                    organisms.size() < this.getLimit().getMaxCount()) {
                double childWeight = this.getLimit().getMaxWeight() / 4;
                this.setWeight(this.getWeight() - childWeight);
                Organism clone = this.clone();
                clone.setWeight(childWeight);
                organisms.add(clone);
            }
        } finally {
            currentCell.getLock().unlock();
        }
    }
}
