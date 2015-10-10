package main.java.edu.depaul.se359.model;

import java.util.List;

/**
 * Created on 10/10/15.
 * Class: HomeLayout.java
 * Author: eric
 * Assignment: SE459
 */
public class HomeLayout {
    private String id;
    private List<Cell> cells;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Cell> getCells() {
        return cells;
    }

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
