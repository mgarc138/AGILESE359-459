package edu.depaul.se359.exception;

/**
 * Created by eric on 10/29/15.
 */
public class InvalidRoomCodeException extends Exception {
    public InvalidRoomCodeException(String message) {
        super(message);
    }

    public InvalidRoomCodeException() {
        super();
    }
}
