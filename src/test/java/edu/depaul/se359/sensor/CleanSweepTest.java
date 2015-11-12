package edu.depaul.se359.sensor;

import edu.depaul.se359.model.*;
import edu.depaul.se359.service.LayoutParser;
import junit.framework.TestCase;
import org.junit.Test;

public class CleanSweepTest extends TestCase {

    @Test
    public void testCleanSweep() throws Exception {

        HomeLayoutPlanMap layouts = LayoutParser.parseHomeLayout(getClass().getResourceAsStream("/FloorPlans/FloorPlanLayoutHome2.json"));

        Cell chargeStation = null;
        for (Floor floor : layouts.getHomeLayout().getFloors()) {
            for (Room room : floor.getRooms()) {
                for (Cell cell : room.getCells()) {
                    if (cell.CheckisaChargingStation()) {
                        chargeStation = cell;
                    }
                }
            }
        }

        // Make sure there is at least one charge station / Home Cell
        assertNotNull(chargeStation);

        CleanSweep cleanSweep = new CleanSweep(chargeStation, layouts.getHomeLayout());

        assertTrue(0 == cleanSweep.getCurrentPosition().getX());
        assertTrue(0 == cleanSweep.getCurrentPosition().getY());
    }
}
