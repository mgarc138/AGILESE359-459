package edu.depaul.se359.sensor;
import edu.depaul.se359.model.*;

public class Vertex implements Comparable {
	
	Cell cell;
	Vertex[] neighbors;
	Vertex parent;
	double sourceDistance;
	
	public Vertex(Cell cell){
		
		this.cell = cell;
		// index 0 is up, 1 is down, 2 left, 3 right
		this.neighbors = new Vertex[4];
		// the source is infinity we don't know what is the distance yet
		this.sourceDistance = Double.POSITIVE_INFINITY;
		this.parent = null;
				
	}
	
	public void setParent(Vertex vertex){
		
		this.parent = vertex;
	}
	
	public Vertex getParent(){
		
		return this.parent;
	}
	
	
	public void setNeighbor(int index, Vertex neighbor){
		
			this.neighbors[index] = neighbor;
	}
	
	public Vertex[] getAllNeighbors(){
		
		return this.neighbors;
	}
	
	public Cell getCell(){
		
		return this.cell;
	}
	
	
	public void setSourceDistance(double d){
		
		this.sourceDistance = d;
	}
	
	public double getSourceDistance(){
		
		return this.sourceDistance;
	}
	
	
	public String toString() {
		
		String result = "Cell : (" + this.cell.getX() + " , " + this.cell.getY() + ")";
		
		return result;
		
	}
	
	
	
	
	
	public boolean sameAs(Vertex v) {
		
		if ((this.getCell().getX() == v.getCell().getX()) && (this.getCell().getY() == v.getCell().getY())){
			return true;
		}
		return false;
	}

	
	
	
public int compareTo(Object obj) {
	
	Vertex temp = (Vertex) obj;

	if(this.sourceDistance > temp.sourceDistance){
			
			return 1;
		}
		
		else if (this.sourceDistance < temp.sourceDistance){
			
			return -1;
		}
		
		else {
			
			return 0;
		}
		
	}
	
	

}
