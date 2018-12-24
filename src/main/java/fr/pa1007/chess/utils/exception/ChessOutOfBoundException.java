package fr.pa1007.chess.utils.exception;

/**
 * This class is an exception thrown but doesn't do much,
 */
public class ChessOutOfBoundException extends Exception {

    /**
     * This exception can be throw if the place you want to create is outside the chess board
     *
     * @param s      the string/ sentence to give to the user
     * @param number the number for debug purpose
     */
    public ChessOutOfBoundException(String s, int number) {
        super(s + number);
    }
}
