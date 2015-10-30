package edu.depaul.se359.service;

import edu.depaul.se359.model.HomeLayoutPlanMap;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

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
        HomeLayoutPlanMap homeLayoutPlanMap = LayoutParser.parseHomeLayout("./FloorPlans/FloorPlanLayoutHome2.json");

        // Check if Object is null
        assertNotNull(homeLayoutPlanMap);
        assertNotNull(homeLayoutPlanMap.getHomeLayout());

        // Check if child objects are initialized properly

        /**
         * Check to make sure our layout has at least one floor
         */
        assertFalse(homeLayoutPlanMap.getHomeLayout().getFloors().isEmpty());
    }
}