package org.reydiazz.render;

import com.jme3.app.SimpleApplication;
import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;
import com.jme3.scene.shape.Sphere;
import org.reydiazz.game.model.MapData;

public class SnakeRender {

    private final Node snakeNode;


    public SnakeRender(SimpleApplication simpleApp) {
        snakeNode = new Node("snakeNode");
        simpleApp.getRootNode().attachChild(snakeNode);
    }

    public void build(MapData mapData, AssetManager assetManager, int row, int col){
        float halfCellSize = mapData.getCellSize() / 2f;
        float fillRatio = 0.7f;
        float cubeSize = halfCellSize * fillRatio;
        float posX = row * mapData.getCellSize() + halfCellSize;
        float posZ = col * mapData.getCellSize() + halfCellSize;
        float posY = mapData.getThickness() + cubeSize;
        Box snakeMesh = new Box(cubeSize, cubeSize, cubeSize);
        Geometry snakeGeometry = new Geometry("RoundedCube", snakeMesh);
        Material snakeMaterial = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        snakeMaterial.setColor("Color", ColorRGBA.Green);
        snakeGeometry.setMaterial(snakeMaterial);
        snakeGeometry.setLocalTranslation(posX, posY, posZ);
        snakeNode.attachChild(snakeGeometry);
    }

}
