import entity.Game;
import entity.animals.Animal;
import entity.animals.organisms.Organism;
import entity.map.Cell;
import entity.map.GameMap;
import factory.EntityFactory;
import factory.Factory;
import factory.GameMapCreator;
import property.Setting;
import services.GameWorker;
import view.ConsoleView;
import view.View;

import java.lang.reflect.Type;
import java.util.Map;
import java.util.Set;


public class ConsoleRunner {

    public static void main(String[] args) {
        Factory entityFactory = new EntityFactory();
        GameMapCreator gameMapCreator = new GameMapCreator(entityFactory);
        GameMap gameMap = gameMapCreator.createRandomFilledGameMap(Setting.MAP_ROWS, Setting.MAP_COLS);
        View view = new ConsoleView(gameMap);
        Game game = new Game(gameMap, entityFactory, view);
        /*view.showMap();
        view.showStatistics();
        Cell[][] cells = gameMap.getCells();
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                Map<Type, Set<Organism>> org = cells[i][j].getResidents();
                for (Set<Organism> organism : org.values()) {
                    for (Organism or : organism) {
                        if(or instanceof Animal animal){
                            animal.move(cells[i][j]);
                        }
                    }
                }
            }
        }
        view.showMap();
        view.showStatistics();*/
        GameWorker gameWorker = new GameWorker(game);
        gameWorker.start();
    }
}
