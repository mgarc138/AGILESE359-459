package edu.depaul.se359.model;

import java.util.HashMap;
import java.util.Map;

public class Floor {
	
	private Map<Integer, Cell> Cells;
	private int floorLevel;
	private Cell homeCell;
	
	public Floor(int levelInfo){
		
		this.floorLevel = levelInfo;
		// initizialize the hashmap
		// this is where we will store all the cell of the given floor
		// using this type of data structure
		Cells = new HashMap<Integer, Cell>();
		
	}
	
	public Cell getCell(int x, int y){
		
		CoordinatePoint Cell = new CoordinatePoint(x,y);
		
		
		return Cells.get(Cell.hashCode());			
		
	}
	
	public void addCell(Cell C){
		
		Cells.put(C.getCoordinatePointHashCodeKey(),C );
		
	}
	
	public int getLevelFloor(){
		
		return floorLevel;
	}
	
	public int numberOfCells(){
		
		return this.Cells.size();
		
	}
	
	public void setHomeCell(Cell home){
		
		this.homeCell = home;
	}
	
	public void setCells(Map<Integer, Cell> Cells){
		
		this.Cells = Cells;
		
	}
	
	public Map<Integer, Cell> getCells(){
		
		return this.Cells;
	}
		

}
