package edu.depaul.se359.model;

/**
 * Created on 10/10/15.
 * Class: Cell.java
 * Author: eric
 * Assignment: SE459
 */
public class Cell {

    private CoordinatePoint point;
    private int right;
    private int left;
    private int up;
    private int down;
    private int charge;
    private int dirt;
    private int surface;
    private Cell rightCell;
    private Cell leftCell;
    private Cell upperCell;
    private Cell lowerCell;

    public Cell(int xPosition, int yPosition, int rightPath, int leftPath, int upPath, int downPath, int charge, int dirt, int surface) {

        point = new CoordinatePoint(xPosition, yPosition);

        setRight(rightPath);
        setLeft(leftPath);
        setUp(upPath);
        setDown(downPath);
        setCharge(charge);
        setDirt(dirt);
        setSurface(surface);
    }

    public CoordinatePoint getPoint() {
        return point;
    }

    public void setPoint(CoordinatePoint point) {
        this.point = point;
    }
    
    public int getX(){
    	
    	return this.point.x;
    }
    
    public int getY(){
    	
    	return this.point.y;
    	
    }
    
    /*
     * @returns three types of surfaces
     * 1. bare floor
     * 2. low-pile
     * 3. High-pile carpet
     */
    public int getSurface() {
    	return surface;
    }
    
    /*
     * sets three types of surfaces
     * 1. bare floor
     * 2. low-pile
     * 3. High-pile carpet
     * @param surface
     */
    public void setSurface(int surface) {
        this.surface = surface;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "point=" + point +
                ", right=" + right +
                ", left=" + left +
                ", up=" + up +
                ", down=" + down +
                ", charge=" + getCharge() +
                ", dirt=" + getDirt() +
                ", surface=" + surface +
                '}';
    }

    /*
     * @return the path of the right Cell of this current cell
     * 1. unknown
     * 2. it is open
     * 3. there is an obstacle
     * 4. there is a stairs
     */
    
    public int getRight() {
        return right;
    }

    /*
     * Sets the path of the right Cell of this current cell
     * 1. unknown
     * 2. it is open
     * 3. there is an obstacle
     * 4. there is a stairs
     * @param right
     */
    
    public void setRight(int right) {

        if (right > 4) {

            // exception
        }

        if (right < 1) {

            // exception
        }

        this.right = right;
    }

    
    /*
     * @return the path of the left Cell of this current cell
     * 1. unknown
     * 2. it is open
     * 3. there is an obstacle
     * 4. there is a stairs
     */
    public int getLeft() {
        return left;
    }

    
    /*
     * Sets the path of the left Cell of this current cell
     * 1. unknown
     * 2. it is open
     * 3. there is an obstacle
     * 4. there is a stairs
     * @param left
     */
    public void setLeft(int left) {

        if (left > 4) {

            // exception
        }

        if (left < 1) {

            // exception
        }

        this.left = left;
    }

    
    /*
     * @return the path of the above Cell of this current cell
     * 1. unknown
     * 2. it is open
     * 3. there is an obstacle
     * 4. there is a stairs
     */
    public int getUp() {
        return up;
    }

    /*
     * Sets the path of the above Cell of this current cell
     * 1. unknown
     * 2. it is open
     * 3. there is an obstacle
     * 4. there is a stairs
     * @param up
     */
    public void setUp(int up) {

        if (up > 4) {

            //exception
        }

        if (up < 0) {

            // exception
        }

        this.up = up;
    }

    
    /*
    * @return the path of the below Cell of this current cell
    * 1. unknown
    * 2. it is open
    * 3. there is an obstacle
    * 4. there is a stairs
    */
    public int getDown() {
        return down;
    }

    /*
     * Sets the path of the below Cell of this current cell
     * 1. unknown
     * 2. it is open
     * 3. there is an obstacle
     * 4. there is a stairs
     * @param down
     */
    public void setDown(int down) {


        if (up > 4) {

            // exception
        }

        if (up < 0) {

            // exception
        }

        this.down = down;
    }

   
    
    public boolean getCharge() {
        return charge == 1;
    }

    public void setCharge(int charge) {
        if (charge < 0) {

            // exception
        }

        this.charge = charge;
    }

    public int getDirt() {

        return dirt;
    }

    public void setDirt(int dirt) {

        if (dirt < 0) {

            //exception
        }

        this.dirt = dirt;
    }
    
    /*
     * @return the Cell that is to the right of this Cell. 
     * there is a posibility that this direction could be null because is blocked
     */
    public Cell getRightCell(){
    	
    	return this.rightCell;
    }
    
    /*
     * sets the Cell that is to the right of this Cell.
     * @param RCell. there is a posibility that could be null if the path for this direction is blocked
     */
    
    public void setRightCell(Cell RCell){
    	
    	this.rightCell = RCell;
    }
    
    
    /*
     * @return the Cell that is to the Left of this Cell. 
     * there is a posibility that this direction could be null because is blocked
     */
    public Cell getLeftCell(){
    	
    	return this.leftCell;
    }
    
    /*
     * sets the Cell that is to the left of this Cell.
     * @param LCell. there is a posibility that could be null if the path for this direction is blocked
     */
    
    public void setLeftCell(Cell LCell){
    	
    	this.leftCell = LCell;
    }
    
    /*
     * @return the Cell that is to the Upper of this Cell. 
     * there is a posibility that this direction could be null because is blocked
     */
    public Cell getUpperCell(){
    	
    	return this.upperCell;
    }
    
    /*
     * sets the Cell that is to the Upper of this Cell.
     * @param UCell. there is a posibility that could be null if the path for this direction is blocked
     */
    
    public void setUpperCell(Cell UCell){
    	
    	this.upperCell = UCell;
    }
    
    /*
     * @return the Cell that is to the Lower of this Cell. 
     * there is a posibility that this direction could be null because is blocked
     */
    public Cell getLowerCell(){
    	
    	return this.lowerCell;
    }
    
    /*
     * sets the Cell that is to the Lower of this Cell.
     * @param LCell. there is a posibility that could be null if the path for this direction is blocked
     */
    
    public void setLowerCell(Cell LCell){
    	
    	this.lowerCell = LCell;
    }
    
        
}
