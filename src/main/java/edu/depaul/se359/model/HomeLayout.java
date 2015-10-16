package edu.depaul.se359.model;

import java.util.List;

/**
 * Created on 10/10/15.
 * Class: HomeLayout.java
 * Author: eric, marlon
 * Assignment: SE459
 */
public class HomeLayout {
   
	
    private List<FloorPlanMap> CollectionOfHomeLayouts;

    

    public List<FloorPlanMap> getCollectionOfHomeLayouts() {
        return this.CollectionOfHomeLayouts;
    }

    public void setCollectionOfHomeLayouts(List<FloorPlanMap> cells) {
        this.CollectionOfHomeLayouts = cells;
    }

    
    
    @Override
    public String toString() {
        return "HomeLayout{" +
    
                ", Number of Home Layouts=" + this.CollectionOfHomeLayouts.size() +
                '}';
    }
}
