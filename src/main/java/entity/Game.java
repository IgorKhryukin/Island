package entity;

import entity.map.GameMap;
import factory.Factory;

public class Game {
    private final GameMap gameMap;
    private final Factory entityFactory;

    public Game(GameMap gameMap, Factory entityFactory) {
        this.gameMap = gameMap;
        this.entityFactory = entityFactory;
    }
}
