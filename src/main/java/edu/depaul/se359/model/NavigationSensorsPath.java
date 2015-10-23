package edu.depaul.se359.model;

import java.util.List;

import edu.depaul.se359.exception.NoPossibleMovesException;

/**
 * 
 * @author marlon garcia
 *
 */

public final class NavigationSensorsPath {

	private NavigationSensorsPath(){
		
		// default constructor
	}
	
		private static boolean CheckForOpenPath(int path){
		
		if(path == 2){
			
			return true;
		}
		
		else {
			
			return false;
		}
		
		
	}
		
	
		public static boolean openPathRight(Cell currentCell){
			
			// initialize the path as you don't know  = 1
			
			int path = 1;
			//get the real path
			path = currentCell.getRight();
			return CheckForOpenPath(path);	
		}
		
		public static boolean openPathLeft(Cell currentCell){
			
			// initialize the path as you don't know  = 1
			
			int path = 1;
			//get the real path
			path = currentCell.getLeft();
			return CheckForOpenPath(path);	
		}
		
		
		
		public static boolean openPathDown(Cell currentCell){
			
			// initialize the path as you don't know  = 1
			
			int path = 1;
			//get the real path
			path = currentCell.getDown();
			return CheckForOpenPath(path);	
		}
		
		
		
		public static boolean openPathUp(Cell currentCell){
			
			// initialize the path as you don't know  = 1
			
			int path = 1;
			//get the real path
			path = currentCell.getUp();
			return CheckForOpenPath(path);	
		}
	
	
	
	private static boolean CheckForObstacles(int path){
		
		if(path == 3){
			
			return true;
		}
		
		else {
			
			return false;
		}
		
		
	}
	
	
	
	public static boolean obstacleRight(Cell currentCell){
		
		// initialize the path as you don't know  = 1
		
		int path = 1;
		//get the real path
		path = currentCell.getRight();
		return CheckForObstacles(path);
		
		
	}
	

	public static boolean obstacleLeft(Cell currentCell){
		
		// initialize the path as you don't know  = 1
		
		int path = 1;
		//get the real path
		path = currentCell.getLeft();
		return CheckForObstacles(path);
		
		
	}
	
	

	public static boolean obstacleUp(Cell currentCell){
		
		// initialize the path as you don't know  = 1
		
		int path = 1;
		//get the real path
		path = currentCell.getUp();
		return CheckForObstacles(path);
		
		
	}
	
	

	
	public static boolean obstacleDown(Cell currentCell){
		
		// initialize the path as you don't know  = 1
		
		int path = 1;
		//get the real path
		path = currentCell.getDown();
		return CheckForObstacles(path);
		
		
	}
	
	

	
	
	
	
	
	
	
	private static boolean CheckForStairs(int path){
		
		if(path == 4){
			
			return true;
		}
		
		else {
			
			return false;
		}
		
	}
	
	
	public static boolean stairsRight(Cell currentCell){
		
		// initialize the path as you don't know  = 1
		
				int path = 1;
				//get the real path
				path = currentCell.getRight();
				return CheckForStairs(path);
				
		
	}
	
	public static boolean stairsLeft(Cell currentCell){
		
		// initialize the path as you don't know  = 1
		
		int path = 1;
		//get the real path
		path = currentCell.getLeft();
		return CheckForStairs(path);
		
		
	}
	
	
	public static boolean stairsUp(Cell currentCell){
		
		// initialize the path as you don't know  = 1
		
		int path = 1;
		//get the real path
		path = currentCell.getUp();
		return CheckForStairs(path);
		
		
	}
	
	
	
public static boolean stairsDown(Cell currentCell){
		
		// initialize the path as you don't know  = 1
		
		int path = 1;
		//get the real path
		path = currentCell.getDown();
		return CheckForStairs(path);
		
		
	}
	
	
	
@SuppressWarnings("null")
public static List<Cell> openCells(Cell currentCell) throws NoPossibleMovesException{
	List<Cell> possibleMoves = null;
	if (!(obstacleUp(currentCell)) && !(stairsUp(currentCell))){
		possibleMoves.add(currentCell.getUpperCell());
	}
	if (!(obstacleDown(currentCell)) && !(stairsDown(currentCell))){
		possibleMoves.add(currentCell.getLowerCell());
	}
	if (!(obstacleLeft(currentCell)) && !(stairsLeft(currentCell))){
		possibleMoves.add(currentCell.getLeftCell());
	}
	if (!(obstacleRight(currentCell)) && !(stairsRight(currentCell))){
		possibleMoves.add(currentCell.getRightCell());
	}
	if (possibleMoves == null){
		throw new NoPossibleMovesException("Error: Clean sweep has no possible moves");
	}
	return possibleMoves;
	
}
	
	
	
	
	
	
}
