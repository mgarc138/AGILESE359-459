package edu.depaul.se359.model;

import java.awt.*;

/**
 * Extend Built in java Point Class so that if we need to add extra methods we can easily do so.
 */
public class CoordinatePoint extends Point {
    public CoordinatePoint(int x, int y) {
        super(x, y);
    }
    
    /**
     * It produce a unique integer id to be store it and ask back in the HashMap for the specific cell
     * @ return integer
     */
    public int hashCode(){
    	
    	int hash = 87 + (7 + this.x);
    	    hash = 87 * (hash + this.y);
    	
    	    // it will be unique for 32 bit hashcode we can do some research on this
    	    return String.valueOf(hash).hashCode();	
    }
}