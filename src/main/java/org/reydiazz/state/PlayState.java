package org.reydiazz.state;

import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.BaseAppState;
import com.jme3.light.DirectionalLight;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import org.reydiazz.game.world.Map;
import org.reydiazz.render.FloorRenderer;
import org.reydiazz.render.GridRenderer;

public class PlayState extends BaseAppState {

    private Map map;
    private FloorRenderer floorRenderer;
    private GridRenderer gridRenderer;

    @Override
    protected void initialize(Application app) {

        SimpleApplication simpleApp = (SimpleApplication) app;

        //Map
        map = new Map(20,20);
        floorRenderer = new FloorRenderer(simpleApp);
        floorRenderer.build(map,app.getAssetManager());
         //Grid - map
        gridRenderer = new GridRenderer(simpleApp);
        gridRenderer.build(map,app.getAssetManager());

        //Light
        DirectionalLight sun = new DirectionalLight();
        Vector3f lightPos = new Vector3f(-1, -2, -1).normalizeLocal();
        sun.setDirection(lightPos);
        sun.setColor(ColorRGBA.White);
        simpleApp.getRootNode().addLight(sun);

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
