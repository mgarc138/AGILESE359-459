package edu.depaul.se359.sensor;

import edu.depaul.se359.model.Cell;
import edu.depaul.se359.model.CleanSweep;
import edu.depaul.se359.model.HomeLayoutPlanMap;
import edu.depaul.se359.service.LayoutParser;
import junit.framework.TestCase;
import org.junit.Test;

public class CleanSweepTest extends TestCase {

    private HomeLayoutPlanMap layouts;

    @Test
    public void testCleanSweep() throws Exception {

        layouts = LayoutParser.parseHomeLayout(getClass().getResourceAsStream("/FloorPlans/FloorPlanLayoutHome2.json"));

        int xPosition = 0, yPosition = 0, rightPath = 4, leftPath = 4, upPath = 4, downPath = 4;

        Cell chargeStation = new Cell(xPosition, yPosition, rightPath, leftPath, upPath, downPath, false, 2, 1);

        CleanSweep cleanSweep = new CleanSweep(chargeStation, layouts.getHomeLayout());

        assertTrue(0 == cleanSweep.getCurrentPosition().getX());
        assertTrue(0 == cleanSweep.getCurrentPosition().getY());

    }
}
