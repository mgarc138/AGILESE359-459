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
