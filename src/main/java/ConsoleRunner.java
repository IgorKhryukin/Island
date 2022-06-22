import entity.Game;
import entity.map.GameMap;
import factory.EntityFactory;
import factory.Factory;
import factory.GameMapCreator;
import view.ConsoleView;
import view.View;

import java.io.IOException;

public class ConsoleRunner {

    public static void main(String[] args) throws IOException {
        Factory entityFactory = new EntityFactory();
        GameMapCreator gameMapCreator = new GameMapCreator(entityFactory);
        GameMap gameMap = gameMapCreator.createRandomFilledGameMap(5, 20);
        View view = new ConsoleView(gameMap);
        Game game = new Game(gameMap, entityFactory, view);
        view.showMap();
    }
}
