package edu.depaul.se359.model;

import edu.depaul.se359.exception.InvalidFloorCodeException;
import edu.depaul.se359.exception.NegativeDirtUnitsException;

/**
 * Created on 10/10/15.
 * Class: Cell.java
 * Author: eric, marlon, andrew
 * Assignment: SE459
 */
public class Cell {

    private CoordinatePoint point;
    private int right;
    private int left;
    private int up;
    private int down;
    private boolean charge;
    private int dirt;
    private int surface;
    private Cell rightCell;
    private Cell leftCell;
    private Cell upperCell;
    private Cell lowerCell;

    public Cell(int xPosition, int yPosition, int rightPath, int leftPath, int upPath, int downPath, boolean charge, int dirt, int surface) throws InvalidFloorCodeException, NegativeDirtUnitsException {

        point = new CoordinatePoint(xPosition, yPosition);

        setRight(rightPath);
        setLeft(leftPath);
        setUp(upPath);
        setDown(downPath);
        setAChargingStation(charge);
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

    /**
     * @returns three types of surfaces
     * 1. bare floor
     * 2. low-pile
     * 3. High-pile carpet
     */
    public int getSurface() {
    	return surface;
    }

    /**
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
                ", charge=" + CheckisaChargingStation() +
                ", dirt=" + getDirt() +
                ", surface=" + surface +
                '}';
    }

    /**
     * @return the path of the right Cell of this current cell
     * 1. unknown
     * 2. it is open
     * 3. there is an obstacle
     * 4. there is a stairs
     */
    
    public int getRight() {
        return right;
    }

    /**
     * Sets the path of the right Cell of this current cell
     * 1. unknown
     * 2. it is open
     * 3. there is an obstacle
     * 4. there is a stairs
     * @param right
     */
    
    public void setRight(int right) throws InvalidFloorCodeException {

        if (right > 4) {
        	throw new InvalidFloorCodeException("Error: Right floor code too high");
            // exception
        }

        if (right < 1) {
        	throw new InvalidFloorCodeException("Error: Right floor code too low");
            // exception
        }

        this.right = right;
    }


    /**
     * @return the path of the left Cell of this current cell
     * 1. unknown
     * 2. it is open
     * 3. there is an obstacle
     * 4. there is a stairs
     */
    public int getLeft() {
        return left;
    }


    /**
     * Sets the path of the left Cell of this current cell
     * 1. unknown
     * 2. it is open
     * 3. there is an obstacle
     * 4. there is a stairs
     * @param left
     */
    public void setLeft(int left) throws InvalidFloorCodeException {

        if (left > 4) {
        	throw new InvalidFloorCodeException("Error: Left floor code too high");
            // exception
        }

        if (left < 1) {
        	throw new InvalidFloorCodeException("Error: Left floor code too low");
            // exception
        }

        this.left = left;
    }


    /**
     * @return the path of the above Cell of this current cell
     * 1. unknown
     * 2. it is open
     * 3. there is an obstacle
     * 4. there is a stairs
     */
    public int getUp() {
        return up;
    }

    /**
     * Sets the path of the above Cell of this current cell
     * 1. unknown
     * 2. it is open
     * 3. there is an obstacle
     * 4. there is a stairs
     * @param up
     */
    public void setUp(int up) throws InvalidFloorCodeException {

        if (up > 4) {
        	throw new InvalidFloorCodeException("Error: Up floor code too high");
            //exception
        }

        if (up < 0) {
        	throw new InvalidFloorCodeException("Error: Up floor code too low");
            // exception
        }

        this.up = up;
    }


    /**
    * @return the path of the below Cell of this current cell
    * 1. unknown
    * 2. it is open
    * 3. there is an obstacle
    * 4. there is a stairs
    */
    public int getDown() {
        return down;
    }

    /**
     * Sets the path of the below Cell of this current cell
     * 1. unknown
     * 2. it is open
     * 3. there is an obstacle
     * 4. there is a stairs
     * @param down
     */
    public void setDown(int down) throws InvalidFloorCodeException {


        if (down > 4) {
        	throw new InvalidFloorCodeException("Error: Down integer too high");
            // exception
        }

        if (down < 0) {
        	throw new InvalidFloorCodeException("Error: Down integer too low");
            // exception
        }

        this.down = down;
    }


    /**
    * @returns True if this Cell Contains the charging station
    *  or false if it doesn't 
    */
    public boolean CheckisaChargingStation() {
        return charge;
    }

    /**
     * Sets whether or not this Cell contains the charging station
     * @param charge
     */
    public void setAChargingStation(boolean charge) {
        this.charge = charge;
    }

    /**
     * @return the amount of dirt that is present in the Cell
     */
    
    public int getDirt() {

        return dirt;
    }


    /**
     * Sets the amount of dirt present in the Cell in (units)
     */
    public void setDirt(int dirt) throws NegativeDirtUnitsException {

        if (dirt < 0) {
        	throw new NegativeDirtUnitsException("Error: Negative dirt units detected");
            //exception
        }

        this.dirt = dirt;
    }

    /**
     * @return the Cell that is to the right of this Cell. 
     * there is a posibility that this direction could be null because is blocked
     */
    public Cell getRightCell(){
    	
    	return this.rightCell;
    }

    /**
     * sets the Cell that is to the right of this Cell.
     * @param RCell there is a posibility that could be null if the path for this direction is blocked
     */
    
    public void setRightCell(Cell RCell){
    	
    	this.rightCell = RCell;
    }


    /**
     * @return the Cell that is to the Left of this Cell. 
     * there is a posibility that this direction could be null because is blocked
     */
    public Cell getLeftCell(){
    	
    	return this.leftCell;
    }

    /**
     * sets the Cell that is to the left of this Cell.
     * @param LCell there is a posibility that could be null if the path for this direction is blocked
     */
    
    public void setLeftCell(Cell LCell){
    	
    	this.leftCell = LCell;
    }

    /**
     * @return the Cell that is to the Upper of this Cell. 
     * there is a posibility that this direction could be null because is blocked
     */
    public Cell getUpperCell(){
    	
    	return this.upperCell;
    }

    /**
     * sets the Cell that is to the Upper of this Cell.
     * @param UCell there is a posibility that could be null if the path for this direction is blocked
     */
    
    public void setUpperCell(Cell UCell){
    	
    	this.upperCell = UCell;
    }

    /**
     * @return the Cell that is to the Lower of this Cell. 
     * there is a posibility that this direction could be null because is blocked
     */
    public Cell getLowerCell(){
    	
    	return this.lowerCell;
    }

    /**
     * sets the Cell that is to the Lower of this Cell.
     * @param LCell there is a posibility that could be null if the path for this direction is blocked
     */
    
    public void setLowerCell(Cell LCell){
    	
    	this.lowerCell = LCell;
    }

    /**
     * this method returns true if the cells are the same otherwise false
     * @return boolean
     * @param C Cell to compare with the current Cell
     */
    public boolean sameCell(Cell C){
    	
    	return (this.getX() == C.getX()) && (this.getY() == C.getY());
    	
    	
    }

    /**
     * this method calculates the distace between two cells
     * @return double which is the distance between the two cells
     * @param C Cell to calculate the distance with the current Cell
     */
    public double distance(Cell C){
    	
    	double x = Math.pow(this.getX() - C.getX(), 2);
    	double y = Math.pow(this.getY() - C.getY(), 2);
    	double result = Math.sqrt(x + y);
    	
    	return result;
    }

    /**
     * this method returns a HashCode from the Coordinate Point object
     * Our Floor class uses this in order to assigned a key to the given cell in the map
     * Returns an Object Integer
     */
    public Integer getCoordinatePointHashCodeKey(){

        Integer result = this.point.hashCode();

        return result;
    	
    }
    
    
    
        
}
