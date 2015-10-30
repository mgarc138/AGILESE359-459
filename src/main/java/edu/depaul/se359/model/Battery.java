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

        double UnitesWeight = 0;

        if (cellA.getSurface() == 1 && cellB.getSurface() == 1) {

            UnitesWeight = 1;
        } else if (cellA.getSurface() == 2 && cellB.getSurface() == 2) {
            UnitesWeight = 2;
        } else if (cellA.getSurface() == 3 && cellB.getSurface() == 3) {
            UnitesWeight = 3;

        } else if ((cellA.getSurface() == 1 && cellB.getSurface() == 2) || (cellA.getSurface() == 2 && cellB.getSurface() == 1)) {

            UnitesWeight = 1.5;

        } else if ((cellA.getSurface() == 2 && cellB.getSurface() == 3) || (cellA.getSurface() == 3 && cellB.getSurface() == 2)) {

            UnitesWeight = 2.5;

        }

        return UnitesWeight;

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
}
