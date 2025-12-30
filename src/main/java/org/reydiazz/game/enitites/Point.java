package org.reydiazz.game.enitites;

import org.reydiazz.util.Util;

public class Point {

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
        this.x = Util.randomIntegerPositive();
        this.y = Util.randomIntegerPositive();
    }

    public void printPoint(){
        System.out.println("[" + this.x + ":" + this.y + "]");
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}

