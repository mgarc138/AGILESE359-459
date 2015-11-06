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
}
