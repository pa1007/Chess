package fr.pa1007.chess.listener.game;

import fr.pa1007.chess.chessman.ChessMan;
import fr.pa1007.chess.event.game.EatChessPieceEvent;
import fr.pa1007.chess.game.Game;
import fr.pa1007.chess.listener.AbstractListener;
import fr.pa1007.chess.utils.Place;
import fr.pa1007.chess.utils.Player;
import java.util.ArrayList;
import java.util.List;

/**
 * This is the listener for the event {@link fr.pa1007.chess.event.game.EatChessPieceEvent EatChessPieceEvent} who is implemented here
 */
public class EatEventListenerEvent extends AbstractListener implements EatChessPieceEvent {

    /**
     * The constructor {@link fr.pa1007.chess.listener.AbstractListener#AbstractListener(Game)}
     *
     * @param gameInstance the game instance
     */
    public EatEventListenerEvent(Game gameInstance) {
        super(gameInstance);
    }

    /**
     * This is the method where the code is put, bu can also be down in the fire one but for more readability
     *
     * @param main  The piece that eat the second
     * @param place the place it has been eat
     * @param ate   the ate piece
     */
    @Override
    public void ate(ChessMan main, Place place, ChessMan ate) {
        Player player = ate.getPlayer();
        gameInstance.getGraphic().get(player).remove(ate);
        List<ChessMan> dead = gameInstance.getDead().getOrDefault(player, new ArrayList<>());
        dead.add(ate);
        gameInstance.getDead().put(player, dead);
    }

    /**
     * The name of the event
     *
     * @return the name of the event
     */
    @Override
    public String name() {
        return "Eat listener";
    }

    /**
     * The methods fired by the game {@link fr.pa1007.chess.game.Game#fireEvent(Class, Object...)}
     *
     * @param objects all the object the Event need
     */
    @Override
    public void fire(Object[] objects) {
        ate((ChessMan) objects[0], (Place) objects[1], (ChessMan) objects[2]);
    }
}
