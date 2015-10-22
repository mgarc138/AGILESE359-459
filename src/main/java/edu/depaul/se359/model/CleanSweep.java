package edu.depaul.se359.model;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;


public class CleanSweep {
	
	private Cell CurrentCell;
	private Cell HomeCell;
	private UtilityContainer DirtAnalizer;
	private Map<Integer, Cell> HouseMap;
	private List<Cell> VisitedCells;
	private List<Cell> NotVisitedCells;
	
	public CleanSweep(Cell homeCell){
		
		this.HomeCell = homeCell;
		this.CurrentCell = homeCell;
		
		this.DirtAnalizer = new UtilityContainer();
		HouseMap = new HashMap<Integer, Cell>();
		this.VisitedCells = new ArrayList<Cell>();
		this.NotVisitedCells = new ArrayList<Cell>();
		
	}
	
	public Map<Integer, Cell> addingCellsToHouseMap(Map<Integer, Cell> houseMap){
		
		Integer CellCount = this.HouseMap.size();
		
		if(this.HouseMap.containsValue(this.CurrentCell)){
			
			// it contains a value of the current cell don't added 
			
		}
		
		else {
			// note A map maps a key to a value. If you have a value and you know the map contains this value, why do you need the key anymore
			// if it doesn't contain add it 
			
			this.HouseMap.put(CellCount, this.CurrentCell);
				
		}
		
		//to continue later
	
		return this.HouseMap;
		
	}
	
	
	
	
	
	

}
