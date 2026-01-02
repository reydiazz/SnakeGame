package org.reydiazz.state;

import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.BaseAppState;
import com.jme3.math.Vector3f;
import org.reydiazz.core.gameplay.GameStateManager;
import org.reydiazz.game.enitites.Point;
import org.reydiazz.game.enitites.Snake;
import org.reydiazz.game.world.Map;
import org.reydiazz.render.AppleRenderer;
import org.reydiazz.render.FloorRenderer;
import org.reydiazz.render.GridRenderer;
import org.reydiazz.game.model.MapData;
import org.reydiazz.render.SnakeRender;

public class PlayState extends BaseAppState {

    @Override
    protected void initialize(Application app) {

        SimpleApplication simpleApp = (SimpleApplication) app;

        //Map
        Map map = new Map(17,15);
        MapData mapData = new MapData(2, map.getCol(), map.getRow(), 0, 0, 0, 1f);

        //Floor
        FloorRenderer floorRenderer = new FloorRenderer(simpleApp);
        floorRenderer.build(mapData,app.getAssetManager());

        //Grid
        GridRenderer gridRenderer = new GridRenderer(simpleApp);
        gridRenderer.build(mapData,app.getAssetManager());

        //Snake
        Snake snake = new Snake(2,3);
        snake.getBody().add(new Point(1,3));
        for (Point point : snake.getBody()) {
            SnakeRender snakeRender = new SnakeRender(simpleApp);
            snakeRender.build(mapData,app.getAssetManager(),point.getX(),point.getY());
        }

        //GameStateManager
        GameStateManager gameStateManager = new GameStateManager(map,snake);

        //Apple
        AppleRenderer appleRenderer = new AppleRenderer(simpleApp);
        appleRenderer.build(mapData,app.getAssetManager(),gameStateManager.getApple().getX(),gameStateManager.getApple().getY());

        //Camera
        simpleApp.getCamera().setLocation(new Vector3f(0, 50, 0));
        simpleApp.getCamera().lookAt(new Vector3f(17.5f, 17.5f, 17.5f), Vector3f.UNIT_Y);
        simpleApp.getFlyByCamera().setMoveSpeed(50f);

    }



    @Override
    protected void cleanup(Application application) {

    }

    @Override
    protected void onEnable() {

    }

    @Override
    protected void onDisable() {

    }
}
