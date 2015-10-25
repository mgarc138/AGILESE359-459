package edu.depaul.se359.sensor;

import edu.depaul.se359.model.*;

public class Edge {
	
	Vertex startingVertexPoint;
	Vertex endingVertexPoint;
	double weight;
	
	public Edge(Vertex startPoint, Vertex endPoint){
		
		this.startingVertexPoint = startPoint;
		this.endingVertexPoint = endPoint;
		this.weight = Battery.calculateWeightUnits(startPoint.getCell(), endPoint.getCell());
	}
	
	public double getWeight(){
		
		return this.weight;
		
	}
	
	public Vertex getStartingVertex(){
		
		return this.startingVertexPoint;
		
	}
	
	public Vertex getEndingVertex(){
		
		return this.endingVertexPoint;
	}
	
	
	public boolean isEdgeBetween(Vertex VerA, Vertex VerB){
		
		if((this.getStartingVertex().sameAs(VerA) && this.getEndingVertex().sameAs(VerB)) || (this.getStartingVertex().sameAs(VerB) && this.getEndingVertex().sameAs(VerA))){
			
			return true;
		}
		
		return false;
		
	}

}
