package fr.pa1007.chess.event.type;

import fr.pa1007.chess.event.game.EatChessPieceEvent;
import fr.pa1007.chess.event.game.PlayerPlayedEvent;

/**
 * List of all the Event types for easy finding
 */
public final class EventTypes {

    /**
     * This event is thrown when the player has finish to play
     */
    public static final Class<PlayerPlayedEvent> PLAYERPLAYEREVENT = PlayerPlayedEvent.class;

    /**
     * This event is thrown when the piece ate another piece
     */
    public static final Class<EatChessPieceEvent> EATPIECEEVENT = EatChessPieceEvent.class;
}
