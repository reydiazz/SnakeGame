package org.reydiazz.render;


import com.jme3.app.SimpleApplication;
import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;
import org.reydiazz.game.model.MapData;

public class FloorRenderer {

    private final Node floorNode;

    public FloorRenderer(SimpleApplication simpleApp) {
        floorNode = new Node("floorNode");
        simpleApp.getRootNode().attachChild(floorNode);
    }

    public void build(MapData mapData, AssetManager assetManager) {
        float halfWidth = mapData.getWidth() / 2f;
        float halfHeight = mapData.getThickness() / 2f;
        float halfDepth = mapData.getHeight() / 2f;
        Box floorMesh = new Box(halfWidth,halfHeight,halfDepth);
        Geometry floorGeometry = new Geometry("floorGeometry",floorMesh);
        Material floorMaterial = new Material(assetManager,"Common/MatDefs/Misc/Unshaded.j3md");
        floorMaterial.setColor("Color", ColorRGBA.fromRGBA255(41, 41, 41,1));
        floorGeometry.setMaterial(floorMaterial);
        floorGeometry.setLocalTranslation(mapData.getPosX() + halfWidth, mapData.getPosY() + halfHeight, mapData.getPosZ() + halfDepth);
        floorNode.attachChild(floorGeometry);
    }

}
