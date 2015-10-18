package edu.depaul.se359.model;

import java.util.List;

/**
 * Created on 10/10/15.
 * Class: HomeLayoutPlanMap.java
 * Author: eric, marlon
 * Assignment: SE459
 */
public class HomeLayoutPlanMap {
    
	private List<HomeLayout> HomeLayout;

    public List<HomeLayout> getHomeLayout() {
        return HomeLayout;
    }

    public void setHomeLayout(List<HomeLayout> homeLayout) {
        HomeLayout = homeLayout;
    }

    /**
     * Returns the layout of the floor with the specified id
     *
     * @param floorId
     * @return
     */
    public HomeLayout getFloor(String floorId) {
        for (HomeLayout layout : this.HomeLayout) {
            if (layout.getId().equals(floorId)) {
                return layout;
            }
        }

        return null;
    }

    /**
     * Remove a floor layout from the Home
     *
     * @param floorId
     * @return boolean | true if successful
     */
    public boolean removeFloor(String floorId) {
        for (HomeLayout layout : this.HomeLayout) {
            if (layout.getId().equals(floorId)) {
                this.HomeLayout.remove(this.HomeLayout.indexOf(layout));

                return true;
            }
        }

        return false;
    }

    /**
     * Adds a floor layout to the Home
     *
     * @param layout
     */
    public void addFloor(HomeLayout layout) {
        this.HomeLayout.add(layout);
    }

    @Override
    public String toString() {
        return "HomeLayoutPlanMap{" +
                "HomeLayout=" + HomeLayout +
                '}';
    }
}
