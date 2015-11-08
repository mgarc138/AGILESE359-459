package edu.depaul.se359.sensor;

import edu.depaul.se359.model.Cell;
import junit.framework.TestCase;

import org.junit.Test;

/**
 * Created by Marlon on 04/11/2015
 * Cell Testing 
 */
public class CellTest extends TestCase {
	
	@Test
    public void testCellNeighborsAreStairs() throws Exception {
		
		 int xPosition = 0, yPosition = 0, rightPath = 4, leftPath = 4, upPath = 4, downPath = 4;
		
		 Cell cell = new Cell(xPosition, yPosition, rightPath, leftPath, upPath, downPath, false, 2, 1);
		 
		 assertTrue(DirtDetector.isCellStair(cell.getLeft()));
		 assertTrue(DirtDetector.isCellStair(cell.getRight()));
		 assertTrue(DirtDetector.isCellStair(cell.getUp()));
		 assertTrue(DirtDetector.isCellStair(cell.getDown()));
		 	 
	}
	
	
	@Test
    public void testCellNeighborsAreObstacle() throws Exception {
		
		 int xPosition = 0, yPosition = 0, rightPath = 3, leftPath = 3, upPath = 3, downPath = 3;
		
		 Cell cell = new Cell(xPosition, yPosition, rightPath, leftPath, upPath, downPath, false, 2, 1);
		 
		 assertTrue(DirtDetector.isCellObstacle(cell.getLeft()));
		 assertTrue(DirtDetector.isCellObstacle(cell.getRight()));
		 assertTrue(DirtDetector.isCellObstacle(cell.getUp()));
		 assertTrue(DirtDetector.isCellObstacle(cell.getDown()));
		 	 
	}
	
	@Test
    public void testCellNeighborsAreOpen() throws Exception {
		
		 int xPosition = 2, yPosition = 2, rightPath = 2, leftPath = 2, upPath = 2, downPath = 2;
		
		 Cell cell = new Cell(xPosition, yPosition, rightPath, leftPath, upPath, downPath, false, 2, 1);
		 
		 assertTrue(DirtDetector.isCellOpen(cell.getLeft()));
		 assertTrue(DirtDetector.isCellOpen(cell.getRight()));
		 assertTrue(DirtDetector.isCellOpen(cell.getUp()));
		 assertTrue(DirtDetector.isCellOpen(cell.getDown()));
		 	 
	}
	
	@Test
    public void testCellNeighborsAreUnknown() throws Exception {
		
		 int xPosition = 2, yPosition = 2, rightPath = 1, leftPath = 1, upPath = 1, downPath = 1;
		
		 Cell cell = new Cell(xPosition, yPosition, rightPath, leftPath, upPath, downPath, false, 2, 1);
		 
		 assertTrue(DirtDetector.isCellUnkown(cell.getLeft()));
		 assertTrue(DirtDetector.isCellUnkown(cell.getRight()));
		 assertTrue(DirtDetector.isCellUnkown(cell.getUp()));
		 assertTrue(DirtDetector.isCellUnkown(cell.getDown()));
		 	 
	}
	
	@Test
    public void testCellSurfaceBareFloor() throws Exception {
		
		 int xPosition = 4, yPosition = 3, rightPath = 1, leftPath = 1, upPath = 1, downPath = 1;
		 int surface = 1;
		
		 Cell cell = new Cell(xPosition, yPosition, rightPath, leftPath, upPath, downPath, false, 2, surface);
		 
		 assertTrue(DirtDetector.isCellSurfaceBareFloor(cell.getSurface()));
		 
		 	 
	}
	
	
	@Test
    public void testCellSurfaceLowPile() throws Exception {
		
		 int xPosition = 4, yPosition = 3, rightPath = 1, leftPath = 1, upPath = 1, downPath = 1;
		 int surface = 2;
		
		 Cell cell = new Cell(xPosition, yPosition, rightPath, leftPath, upPath, downPath, false, 2, surface);
		 
		 assertTrue(DirtDetector.isCellSurfaceLowPile(cell.getSurface()));
		 
		 	 
	}
	
	
	@Test
    public void testCellSurfaceHighPileCarpet() throws Exception {
		
		 int xPosition = 4, yPosition = 3, rightPath = 1, leftPath = 1, upPath = 1, downPath = 1;
		 int surface = 3;
		
		 Cell cell = new Cell(xPosition, yPosition, rightPath, leftPath, upPath, downPath, false, 2, surface);
		 
		 assertTrue(DirtDetector.isCellSurfaceHighPileCarpet(cell.getSurface()));
		 
		 	 
	}
	

}
