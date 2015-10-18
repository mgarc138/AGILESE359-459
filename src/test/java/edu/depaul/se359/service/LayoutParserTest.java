package edu.depaul.se359.service;

import edu.depaul.se359.model.HomeLayoutPlanMap;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by eric on 10/12/15.
 */
public class LayoutParserTest {

    /**
     * Note: Could probably be tested better
     *
     * @throws Exception
     */
    @Test
    public void testParseHomeLayout() throws Exception {
        HomeLayoutPlanMap homeLayoutPlanMap = LayoutParser.parseHomeLayout("./FloorPlans/FloorPlanLayoutHome1.json");

        // Check if Object is null
        assertNotNull(homeLayoutPlanMap);

        // Check if child objects are initialized properly
        assertTrue(!homeLayoutPlanMap.getHomeLayout().get(0).getCells().isEmpty());
        assertTrue(homeLayoutPlanMap.getFloor("roomA").getId().equals("roomA"));
    }
}