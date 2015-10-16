package edu.depaul.se359.model;

import java.util.List;

/**
 * Created on 10/10/15.
 * Class: HomeLayoutList.java
 * Author: eric, marlon
 * Assignment: SE459
 */
public class HomeLayoutList {
    
	private List<HomeLayout> HomeLayout;

    public List<HomeLayout> getHomeLayout() {
        return HomeLayout;
    }

    public void setHomeLayout(List<HomeLayout> homeLayout) {
        HomeLayout = homeLayout;
    }
    
    public void addAHomeLayout(HomeLayout home){
    	
    	this.HomeLayout.add(home);
    }

    @Override
    public String toString() {
        return "HomeLayoutList{" +
                "HomeLayout=" + HomeLayout +
                '}';
    }
}
