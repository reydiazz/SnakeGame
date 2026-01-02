package org.reydiazz.render;

import com.jme3.app.SimpleApplication;
import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Sphere;
import org.reydiazz.game.model.MapData;


public class AppleRenderer {

    private final Node appleNode;

    public AppleRenderer(SimpleApplication simpleApp) {
        appleNode = new Node("appleNode");
        simpleApp.getRootNode().attachChild(appleNode);
    }

    public void build(MapData mapData, AssetManager assetManager, int row, int col) {
        float fillRatio = 0.7f;
        float halfCellSize = mapData.getCellSize() / 2f;
        float radius = fillRatio * halfCellSize;
        float posX = row * mapData.getCellSize() + halfCellSize;
        float posZ = col * mapData.getCellSize() + halfCellSize;
        float posY = mapData.getThickness() + radius;
        Sphere appleMesh = new Sphere(16,16,radius);
        Geometry appleGeometry = new Geometry("appleGeometry",appleMesh);
        Material sphereMaterial = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        sphereMaterial.setColor("Color", ColorRGBA.Red);
        appleGeometry.setMaterial(sphereMaterial);
        appleGeometry.setLocalTranslation(posX,posY,posZ);
        appleNode.attachChild(appleGeometry);
    }
}
