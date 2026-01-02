package org.reydiazz.game.model;

public class MapData {

    private int cellSize;

    private float thickness;

    private int cols;
    private int rows;

    private float posX;
    private float posY;
    private float posZ;


    public MapData(int cellSize, int cols, int rows, float posX, float posY, float posZ, float thickness) {
        this.cellSize = cellSize;
        this.posX = posX;
        this.posY = posY;
        this.posZ = posZ;
        this.cols = cols;
        this.rows = rows;
        this.thickness = thickness;
    }

    public float getWidth() {
        return cellSize * rows;
    }

    public float getHeight() {
        return cellSize * cols;
    }

    public float getThickness() {
        return thickness;
    }

    public void setThickness(float thickness) {
        this.thickness = thickness;
    }

    public float getPosX() {
        return posX;
    }

    public void setPosX(float posX) {
        this.posX = posX;
    }

    public int getCellSize() {
        return cellSize;
    }

    public void setCellSize(int cellSize) {
        this.cellSize = cellSize;
    }

    public float getPosY() {
        return posY;
    }

    public void setPosY(float posY) {
        this.posY = posY;
    }

    public float getPosZ() {
        return posZ;
    }

    public void setPosZ(float posZ) {
        this.posZ = posZ;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }
}
