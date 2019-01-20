package fr.pa1007.chess.event.game;

import fr.pa1007.chess.chessman.ChessMan;
import fr.pa1007.chess.event.Event;
import fr.pa1007.chess.utils.Place;
import fr.pa1007.chess.utils.Player;

/**
 * The event interface
 */
public interface PlayerPlayedEvent extends Event {

    /**
     * This method is executed by the Event
     *
     * @param player The player who has finish is round
     * @param man    the last piece  to be moved
     * @param at     The location of the movement
     */
    void playerPlayed(Player player, ChessMan man, Place at);
}
