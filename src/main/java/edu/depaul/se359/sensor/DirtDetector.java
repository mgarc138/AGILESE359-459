package edu.depaul.se359.sensor;

import edu.depaul.se359.model.Cell;

/**
 * Created by eric on 10/23/15.
 */
public class DirtDetector {

    /**
     * Determines if the given cell is dirty
     *
     * @param cell
     * @return boolean
     */
    public static boolean isDirty(Cell cell) {
        return cell.getDirt() > 0;
    }
    
    public static boolean isCellObstacle(int obstacle){
    	
    	return obstacle == 3;
    }
    
    public static boolean isCellOpen(int open){
    	
    	return open == 2;
    }
    

    public static boolean isCellUnkown(int unknown){
    	
    	return unknown == 1;
    }
    
    public static boolean isCellStair(int stair){
    	
    	return stair == 4;
    }
    
    
    public static boolean isCellSurfaceBareFloor(int surface){
    	
    	return surface == 1;
    }
    
    public static boolean isCellSurfaceLowPile(int surface){
    	
    	return surface == 2;
    }
    
    public static boolean isCellSurfaceHighPileCarpet(int surface){
    	
    	return surface == 3;
    }
    

    
    
    
}
