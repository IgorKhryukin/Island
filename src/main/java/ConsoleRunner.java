import factory.EntityFactory;

import java.io.IOException;

public class ConsoleRunner {

    public static void main(String[] args) throws IOException {
        System.out.println(new EntityFactory().getAllPrototypes());
    }
}
