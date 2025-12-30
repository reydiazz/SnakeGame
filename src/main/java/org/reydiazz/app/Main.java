package org.reydiazz.app;

import com.jme3.app.SimpleApplication;
import org.reydiazz.state.PlayState;

public class Main extends SimpleApplication {

    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }

    @Override
    public void simpleInitApp() {
        PlayState playState = new PlayState();
        stateManager.attach(playState);
    }
}