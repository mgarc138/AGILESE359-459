package edu.depaul.se359.model;

import java.util.HashMap;
import java.util.Map;

public class Floor {
	
	private Map<Integer, Cell> Cells;
	private int floorLevel;
	private Cell homeCell;
	
	/**
	 * It initialize and sets the level of the given floor 
	 * It initialize a data structure to save all the cells that belong to the given floor
	 * @param levelInfo
	 */
	public Floor(int levelInfo){	
		this.floorLevel = levelInfo;
		
		Cells = new HashMap<Integer, Cell>();		
	}
	
	/**
	 * gets back the a Cell by given what are their x and y coordinates
	 * The cell asked is retrieved from a HashMap
	 * @param x
	 * @param y
	 * @return Cell
	 */
	public Cell getCell(int x, int y){
		
		CoordinatePoint Cell = new CoordinatePoint(x,y);
		
		return Cells.get(Cell.hashCode());			
		
	}
	
	
	/**
	 * Stores a Cells in order to create a floor level
	 * The Cell contains a unique Hash Code Id key in order to be retrieved in the future
	 * @param C
	 */
	public void addCell(Cell C){
		
		Cells.put(C.getCoordinatePointHashCodeKey(),C );
		
	}
	
	/**
	 * returns the level floor number that it was store when the object was initialize 
	 * 
	 * @return Integer
	 */
	public int getLevelFloor(){
		
		return floorLevel;
	}
	
	/**
	 * return the size of the HashMap
	 * In other words, it returns the number of Cells that make that particular floor
	 * 
	 * @return Integer
	 */
	public int numberOfCells(){
		
		return this.Cells.size();
		
	}
	
	/**
	 * Sets the Cell of the home of the Clean Sweep
	 * 
	 * @param home
	 */
	public void setHomeCell(Cell home){
		
		this.homeCell = home;
	}
	
	/**
	 * Sets a collection of Cells that makes a floor
	 * 
	 * @param Cells
	 */
	public void setCells(Map<Integer, Cell> Cells){
		
		this.Cells = Cells;
		
	}
	
	/**
	 * It return all the Cells that makes the floor
	 * 
	 * @return HashMap
	 */
	public Map<Integer, Cell> getCells(){
		
		return this.Cells;
	}
		

}
