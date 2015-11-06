package edu.depaul.se359.model.search;

import edu.depaul.se359.model.LogFile;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

/**
 * Borrowed from: https://github.com/AlmasB/FXGL/blob/master/src/main/java/com/almasb/fxgl/search/AStarLogic.java
 */
public final class AStarLogic {
    /**
     * Since the equality check is based on references
     * start and target must be elements of the array.
     *
     * @param grid      the grid of nodes
     * @param start     starting node
     * @param target    target node
     * @param busyNodes busy "unwalkable" nodes
     * @return path as list of nodes from start to target or empty list if no path found
     */
    public List<AStarNode> getPath(AStarNode[][] grid, AStarNode start, AStarNode target, AStarNode... busyNodes) {
        if (target.getNodeValue() == 1) // the target is an unwalkable node
            return new ArrayList<>();  // return empty path

        List<AStarNode> open = new ArrayList<>();
        List<AStarNode> closed = new ArrayList<>();
        List<AStarNode> path = new ArrayList<>();

        AStarNode current = start;

        boolean found = false;

        while (!found && !closed.contains(target)) {
            AStarNode[] neighbors = getNeighbors(current, grid, busyNodes);

            for (AStarNode neighbor : neighbors) {
                if (neighbor == target) {
                    target.setParent(current);
                    found = true;
                    closed.add(target);
                    break;
                }

                if (!closed.contains(neighbor)) {
                    if (open.contains(neighbor)) {
                        int newG = current.getGCost() + 10;

                        if (newG < neighbor.getGCost()) {
                            neighbor.setParent(current);
                            neighbor.setGCost(newG);
                        }
                    } else {
                        neighbor.setParent(current);
                        neighbor.setGCost(current.getGCost() + 10);
                        open.add(neighbor);
                    }
                }
            }

            if (!found) {
                closed.add(current);
                open.remove(current);
                current = getSmallest(open);
                if (current == null)
                    return new ArrayList<>();
            }
        }

        AStarNode tmp = target;
        path.add(tmp);
        while (!path.contains(start)) {
            tmp = tmp.getParent();
            if (tmp == start)
                break;
            path.add(tmp);
        }

        closed.clear();

        for (int i = path.size() - 1; i >= 0; i--)
            closed.add(path.get(i));

        return closed;
    }

    public AStarNode getSmallest(List<AStarNode> open) {
        if (open.size() == 0) {
            LogFile.getInstance().writeLogFile(Level.WARNING, "No path found");
            return null;
        }

        AStarNode min = open.get(0);

        for (AStarNode n : open)
            if (n.getFCost() < min.getFCost())
                min = n;

        return min;
    }

    public AStarNode[] getNeighbors(AStarNode n, AStarNode[][] grid, AStarNode... busyNodes) {
        int x = n.getX();
        int y = n.getY();
        int x1 = x - 1;
        int x2 = x + 1;
        int y1 = y - 1;
        int y2 = y + 1;

        boolean b1 = x1 >= 0 && grid[x1][y].getNodeValue() != 1 && !contains(x1, y, busyNodes);
        boolean b2 = x2 < grid.length && grid[x2][y].getNodeValue() != 1 && !contains(x2, y, busyNodes);
        boolean b3 = y1 >= 0 && grid[x][y1].getNodeValue() != 1 && !contains(x, y1, busyNodes);
        boolean b4 = y2 < grid[0].length && grid[x][y2].getNodeValue() != 1 && !contains(x, y2, busyNodes);

        int count = 0;
        if (b1)
            count++;
        if (b2)
            count++;
        if (b3)
            count++;
        if (b4)
            count++;

        AStarNode[] res = new AStarNode[count];
        int i = 0;

        if (b1)
            res[i++] = grid[x1][y];

        if (b2)
            res[i++] = grid[x2][y];

        if (b3)
            res[i++] = grid[x][y1];

        if (b4)
            res[i++] = grid[x][y2];

        return res;
    }

    private boolean contains(int x, int y, AStarNode... nodes) {
        for (AStarNode n : nodes)
            if (n.getX() == x && n.getY() == y)
                return true;

        return false;
    }
}
