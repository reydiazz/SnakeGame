import org.reydiazz.core.*;

public class Test {
    public static void main(String[] args) {
        Map map = new Map(7,7);
        Snake snake = new Snake();
        GameStateManager gsm = new GameStateManager(map,snake);
    }
}
