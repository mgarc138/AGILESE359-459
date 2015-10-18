package edu.depaul.se359.model;

import java.util.List;

/**
 * Created on 10/10/15.
 * Class: HomeLayout.java
 * Author: eric, marlon
 * Assignment: SE459
 */
public class HomeLayout {

    private String id;
    private List<Cell> cells;

    /**
     * Gets the id of the room layout
     *
     * @return String
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the id of the room layout
     *
     * @param id String
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the List of cells for the room layout
     *
     * @return List<Cell>
     */
    public List<Cell> getCells() {
        return cells;
    }

    /**
     * Sets the cells for the room layout
     *
     * @param cells
     */
    public void setCells(List<Cell> cells) {
        this.cells = cells;
    }

    @Override
    public String toString() {
        return "HomeLayout{" +
                "id='" + id + '\'' +
                ", cells=" + cells +
                '}';
    }
}
