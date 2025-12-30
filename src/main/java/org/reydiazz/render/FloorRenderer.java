package org.reydiazz.render;


import com.jme3.app.SimpleApplication;
import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;
import org.reydiazz.game.world.Map;

public class FloorRenderer {

    private final Node floorNode;

    public FloorRenderer(SimpleApplication simpleApp) {
        floorNode = new Node("Floor");
        simpleApp.getRootNode().attachChild(floorNode);
    }

    public void build(Map map, AssetManager assetManager) {
        Box floorMesh = new Box(map.getRow()/2f,0.1f,map.getCol()/2f);
        Geometry floorGeometry = new Geometry("FloorGeometry",floorMesh);
        Material material = new Material(assetManager,"Common/MatDefs/Light/Lighting.j3md");
        material.setBoolean("UseMaterialColors",true);
        material.setColor("Diffuse", ColorRGBA.Brown);
        material.setColor("Ambient", ColorRGBA.Brown);
        floorGeometry.setMaterial(material);
        floorGeometry.setLocalTranslation(map.getRow()/2f,0f,map.getCol()/2f);
        floorNode.attachChild(floorGeometry);
    }




}
