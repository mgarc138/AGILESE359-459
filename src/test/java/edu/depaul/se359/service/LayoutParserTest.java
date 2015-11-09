package edu.depaul.se359.service;

import edu.depaul.se359.model.HomeLayoutPlanMap;
import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.*;

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
        try {
            InputStream file = getClass().getResourceAsStream("/FloorPlans/FloorPlanLayoutHome2.json");

            HomeLayoutPlanMap homeLayoutPlanMap = LayoutParser.parseHomeLayout(
                    file
            );

            // Check if Object is null
            assertNotNull(homeLayoutPlanMap);
            assertNotNull(homeLayoutPlanMap.getHomeLayout());

            // Check if child objects are initialized properly

            /**
             * Check to make sure our layout has at least one floor
             */
            assertFalse(homeLayoutPlanMap.getHomeLayout().getFloors().isEmpty());

        } catch (NullPointerException e) {
            e.printStackTrace();
            fail("File resulted in Null Pointer");
        }
    }
}