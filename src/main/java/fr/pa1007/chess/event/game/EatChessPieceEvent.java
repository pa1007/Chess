package fr.pa1007.chess.event.game;

import fr.pa1007.chess.chessman.ChessMan;
import fr.pa1007.chess.event.Event;
import fr.pa1007.chess.utils.Place;

/**
 * The event interface
 */
public interface EatChessPieceEvent extends Event {

    /**
     * This method is executed by the Event
     *
     * @param main  The piece that eat the second
     * @param place the place it has been eat
     * @param ate   the ate piece
     */
    void ate(ChessMan main, Place place, ChessMan ate);
}
