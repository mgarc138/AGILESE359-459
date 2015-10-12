package edu.depaul.se359.model;

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
    private int surface;

    public Cell(int xPosition, int yPosition, int rightPath, int leftPath, int upPath, int downPath, int charge, int dirt, int surface){

        setxPosition(xPosition);
        setyPosition(yPosition);
        setRight(rightPath);
        setLeft(leftPath);
        setUp(upPath);
        setDown(downPath);
        setCharge(charge);
        setDirt(dirt);
        setSurface(surface);
    }



    public int getSurface() {
        return surface;
    }

    public void setSurface(int surface) {
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

        if(xPosition < 0){

            // exection
        }

        this.xPosition = xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void setyPosition(int yPosition) {

        if(yPosition < 0){

            // exection
        }

        this.yPosition = yPosition;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        
        if(right > 4){

            // exception
        }

        if(right < 1){

            // exception
        }

        this.right = right;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {

        if(left > 4){

            // exception
        }

        if(left < 1){

            // exception
        }

        this.left = left;
    }

    public int getUp() {
        return up;
    }

    public void setUp(int up) {

        if(up > 4){

            //exception
        }

        if(up < 0){

            // exception
        }

        this.up = up;
    }

    public int getDown() {
        return down;
    }

    public void setDown(int down) {
        

        if(up > 4){

            // exception
        }

        if(up < 0){

            // exception
        }

        this.down = down;
    }

    public int getCharge() {
        return charge;
    }

    public void setCharge(int charge) {
        if(charge < 0){

            // exception
        }

        this.charge = charge;
    }

    public int getDirt() {

        return dirt;
    }

    public void setDirt(int dirt) {

        if(dirt < 0){

            //exception
        }

        this.dirt = dirt;
    }
}
