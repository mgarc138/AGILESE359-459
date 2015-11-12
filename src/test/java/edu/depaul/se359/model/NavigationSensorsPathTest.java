package edu.depaul.se359.model;

import edu.depaul.se359.model.search.AStarNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eric on 11/12/15.
 */
public class NavigationSensorsPathTest {

    @Test
    public void testAddCellToPath() throws Exception {
        NavigationSensorsPath.getInstance().setGridSize(2, 2);

        /**
         * @param pathable | 0 = pathable & 1 = obstacle
         */
        NavigationSensorsPath.getInstance().addCellToPath(0, 0, 0);
        NavigationSensorsPath.getInstance().addCellToPath(1, 0, 0);
        NavigationSensorsPath.getInstance().addCellToPath(0, 1, 1);
        NavigationSensorsPath.getInstance().addCellToPath(1, 1, 1);

        /**
         * This is the path that it should generate
         */
        List<AStarNode> aStarNodeList = new ArrayList<>();
        AStarNode testNode = new AStarNode(1, 0, 0, 0);
        testNode.setParent(new AStarNode(0, 0, 0, 0));
        aStarNodeList.add(testNode);

        /**
         * Check the actual result with the expected result
         */
        Assert.assertEquals(NavigationSensorsPath.getInstance().pathToTarget(new Cell(0, 0), new Cell(1, 0)), aStarNodeList);
    }
}