package edu.depaul.se359.sensor;

import edu.depaul.se359.model.Cell;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by eric on 10/23/15.
 */
public class DirtDetectorTest extends TestCase {

    @Test
    public void testIsDirty() throws Exception {
        /**
         * The only thing we care about is the dirt value
         */
        int xPosition = 1, yPosition = 1, rightPath = 1, leftPath = 1, upPath = 1, downPath = 1;

        Cell cell = new Cell(xPosition, yPosition, rightPath, leftPath, upPath, downPath, false, 2, 1);

        // Test the cell when it has a value of 2, should return true.
        assertTrue(DirtDetector.isDirty(cell));

        // Test when the cell is not dirty, should return false.
        cell.setDirt(0);
        assertFalse(DirtDetector.isDirty(cell));
    }
}