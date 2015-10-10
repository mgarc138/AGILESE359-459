package main.model;

import java.util.List;

/**
 * Created on 10/10/15.
 * Class: HomeLayoutList.java
 * Author: eric
 * Assignment: SE459
 */
public class HomeLayoutList {
    private List<HomeLayout> HomeLayout;

    public List<main.model.HomeLayout> getHomeLayout() {
        return HomeLayout;
    }

    public void setHomeLayout(List<main.model.HomeLayout> homeLayout) {
        HomeLayout = homeLayout;
    }

    @Override
    public String toString() {
        return "HomeLayoutList{" +
                "HomeLayout=" + HomeLayout +
                '}';
    }
}
