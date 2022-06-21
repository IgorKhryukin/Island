package entity.map;

public class GameMap {
    private final Cell[][] gameMap;

    public GameMap(int rows, int cols) {
        this.gameMap = new Cell[rows][cols];
    }

    public Cell[][] getGameMap() {
        return gameMap;
    }

    public int getRows() {
        return gameMap.length;
    }

    public int getCols() {
        return gameMap[0].length;
    }
}
