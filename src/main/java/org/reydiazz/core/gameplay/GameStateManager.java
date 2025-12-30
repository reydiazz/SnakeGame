package org.reydiazz.core.gameplay;

import org.reydiazz.core.enums.GameState;
import org.reydiazz.game.enitites.Apple;
import org.reydiazz.game.enitites.Point;
import org.reydiazz.game.enitites.Snake;
import org.reydiazz.game.score.Score;
import org.reydiazz.game.world.Map;
import org.reydiazz.util.Util;

import java.util.Iterator;

public class GameStateManager {

    private final Map map;
    private final Score score;
    private final Snake snake;
    private Apple apple;
    private GameState gameState;

    public  GameStateManager(Map map, Snake snake) {
        this.map = map;
        this.snake = snake;
        this.score = new Score();
        this.gameState = GameState.PLAYING;
        generateApple();
    }

    public void generateApple() {
        for (int attempts = 0; attempts < 100; attempts++) {
            int x = Util.randomIntegerPositive(map.getRow() - 1);
            int y = Util.randomIntegerPositive(map.getCol() - 1);
            Apple candidate = new Apple(x, y);
            if (!pointCollidesWithSnake(candidate)) {
                apple = candidate;
                return;
            }
        }
        apple = null;
    }


    public void update(){
        if (snakeCollisionApple()){
            return;
        }
        if (snakeCollisionBody() || snakeCollisionMap()){
            gameState = GameState.GAME_OVER;
        }
    }

    public void reset(){
        score.updateBestScore();
        score.resetScore();
        snake.reset();
        gameState = GameState.PLAYING;
        generateApple();
    }

    private boolean snakeCollisionApple(){
        if (apple == null) {
            return false;
        }
        if (!headCollisionWith(apple)){
            return false;
        }
        snake.setGrowPending(1);
        score.updateScore(1);
        generateApple();
        return true;
    }

    private boolean snakeCollisionMap() {
        Point head = snake.getBody().getFirst();
        return head.getX() < 0 || head.getY() < 0 || head.getX() >= map.getRow() || head.getY() >= map.getCol();
    }

    private boolean snakeCollisionBody(){
        Iterator<Point> it = snake.getBody().iterator();
        Point head = it.next();
        while (it.hasNext()) {
            if (collision(head,it.next())) {
                return true;
            }
        }
        return false;
    }

    private boolean headCollisionWith(Point point){
        Point head = snake.getBody().getFirst();
        return collision(point,head);
    }

    private boolean collision(Point a, Point b){
        return  a.getX() == b.getX() && a.getY() == b.getY();
    }

    private boolean pointCollidesWithSnake(Point point){
        for (Point bodyPoint : snake.getBody()){
            if (collision(bodyPoint,point)){
                return true;
            }
        }
        return false;
    }

    public GameState getGameState() {
        return gameState;
    }
}
