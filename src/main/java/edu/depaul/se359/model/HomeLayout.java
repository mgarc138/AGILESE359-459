package edu.depaul.se359.model;

import java.util.List;

/**
 * Created on 10/10/15.
 * Class: HomeLayout.java
 * Author: eric, marlon
 * Assignment: SE459
 */
public class HomeLayout {
   
	private FloorPlanMap homeLayout;
	
	public HomeLayout(FloorPlanMap Home){
		
		this.homeLayout = Home;
		
				
	}
	
	
	public FloorPlanMap getHomeLayout(){
		
		return this.homeLayout;
	}
	
	
}
