package org.reydiazz.state;

import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.BaseAppState;
import com.jme3.math.Vector3f;
import org.reydiazz.game.world.Map;
import org.reydiazz.render.AppleRenderer;
import org.reydiazz.render.FloorRenderer;
import org.reydiazz.render.GridRenderer;
import org.reydiazz.game.model.MapData;

public class PlayState extends BaseAppState {

    @Override
    protected void initialize(Application app) {

        SimpleApplication simpleApp = (SimpleApplication) app;

        //Map
        Map map = new Map(4,4);
        MapData mapData = new MapData(5, map.getCol(), map.getRow(), 0, 0, 0, 1f);

        //Floor
        FloorRenderer floorRenderer = new FloorRenderer(simpleApp);
        floorRenderer.build(mapData,app.getAssetManager());

        //Grid
        GridRenderer gridRenderer = new GridRenderer(simpleApp);
        gridRenderer.build(mapData,app.getAssetManager());

        //Apple
        AppleRenderer appleRenderer = new AppleRenderer(simpleApp);
        appleRenderer.build(mapData,app.getAssetManager(),0,0);

        //Camera
        simpleApp.getCamera().setLocation(new Vector3f(10, 25, 25));
        simpleApp.getCamera().lookAt(new Vector3f(10, 0, 10), Vector3f.UNIT_Y);
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
