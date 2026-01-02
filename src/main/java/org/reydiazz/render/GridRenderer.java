package org.reydiazz.render;

import com.jme3.app.SimpleApplication;
import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;
import org.reydiazz.game.model.MapData;

public class GridRenderer {

    private final Node grid;

    public GridRenderer(SimpleApplication simpleApp) {
        grid = new Node("gridNode");
        simpleApp.getRootNode().attachChild(grid);
    }

    public void build(MapData mapData, AssetManager assetManager) {
        float lineThickness = 0.05f;
        float halfWidth = mapData.getWidth() / 2f;
        float halfDepth = mapData.getHeight() / 2f;

        Material lineMaterial = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        lineMaterial.setColor("Color", ColorRGBA.White);


        for (int x = 0; x <= mapData.getRows(); x++) {
            Box lineMesh = new Box(lineThickness,lineThickness,halfDepth);
            Geometry lineGeometry = new Geometry("VLine" + x, lineMesh);
            lineGeometry.setMaterial(lineMaterial);
            lineGeometry.setLocalTranslation(x * mapData.getCellSize(), mapData.getThickness() + 0.01f, halfDepth);
            grid.attachChild(lineGeometry);
        }

        for (int y = 0; y <= mapData.getCols(); y++) {
            Box lineMesh = new Box(halfWidth, lineThickness, lineThickness);
            Geometry lineGeometry = new Geometry("HLine" + y, lineMesh);
            lineGeometry.setMaterial(lineMaterial);
            lineGeometry.setLocalTranslation(halfWidth, mapData.getThickness() + 0.01f, y * mapData.getCellSize());
            grid.attachChild(lineGeometry);
        }
    }
}

