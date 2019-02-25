package fr.pa1007.chess.listener.game;

import fr.pa1007.chess.chessman.ChessMan;
import fr.pa1007.chess.event.game.CheckMatePieceEvent;
import fr.pa1007.chess.game.Game;
import fr.pa1007.chess.listener.AbstractListener;
import java.util.Arrays;

public class CheckMatePieceEventListener extends AbstractListener implements CheckMatePieceEvent {

    /**
     * The constructor who use super() for the construction in the Listener
     *
     * @param gameInstance the instance of the game this is linked to
     */
    public CheckMatePieceEventListener(Game gameInstance) {
        super(gameInstance);
    }

    /**
     * This Event is trigger when a checkMATE is detected by the game
     *
     * @param checkedPiece The piece checked
     * @param piecesFrom   all the pieces from
     */
    @Override
    public void checkMate(ChessMan checkedPiece, ChessMan... piecesFrom) {

    }

    /**
     * The name of the event
     *
     * @return the name of the event
     */
    @Override
    public String name() {
        return null;
    }

    /**
     * The "Fired" event by the game itself
     *
     * @param objects all the object the Event need
     */
    @Override
    public void fire(Object... objects) {
        checkMate((ChessMan) objects[0], (ChessMan[]) Arrays.copyOfRange(objects, 1, objects.length));
    }
}
