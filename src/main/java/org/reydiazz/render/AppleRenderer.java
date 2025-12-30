package org.reydiazz.render;

import com.jme3.app.SimpleApplication;
import com.jme3.scene.Node;

public class AppleRenderer {
    private Node appleNode;

    public AppleRenderer(SimpleApplication simpleApp) {
        appleNode = new Node("apple");
        simpleApp.getRootNode().attachChild(appleNode);
    }

    public void generate(){

    }
}
