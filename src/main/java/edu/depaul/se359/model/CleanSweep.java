package edu.depaul.se359.model;

import edu.depaul.se359.exception.InvalidFloorCodeException;
import edu.depaul.se359.exception.InvalidRoomCodeException;
import edu.depaul.se359.exception.NegativeDirtUnitsException;
import javafx.scene.layout.GridPane;

import java.util.*;
import java.util.logging.Level;

public class CleanSweep extends Observable implements Runnable {

    public GridPane grid;
    private Cell CurrentCell;
    private Cell HomeCell;
    private UtilityContainer DirtAnalizer;
    // private Map<Integer, Cell> HouseMap;
    private List<Cell> VisitedCells;
    private List<Cell> NotVisitedCells;
    private HomeLayout HouseMap;
    private Battery battery;


    public CleanSweep(Cell homeCell, HomeLayout houseMap) {

        this.HomeCell = homeCell;
        this.CurrentCell = homeCell;

        this.DirtAnalizer = new UtilityContainer();
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
                for (Cell cell : room.getCells()) {
                    CurrentCell = cell;

                    try {
                        Thread.sleep(500);
                        cell.setDirt(0);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (NegativeDirtUnitsException e) {
                        e.printStackTrace();
                    }

                    setChanged();
                    notifyObservers();
                    counter++;
    			}
    		}
    	}

        // System.out.println("Grid: " + map);

        LogFile.getInstance().writeLogFile(Level.INFO, "House Cells: " + houseCells.toString());
        Thread.currentThread().interrupt();

        return null;
    }

    public Cell getCurrentPosition() {
        return CurrentCell;
    }

    /*public Map<Integer, Cell> addingCellsToHouseMap(Map<Integer, Cell> houseMap) {

        Integer CellCount = this.HouseMap.size();
        LogFile.getInstance().writeLogFile(Level.INFO, CellCount.toString());

        if (this.HouseMap.containsValue(this.CurrentCell)) {

            // it contains a value of the current cell don't added

        } else {
            // note A map maps a key to a value. If you have a value and you know the map contains this value, why do you need the key anymore
            // if it doesn't contain add it

            this.HouseMap.put(CellCount, this.CurrentCell);

        }

        //get a list of all the open cells available from the current one

        List<Cell> openNeighborsCellsList = this.getAllTheAvailableMoves(CurrentCell);
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

    public List<Cell> getAllTheAvailableMoves(Cell CurentPositionCell) {

        List<Cell> allAvailableSweepMoves = new ArrayList<Cell>();

        LogFile.getInstance().writeLogFile(Level.INFO, allAvailableSweepMoves.toString());

        return allAvailableSweepMoves;
    }

    private List<Cell> move(Cell CelldestinationToMove) {

        List<Cell> listOfCellsTraversed = new ArrayList<Cell>();
        listOfCellsTraversed.add(this.CurrentCell);
        Cell nextCell;

        while (!(this.CurrentCell.sameCell(CelldestinationToMove))) {

            // to be implemented block by other feactures yet.
        }

        return listOfCellsTraversed;

    }

    // keeps track of the not visited cells
    public void SetNotVistedNeighborsCellsList() {

        List<Cell> NeighborsCellsList = new ArrayList<Cell>();
        NeighborsCellsList = getAllTheAvailableMoves(this.CurrentCell);
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
