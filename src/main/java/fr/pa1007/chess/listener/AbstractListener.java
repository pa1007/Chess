package fr.pa1007.chess.listener;

import fr.pa1007.chess.game.Game;
import java.util.Objects;

public abstract class AbstractListener implements Listener {

    /**
     * This is the game link to the event for getting the game <code>this.gameInstance</code>
     */
    protected final Game gameInstance;

    /**
     * The constructor who use super() for the construction in the Listener
     *
     * @param gameInstance the instance of the game this is linked to
     */
    public AbstractListener(Game gameInstance) {
        Objects.requireNonNull(gameInstance);

        this.gameInstance = gameInstance;
    }

}
