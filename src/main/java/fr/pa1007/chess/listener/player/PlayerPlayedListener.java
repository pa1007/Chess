package fr.pa1007.chess.listener.player;

import fr.pa1007.chess.chessman.ChessMan;
import fr.pa1007.chess.event.game.PlayerPlayedEvent;
import fr.pa1007.chess.game.Game;
import fr.pa1007.chess.listener.AbstractListener;
import fr.pa1007.chess.utils.Place;
import fr.pa1007.chess.utils.Player;

/**
 * This is the listener for the event {@link fr.pa1007.chess.event.game.PlayerPlayedEvent PlayerPlayedEvent} who is implemented here
 */
public class PlayerPlayedListener extends AbstractListener implements PlayerPlayedEvent {

    /**
     * The constructor {@link fr.pa1007.chess.listener.AbstractListener#AbstractListener(Game)}
     *
     * @param gameInstance the game instance
     */
    public PlayerPlayedListener(Game gameInstance) {
        super(gameInstance);
    }

    /**
     * The name of the event
     *
     * @return the name of the event
     */
    @Override
    public String name() {
        return "PlayerPlayedListener";
    }

    /**
     * The methods fired by the game {@link fr.pa1007.chess.game.Game#fireEvent(Class, Object...)}
     *
     * @param objects all the object the Event need
     */
    @Override
    public void fire(Object[] objects) {
        playerPlayed((Player) objects[0], (ChessMan) objects[1], (Place) objects[2]);
    }

    /**
     * This is the method where the code is put, bu can also be down in the fire one but for more readability
     *
     * @param player The player who has finish is round
     * @param man    the last piece  to be moved
     * @param at     The location of the movement
     */
    @Override
    public void playerPlayed(Player player, ChessMan man, Place at) {
        gameInstance.setPlayerToPlayer(gameInstance.getOtherPlayer(player));
        System.out.println(player.getTeam() + " has played with " + man + " At " + at);
    }
}
