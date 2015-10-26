package edu.depaul.se359.sensor;

import edu.depaul.se359.model.Cell;

import java.util.List;
import java.util.PriorityQueue;
import java.util.ArrayList;

public class ShortestDirection {
	
	private Vertex source;
	private Vertex destination;
	
	private List<Vertex> allVertices;
	private List<Edge> allEdges;
	
	private double weightofShortesDirection;
	private List<Cell> shortesDirection;
	private PriorityQueue<Vertex> priorityQueue;
	
	
	public ShortestDirection(Cell source, Cell destination, List<Cell> visitedCells){
		
		//initialization of our data structures
		this.priorityQueue = new PriorityQueue<Vertex>();
		this.shortesDirection = new ArrayList<Cell>();
		this.allEdges = new ArrayList<Edge>();
		this.allVertices = new ArrayList<Vertex>();
		
		this.source = new Vertex(source);
		this.destination = new Vertex(destination);
		
		this.allVertices.add(this.source);
		this.allVertices.add(this.destination);
		
		
		
	}
	
	
	
	

}
