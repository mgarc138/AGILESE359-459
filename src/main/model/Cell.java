package main.model;

/**
 * Created on 10/10/15.
 * Class: Cell.java
 * Author: eric
 * Assignment: SE459
 */
public class Cell {
    private int xPosition;
    private int yPosition;
    private int right;
    private int left;
    private int up;
    private int down;
    private int charge;
    private int dirt;
    private Surface surface;

    public Surface getSurface() {
        return surface;
    }

    public void setSurface(Surface surface) {
        this.surface = surface;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "xPosition=" + xPosition +
                ", yPosition=" + yPosition +
                ", right=" + right +
                ", left=" + left +
                ", up=" + up +
                ", down=" + down +
                ", charge=" + charge +
                ", dirt=" + dirt +
                ", surface=" + surface +
                '}';
    }

    public int getxPosition() {
        return xPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getUp() {
        return up;
    }

    public void setUp(int up) {
        this.up = up;
    }

    public int getDown() {
        return down;
    }

    public void setDown(int down) {
        this.down = down;
    }

    public int getCharge() {
        return charge;
    }

    public void setCharge(int charge) {
        this.charge = charge;
    }

    public int getDirt() {
        return dirt;
    }

    public void setDirt(int dirt) {
        this.dirt = dirt;
    }
}
