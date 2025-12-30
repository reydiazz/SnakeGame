package org.reydiazz.render;

import com.jme3.app.SimpleApplication;
import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;
import org.reydiazz.game.world.Map;

public class GridRenderer {

    private final Node grid;

    public GridRenderer(SimpleApplication simpleApp) {
        grid = new Node("Grid");
        simpleApp.getRootNode().attachChild(grid);
    }

    public void build(Map map, AssetManager assetManager) {

        Material lineMat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        lineMat.setColor("Color", ColorRGBA.White);

        float cellSize = 1f;
        float width = map.getRow() * cellSize;
        float height = map.getCol() * cellSize;

        for (int x = 0; x <= map.getRow(); x++) {
            Box line = new Box(0.02f, 0.01f, height / 2f);
            Geometry geo = new Geometry("VLine" + x, line);
            geo.setMaterial(lineMat);
            geo.setLocalTranslation(x * cellSize, 0.11f, height / 2f);
            grid.attachChild(geo);
        }

        for (int y = 0; y <= map.getCol(); y++) {
            Box line = new Box(width / 2f, 0.01f, 0.02f);
            Geometry geo = new Geometry("HLine" + y, line);
            geo.setMaterial(lineMat);
            geo.setLocalTranslation(width / 2f, 0.11f, y * cellSize);
            grid.attachChild(geo);
        }
    }
}

