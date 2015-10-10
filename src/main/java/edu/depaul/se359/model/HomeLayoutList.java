package main.java.edu.depaul.se359.model;

import java.util.List;

/**
 * Created on 10/10/15.
 * Class: HomeLayoutList.java
 * Author: eric
 * Assignment: SE459
 */
public class HomeLayoutList {
    private List<HomeLayout> HomeLayout;

    public List<main.java.edu.depaul.se359.model.HomeLayout> getHomeLayout() {
        return HomeLayout;
    }

    public void setHomeLayout(List<main.java.edu.depaul.se359.model.HomeLayout> homeLayout) {
        HomeLayout = homeLayout;
    }

    @Override
    public String toString() {
        return "HomeLayoutList{" +
                "HomeLayout=" + HomeLayout +
                '}';
    }
}
