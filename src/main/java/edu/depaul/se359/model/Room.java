package edu.depaul.se359.model;

import java.util.ArrayList;

/**
 * Created by eric on 10/29/15.
 */
public class Room {
    ArrayList<Cell> cells;
    private String id;
    private int width;
    private int height;

    public Room(String id) {
        this.id = id;
        cells = new ArrayList<Cell>();
    }

    public Room() {
        cells = new ArrayList<Cell>();
    }

    public ArrayList<Cell> getCells() {
        return cells;
    }

    public void setCells(ArrayList<Cell> cells) {
        this.cells = cells;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Room{" +
                "cells=" + cells +
                ", id='" + id + '\'' +
                '}';
    }
}
