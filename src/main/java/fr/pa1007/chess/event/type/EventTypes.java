package fr.pa1007.chess.event.type;

import fr.pa1007.chess.event.game.CheckMatePieceEvent;
import fr.pa1007.chess.event.game.CheckPieceEvent;
import fr.pa1007.chess.event.game.EatChessPieceEvent;
import fr.pa1007.chess.event.game.PlayerPlayedEvent;

/**
 * List of all the Event types for easy finding
 */
public final class EventTypes {

    /**
     * This event is thrown when the player has finish to play
     */
    public static final Class<PlayerPlayedEvent> PLAYER_PLAYED_EVENT = PlayerPlayedEvent.class;

    /**
     * This event is thrown when the piece ate another piece
     */
    public static final Class<EatChessPieceEvent> EAT_CHESS_PIECE_EVENT = EatChessPieceEvent.class;

    /**
     * This event is thrown when a check is detected in the game
     */
    public static final Class<CheckPieceEvent> CHECK_PIECE_EVENT = CheckPieceEvent.class;


    /**
     * This event is thrown when a check is detected in the game
     */
    public static final Class<CheckMatePieceEvent> CHECK_MATE_PIECE_EVENT = CheckMatePieceEvent.class;
}
