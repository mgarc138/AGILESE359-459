package edu.depaul.se359.model;

import edu.depaul.se359.exception.*;
import javafx.scene.layout.GridPane;

import java.util.*;
import java.util.logging.Level;

public class CleanSweep extends Observable implements Runnable {

    public GridPane grid;
    private Cell currentCell;
    private Cell homeCell; //Cell that Clean Sweep starts on. This is also where the charging station is located.
    private DirtContainer dirtContainer;
    // private Map<Integer, Cell> HouseMap;
    private List<Cell> VisitedCells;
    private List<Cell> NotVisitedCells;
    private HomeLayout HouseMap;
    private Battery battery;


    public CleanSweep(Cell homeCell, HomeLayout houseMap) {

        this.homeCell = homeCell;
        this.currentCell = homeCell;

        this.dirtContainer = new DirtContainer();
        //HouseMap = new HashMap<Integer, Cell>();
        this.VisitedCells = new ArrayList<Cell>();
        this.NotVisitedCells = new ArrayList<Cell>();
        HouseMap = houseMap;
        battery = new Battery(homeCell);
    }

    public Map<Integer, Cell> cleanHome() throws InvalidFloorCodeException, InvalidRoomCodeException {

        int counter = 0;
        HashMap<Integer, Cell> houseCells = new HashMap<Integer, Cell>();

        // iterate through each floor
        for (Floor floor : HouseMap.getFloors()) {
            // iterate through each room
            for (Room room : floor.getRooms()) {
            	//TODO Visit only unvisited cells?
                for (Cell cell : room.getCells()) {
                	if (battery.getBatteryLevel() >= 50){
                		//We have enough charge
                		if (dirtContainer.getSweepCurrentDirt() < dirtContainer.getMaxCapacity()){
                			//Dirt capacity is good, let's clean!
                    		currentCell = cell;

                            try {
                                Thread.sleep(500);
                                cell.setDirt(0);
                                dirtContainer.addDirt(cell.getDirt());
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            } catch (NegativeDirtUnitsException e) {
                                e.printStackTrace();
                            }
                            catch (FullCapacityException e){
                            	LogFile.getInstance().writeLogFile(Level.INFO, "Reached capacity! Returning to charging station...");
    	                		goEmpty();
    	                		return null; //return out of loop
                            }

                            setChanged();
                            notifyObservers();
                            counter++;
                            VisitedCells.add(cell);
                    	}
                    	else{
                    		LogFile.getInstance().writeLogFile(Level.INFO, "Reached capacity! Returning to charging station...");
                    		goEmpty();
                    		return null; //return out of loop
                    	}
                	}
                	if (dirtContainer.getSweepCurrentDirt() < 50){
                		currentCell = cell;

                        try {
                            Thread.sleep(500);

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        counter++;
                        try {
							dirtContainer.addDirt(cell.getDirt());
                            cell.setDirt(0);
                        } catch (NegativeDirtUnitsException e) {
							LogFile.getInstance().writeLogFile(Level.INFO, "Invalid dirt amount");
						} catch (FullCapacityException e) {
							LogFile.getInstance().writeLogFile(Level.INFO, "Reached capacity! Returning to charging station...");
	                		goEmpty();
	                		return null; //return out of loop
						}

                        setChanged();
                        notifyObservers();
                    }
                	else{
                		//TODO Make way to charging station
                		LogFile.getInstance().writeLogFile(Level.INFO, "Battery level halfway full. To be safe, making way to charging station.");
                		goCharge();
                		return null;
                	}
    			}
    		}
    	}

        // System.out.println("Grid: " + map);

        LogFile.getInstance().writeLogFile(Level.INFO, "House Cells: " + houseCells.toString());
        Thread.currentThread().interrupt();

        return null;
    }

    /**
     * Stops the cleaning and tracks progress back to the charging station. prints statement to the log
     */
    private void goEmpty() {
    	//Return to charging station at home cell
    	currentCell = homeCell;
    	//Display "Empty Me" signal (log)
    	dirtContainer.setEmptyMeLight(true);
		LogFile.getInstance().writeLogFile(Level.INFO, "At charing station. Empty me!");
		try {
			//Waits for a time, then empties dirt capacity and turns off empty me light.
			Thread.sleep(500);
			dirtContainer.emptyMeBag();
			dirtContainer.setEmptyMeLight(false);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
    
    /**
     * Sends the clean sweep back to the charging station and charges it.
     */
    private void goCharge(){
    	currentCell = homeCell;
    	battery.setChargeBattery();
    	LogFile.getInstance().writeLogFile(Level.INFO, "All charged up!");
    }

	public Cell getCurrentPosition() {
        return currentCell;
    }

    /*public Map<Integer, Cell> addingCellsToHouseMap(Map<Integer, Cell> houseMap) {

        Integer CellCount = this.HouseMap.size();
        LogFile.getInstance().writeLogFile(Level.INFO, CellCount.toString());

        if (this.HouseMap.containsValue(this.currentCell)) {

            // it contains a value of the current cell don't added

        } else {
            // note A map maps a key to a value. If you have a value and you know the map contains this value, why do you need the key anymore
            // if it doesn't contain add it

            this.HouseMap.put(CellCount, this.currentCell);

        }

        //get a list of all the open cells available from the current one

        List<Cell> openNeighborsCellsList = this.getAllTheAvailableMoves(currentCell);
        LogFile.getInstance().writeLogFile(Level.INFO, "Available Moves: " + openNeighborsCellsList.toString());

        // using iterator we are more efficient in the traversing of the data structure so weh we say get next() is O(1) which is more efficient than O(n) regular for loop
        //Intatiaziation of the iterator
        Iterator<Cell> iterator = openNeighborsCellsList.iterator();

        while (iterator.hasNext()) {

            Cell CellElementNeighbor = iterator.next();

            if (this.HouseMap.containsValue(CellElementNeighbor)) {

                // The Cell is already in store in our houseMap
            } else {

                // we insert the new Cell
                // we increment the count to add a new Cell
                CellCount++;
                this.HouseMap.put(CellCount, CellElementNeighbor);

            }

        }

        return this.HouseMap;
    }*/

    public List<Cell> getAllTheAvailableMoves(Cell currentPositionCell) {

        List<Cell> allAvailableSweepMoves = new ArrayList<Cell>();
        
        try {
			NavigationSensorsPath.getInstance().openCells(currentPositionCell);
		} catch (NoPossibleMovesException e) {
			LogFile.getInstance().writeLogFile(Level.INFO, "No moves possible!");
		}

        LogFile.getInstance().writeLogFile(Level.INFO, allAvailableSweepMoves.toString());

        return allAvailableSweepMoves;
    }

    private List<Cell> move(Cell CelldestinationToMove) {

        List<Cell> listOfCellsTraversed = new ArrayList<Cell>();
        listOfCellsTraversed.add(this.currentCell);
        Cell nextCell;

        while (!(this.currentCell.sameCell(CelldestinationToMove))) {

            // to be implemented block by other feactures yet.
        }

        return listOfCellsTraversed;

    }

    // keeps track of the not visited cells
    public void SetNotVistedNeighborsCellsList() {

        List<Cell> NeighborsCellsList = new ArrayList<Cell>();
        NeighborsCellsList = getAllTheAvailableMoves(this.currentCell);
        NeighborsCellsList.removeAll(VisitedCells);
        NeighborsCellsList.removeAll(NotVisitedCells);

        Iterator<Cell> iterator = NeighborsCellsList.iterator();
        while (iterator.hasNext()) {

            Cell UnvisitedCell = iterator.next();

            this.NotVisitedCells.add(UnvisitedCell);
        }
    }

    public void run() {

        try {
            cleanHome();
        } catch (InvalidFloorCodeException e) {
            e.printStackTrace();
        } catch (InvalidRoomCodeException e) {
            e.printStackTrace();
        }
    }
}
