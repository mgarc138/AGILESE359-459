package edu.depaul.se359.service;

import edu.depaul.se359.model.HomeLayoutList;
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
        HomeLayoutList homeLayoutList = LayoutParser.parseHomeLayout("./FloorPlans/FloorPlanLayoutHome1.json");

        // Check if Object is null
        assertNotNull(homeLayoutList);
        // Check if child objects are initialized properly

        assertTrue(!homeLayoutList.getHomeLayout().get(0).getCells().isEmpty());
        assertTrue(homeLayoutList.getHomeLayout().get(0).getCells().get(0).getPoint().getX() == 0);
    }
}