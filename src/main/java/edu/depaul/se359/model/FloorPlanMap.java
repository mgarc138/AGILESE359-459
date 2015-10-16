package edu.depaul.se359.model;
import java.util.List;
import java.util.ArrayList;

/**
 * 
 * @author marlon garcia
 *
 */

public class FloorPlanMap {

	private List<Floor> floorsCollection;
	
	/**
	 * It instantiate a collection of floors
	 */
	public FloorPlanMap(){
		
		this.floorsCollection = new ArrayList<Floor>();
	
	}
	
	/**
	 * it returns the number of floors that a HomeLayout can have
	 * @return Integer
	 */
	public int numberOfCollectionOfFloors(){
		
		return this.floorsCollection.size();		
	}
	
	/**
	 * It adds a new floor in the collection of floors to form a homeLayout
	 * 
	 * @param F
	 */
	public void addFloor(Floor F){
		
		this.floorsCollection.add(F);
		
	}
	
	
	/**
	 * It gets an specific floor from the collection of Floors that make a HomeLayout
	 * 
	 * @param floorNumber
	 * @return Floor
	 */
	public Floor getFloor(int floorNumber){
		
		return this.floorsCollection.get(floorNumber);
		
	}
	
	/**
	 * it returns the entire collection of floors that make a home layout
	 * 
	 * @return List<Floor>
	 */
	public List<Floor> getCollectionOfFloors(){
		
		return this.floorsCollection;
	}	
}
