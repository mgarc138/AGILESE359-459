package edu.depaul.se359.model;

import java.util.List;

public class Battery {

    private static final int BATTERY_MAX_UNITS_CAPACITY = 100;
    private Cell HomeTile;
    private double CurrentBatteryLevel;
    private List<Cell> shortestDirection;
    private double shortestDirectionWeight;

    public Battery(Cell homeCell) {

        // The cell which contains the charging station
        this.HomeTile = homeCell;

        // Sets the Battery to be fully charged
        setChargeBattery();
    }

    public static double calculateWeightUnits(Cell cellA, Cell cellB) {
        double weight = 0;
        
        //Average two surface values
        weight = ((double) cellA.getSurface() + cellB.getSurface()) / 2;
        
        return weight;
    }

    /**
     * Sets the battery to be fully charged
     */
    public void setChargeBattery() {

        this.CurrentBatteryLevel = BATTERY_MAX_UNITS_CAPACITY;
    }

    public void setDecrementBatteryLevel(Cell cellA, Cell cellB) {

        this.CurrentBatteryLevel = this.CurrentBatteryLevel - calculateWeightUnits(cellA, cellB);
    }

    public double getShortestDirectionWeight() {

        return shortestDirectionWeight;
    }

    public void setShortestDirectionWeight(double unitWeight) {

        this.shortestDirectionWeight = unitWeight;
    }
    
    public double getBatteryLevel(){
    	return CurrentBatteryLevel;
    }
}
