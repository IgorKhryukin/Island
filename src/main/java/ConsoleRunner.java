import entity.Game;
import entity.map.GameMap;
import factory.EntityFactory;
import factory.Factory;
import factory.GameMapCreator;
import property.Setting;
import view.ConsoleView;
import view.View;


public class ConsoleRunner {

    public static void main(String[] args) {
        Factory entityFactory = new EntityFactory();
        GameMapCreator gameMapCreator = new GameMapCreator(entityFactory);
        GameMap gameMap = gameMapCreator.createRandomFilledGameMap(Setting.MAP_ROWS, Setting.MAP_COLS);
        View view = new ConsoleView(gameMap);
        Game game = new Game(gameMap, entityFactory, view);
        view.showMap();
        view.showStatistics();
    }
}
