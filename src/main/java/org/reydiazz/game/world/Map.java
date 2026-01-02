package org.reydiazz.game.world;

public class Map {

    private final int[][] map;
    private final int row;
    private final int col;

    public Map(int row, int column) {
        this.row = row;
        this.col = column;
        map = new int[row][column];
    }

    public int[][] getMap() {
        return map;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

}
