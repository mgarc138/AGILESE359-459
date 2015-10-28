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
		this.weightofShortesDirection = Double.POSITIVE_INFINITY;
		this.priorityQueue = new PriorityQueue<Vertex>();
		this.shortesDirection = new ArrayList<Cell>();
		this.allEdges = new ArrayList<Edge>();
		this.allVertices = new ArrayList<Vertex>();
		
		this.source = new Vertex(source);
		this.destination = new Vertex(destination);
		
		this.allVertices.add(this.source);
		this.allVertices.add(this.destination);
		
		this.setAllVertices(source, destination, visitedCells);
		this.setAllEdges(this.allVertices);
			
		
	}
	
	
	
	private void setAllVertices(Cell source, Cell destination, List<Cell> visitedCells) {
		
		this.source.setSourceDistance(0);
		this.priorityQueue.add(this.source);
		
		if(this.destination.sameAs(this.source)){
			
			// nothing is been done here
			
		}
		
		else {
		
			this.priorityQueue.add(this.destination);

			for (int i = 0; i < visitedCells.size(); i++) {
			
			if (!(visitedCells.get(i).sameCell(source) || visitedCells.get(i).sameCell(destination))) {
				
				boolean CellwasAdded = false;
				for (int j = 0; j < i; j++) {
					
					if (visitedCells.get(i).sameCell(visitedCells.get(j))){
					
						CellwasAdded = true;
					}
				}
				
				if (!CellwasAdded) {
					
					Vertex createVertex = new Vertex(visitedCells.get(i));
					allVertices.add(createVertex);
					this.priorityQueue.add(createVertex);

				}
			}
		}
		}
	}
	
	
	
	private void setAllEdges(List<Vertex> allVertices) {
		
		for (int i = 0; i < allVertices.size(); i++) {
			
			Vertex current = allVertices.get(i);
			int XC = current.getCell().getX();
			int YC = current.getCell().getY();
		
			for (int j = i + 1; j < allVertices.size(); j++) {
				
				Vertex Next = allVertices.get(j);
				
				if (XC == Next.getCell().getX()) {
					
					if ((YC - 1) == Next.getCell().getY()) {
						
						if (current.getCell().getDown() == 2) {
							
							current.setNeighbor(1, Next);
							Next.setNeighbor(0, current);

							
							Edge newEdge = new Edge(current, Next);
							allEdges.add(newEdge);
						}
					}
					if ((YC + 1) == Next.getCell().getY()) {
						
						if (current.getCell().getUp() == 2) {

							
							current.setNeighbor(0, Next);
							Next.setNeighbor(1, current);

							
							Edge newEdge = new Edge(current, Next);
							allEdges.add(newEdge);
						}
					}
				}
				
				if (YC == Next.getCell().getY()) {
					if ((XC - 1) == Next.getCell().getX()) {
						
						if (current.getCell().getLeft() == 2) {

							
							current.setNeighbor(2, Next);
							Next.setNeighbor(3, current);

							
							Edge newEdge = new Edge(current, Next);
							allEdges.add(newEdge);
						}
					}
					if ((XC + 1) == Next.getCell().getX()) {
						
						if (current.getCell().getRight() == 2) {

							
							current.setNeighbor(3, Next);
							Next.setNeighbor(2, current);

							
							Edge newEdge = new Edge(current, Next);
							allEdges.add(newEdge);
						}
					}
				}
			}
		}
	}

	
	private void setShortestDirection() {
		
		List<Vertex> shortestVertexDirection = new ArrayList<Vertex>();

		List<Vertex> Direction = new ArrayList<Vertex>();

		while (!(this.priorityQueue.isEmpty()) && !(Direction.contains(destination))) {
				
			if (this.priorityQueue.peek() != null) {
				
				Vertex getVertex = this.priorityQueue.poll();
				Direction.add(getVertex); 
				Vertex[] getAllNeighbors = getVertex.getAllNeighbors();
				for (int i = 0; i < 4; i++) {
					
					Vertex neighbor = getAllNeighbors[i];
					
					if (neighbor != null) {
						
						double sumOfDistances = getVertex.getSourceDistance() + getWeightOfEdge(getVertex, neighbor);
						
						if (neighbor.getSourceDistance() > sumOfDistances) {
							
							this.priorityQueue.remove(neighbor);
							neighbor.setParent(getVertex);
							neighbor.setSourceDistance(sumOfDistances);
							this.priorityQueue.add(neighbor);
						}
					}
				}
			}
		}
			
		}
		
		
		private double getWeightOfEdge(Vertex vertexA, Vertex vertexB) {
			Edge getEdge;
			for (int i = 0; i < allEdges.size(); i++) {
				if (allEdges.get(i).isEdgeBetween(vertexA, vertexB)) {
					getEdge = allEdges.get(i);
					return getEdge.getWeight();

				}
			}
			return Double.POSITIVE_INFINITY;
		}
	
	

}
