package edu.depaul.se359.sensor;

import edu.depaul.se359.model.Battery;
import edu.depaul.se359.model.Cell;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by Marlon on 04/11/2015
 * Battery Testing
 */

public class BatteryTest extends TestCase {

	@Test
    public void testBattery() throws Exception {
		
		// battery base
		int xPosition = 0, yPosition = 0, rightPath = 4, leftPath = 4, upPath = 4, downPath = 4;
        int surface = 1;
        Cell cellA = new Cell(xPosition, yPosition, rightPath, leftPath, upPath, downPath, false, 2, surface);
		
        Battery bat = new Battery(cellA);
        
        assertTrue(100 == bat.getBatteryLevel());
        
	}
	
	@Test
    public void testBatteryDecrementation() throws Exception {
		
		// battery base
		int xPosition = 0, yPosition = 0, rightPath = 4, leftPath = 4, upPath = 4, downPath = 4;
        int surface = 1;
        Cell cellHome = new Cell(xPosition, yPosition, rightPath, leftPath, upPath, downPath, false, 2, surface);
		
        Battery bat = new Battery(cellHome);
        
        assertTrue(100 == bat.getBatteryLevel());
        
        int xPositionA = 1, yPositionA = 1, rightPathA = 4, leftPathA = 4, upPathA = 4, downPathA = 4;
        int surfaceA = 2;
        Cell cellA = new Cell(xPositionA, yPositionA, rightPathA, leftPathA, upPathA, downPathA, false, 2, surfaceA);


        int xPositionB = 1, yPositionB = 2, rightPathB = 2, leftPathB = 2, upPathB = 2, downPathB = 2;
        int surfaceB = 2;
        Cell cellB = new Cell(xPositionB, yPositionB, rightPathB, leftPathB, upPathB, downPathB, false, 2, surfaceB);

        
        bat.setDecrementBatteryLevel(cellA, cellB);
        
        assertTrue(98 == bat.getBatteryLevel());
        
        
	}
	

    @Test
    public void testBatteryWeightBareFloorCells() throws Exception {

        int xPosition = 0, yPosition = 0, rightPath = 4, leftPath = 4, upPath = 4, downPath = 4;
        int surface = 1;
        Cell cellA = new Cell(xPosition, yPosition, rightPath, leftPath, upPath, downPath, false, 2, surface);


        int xPositionB = 2, yPositionB = 2, rightPathB = 2, leftPathB = 2, upPathB = 2, downPathB = 2;
        int surfaceB = 1;
        Cell cellB = new Cell(xPositionB, yPositionB, rightPathB, leftPathB, upPathB, downPathB, false, 2, surfaceB);


        assertTrue(1 == Battery.calculateWeightUnits(cellA, cellB));

    }

    @Test
    public void testBatteryWeightLowPileCells() throws Exception {

        int xPosition = 0, yPosition = 0, rightPath = 4, leftPath = 4, upPath = 4, downPath = 4;
        int surface = 2;
        Cell cellA = new Cell(xPosition, yPosition, rightPath, leftPath, upPath, downPath, false, 2, surface);


        int xPositionB = 2, yPositionB = 2, rightPathB = 2, leftPathB = 2, upPathB = 2, downPathB = 2;
        int surfaceB = 2;
        Cell cellB = new Cell(xPositionB, yPositionB, rightPathB, leftPathB, upPathB, downPathB, false, 2, surfaceB);


        assertTrue(2 == Battery.calculateWeightUnits(cellA, cellB));

    }

    @Test
    public void testBatteryWeightHighPileCarpetCells() throws Exception {

        int xPosition = 0, yPosition = 0, rightPath = 4, leftPath = 4, upPath = 4, downPath = 4;
        int surface = 3;
        Cell cellA = new Cell(xPosition, yPosition, rightPath, leftPath, upPath, downPath, false, 2, surface);


        int xPositionB = 2, yPositionB = 2, rightPathB = 2, leftPathB = 2, upPathB = 2, downPathB = 2;
        int surfaceB = 3;
        Cell cellB = new Cell(xPositionB, yPositionB, rightPathB, leftPathB, upPathB, downPathB, false, 2, surfaceB);


        assertTrue(3 == Battery.calculateWeightUnits(cellA, cellB));

    }

    @Test
    public void testBatteryWeightFromBareFloorToLowPile() throws Exception {

        int xPosition = 0, yPosition = 0, rightPath = 4, leftPath = 4, upPath = 4, downPath = 4;
        int surface = 1;
        Cell cellA = new Cell(xPosition, yPosition, rightPath, leftPath, upPath, downPath, false, 2, surface);


        int xPositionB = 2, yPositionB = 2, rightPathB = 2, leftPathB = 2, upPathB = 2, downPathB = 2;
        int surfaceB = 2;
        Cell cellB = new Cell(xPositionB, yPositionB, rightPathB, leftPathB, upPathB, downPathB, false, 2, surfaceB);


        assertTrue(1.5 == Battery.calculateWeightUnits(cellA, cellB));

    }

    @Test
    public void testBatteryWeightFromLowPileToPileCarpetCells() throws Exception {

        int xPosition = 0, yPosition = 0, rightPath = 4, leftPath = 4, upPath = 4, downPath = 4;
        int surface = 2;
        Cell cellA = new Cell(xPosition, yPosition, rightPath, leftPath, upPath, downPath, false, 2, surface);


        int xPositionB = 2, yPositionB = 2, rightPathB = 2, leftPathB = 2, upPathB = 2, downPathB = 2;
        int surfaceB = 3;
        Cell cellB = new Cell(xPositionB, yPositionB, rightPathB, leftPathB, upPathB, downPathB, false, 2, surfaceB);


        assertTrue(2.5 == Battery.calculateWeightUnits(cellA, cellB));

    }

    @Test
    public void testBatteryWeightFromBareFloorToPileCarpetCells() throws Exception {

        int xPosition = 0, yPosition = 0, rightPath = 4, leftPath = 4, upPath = 4, downPath = 4;
        int surface = 1;
        Cell cellA = new Cell(xPosition, yPosition, rightPath, leftPath, upPath, downPath, false, 2, surface);


        int xPositionB = 2, yPositionB = 2, rightPathB = 2, leftPathB = 2, upPathB = 2, downPathB = 2;
        int surfaceB = 3;
        Cell cellB = new Cell(xPositionB, yPositionB, rightPathB, leftPathB, upPathB, downPathB, false, 2, surfaceB);


        assertTrue(2 == Battery.calculateWeightUnits(cellA, cellB));

    }


}
