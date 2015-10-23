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
}
