package org.reydiazz;

import com.jme3.app.SimpleApplication;

public class Main extends SimpleApplication {

    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }

    @Override
    public void simpleInitApp() {
        System.out.println("JMonkeyEngine");
    }
}