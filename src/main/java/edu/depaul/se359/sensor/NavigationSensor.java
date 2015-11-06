package edu.depaul.se359.sensor;

import edu.depaul.se359.model.search.AStarLogic;
import edu.depaul.se359.model.search.AStarNode;

import java.util.List;

/**
 * Created by eric on 11/5/15.
 */
public class NavigationSensor {
    private static NavigationSensor ourInstance = new NavigationSensor();
    private AStarNode[][] aiGrid;
    private AStarLogic ai = new AStarLogic();
    private AStarNode start, target;

    private NavigationSensor() {

    }

    public static NavigationSensor getInstance() {
        return ourInstance;
    }

    public void setGridSize(int x, int y) {
        aiGrid = new AStarNode[x][y];
    }

    public List<AStarNode> pathToTarget(int x1, int y1, int x2, int y2) {
        if (aiGrid == null) {
            throw new IllegalStateException("You need to set the grid size first and add nodes to it.");
        }

        // AStar to Charge
        start = aiGrid[x1][y1];
        target = aiGrid[x2][y2];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 6; j++) {
                aiGrid[j][i].setHCost(Math.abs(target.getX() - i) + Math.abs(target.getY() - j));
            }
        }

        return ai.getPath(aiGrid, start, target);
    }

    public void addCellToPath(int x, int y, int pathable) {

        aiGrid[x][y] = new AStarNode(x, y, 0, pathable);
        System.out.println(aiGrid[x][y]);
    }
}
