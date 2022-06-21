package factory;

import entity.animals.map.Cell;
import entity.animals.map.GameMap;

public class GameMapCreator {

    private final Factory entityFactory;


    public GameMapCreator(Factory entityFactory) {
        this.entityFactory = entityFactory;
    }

    public GameMap createRandomGameMap (int rows, int cols){
        GameMap gameMap = new GameMap(rows, cols);
        Cell[][] cells = gameMap.getGameMap();
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = entityFactory.createRandomCell();
            }
        }
        return gameMap;
    }

}
