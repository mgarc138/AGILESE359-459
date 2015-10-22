package edu.depaul.se359.model;
import java.util.Map;
import java.util.HashMap;
import java.util.List;



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
		
		
	}
	
	
	
	
	
	

}
