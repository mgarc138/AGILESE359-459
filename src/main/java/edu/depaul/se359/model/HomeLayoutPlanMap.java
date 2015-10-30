package edu.depaul.se359.model;

/**
 * Created on 10/10/15.
 * Class: HomeLayoutPlanMap.java
 * Author: eric, marlon
 * Assignment: SE459
 */
public class HomeLayoutPlanMap {

    private HomeLayout HomeLayout;

    public HomeLayout getHomeLayout() {
        return HomeLayout;
    }

    public void setHomeLayout(HomeLayout homeLayout) {
        HomeLayout = homeLayout;
    }

    @Override
    public String toString() {
        return "HomeLayoutPlanMap{" +
                "HomeLayout=" + HomeLayout +
                '}';
    }
}
