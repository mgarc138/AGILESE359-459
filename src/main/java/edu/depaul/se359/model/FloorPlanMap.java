package edu.depaul.se359.model;
import java.util.List;
import java.util.ArrayList;


public class FloorPlanMap {

	private List<Floor> floorsCollection;
	
	public FloorPlanMap(){
		//instatiate the storage of our collections of floors
		
		this.floorsCollection = new ArrayList<Floor>();
	
	}
	
	
	public int numberOfCollectionOfFloors(){
		
		return this.floorsCollection.size();
		
	}
	
	public void addFloor(Floor F){
		
		this.floorsCollection.add(F);
		
	}
	
	
	
	public Floor getFloor(int floorNumber){
		
		return this.floorsCollection.get(floorNumber);
		
	}
	
	
	public List<Floor> getCollectionOfFloors(){
		
		return this.floorsCollection;
	}	
}
