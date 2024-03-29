package edu.depaul.se359.model.search;

/**
 * Borrowed from https://github.com/AlmasB/FXGL/blob/master/src/main/java/com/almasb/fxgl/search/AStarNode.java
 */

public class AStarNode {
    private AStarNode parent;
    private int x, y;
    private int gCost, hCost;
    private int nodeValue;

    public AStarNode(int x, int y, int hCost, int value) {
        this.x = x;
        this.y = y;
        this.hCost = hCost;
        this.nodeValue = value;
    }

    public AStarNode getParent() {
        return parent;
    }

    public void setParent(AStarNode parent) {
        this.parent = parent;
    }

    public int getHCost() {
        return hCost;
    }

    public void setHCost(int hCost) {
        this.hCost = hCost;
    }

    public int getGCost() {
        return gCost;
    }

    void setGCost(int gCost) {
        this.gCost = gCost;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getNodeValue() {
        return nodeValue;
    }

    public void setNodeValue(int nodeValue) {
        this.nodeValue = nodeValue;
    }

    public int getFCost() {
        return gCost + hCost;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")" + " G:" + gCost + " H:" + hCost + "\n"
                + " NodeValue:" + nodeValue + " Parent:" + (parent == null ? "null" : "(" + parent.x + "," + parent.y + ")");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AStarNode aStarNode = (AStarNode) o;

        if (x != aStarNode.x) return false;
        if (y != aStarNode.y) return false;
        if (gCost != aStarNode.gCost) return false;
        if (hCost != aStarNode.hCost) return false;
        if (nodeValue != aStarNode.nodeValue) return false;
        return !(parent != null ? !parent.equals(aStarNode.parent) : aStarNode.parent != null);

    }

    @Override
    public int hashCode() {
        int result = parent != null ? parent.hashCode() : 0;
        result = 31 * result + x;
        result = 31 * result + y;
        result = 31 * result + gCost;
        result = 31 * result + hCost;
        result = 31 * result + nodeValue;
        return result;
    }
}
