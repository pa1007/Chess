package fr.pa1007.chess.event.game;

import fr.pa1007.chess.chessman.ChessMan;
import fr.pa1007.chess.event.Event;

public interface CheckMatePieceEvent extends Event {

    /**
     * This Event is trigger when a checkMATE is detected by the game
     *
     * @param checkedPiece The piece checked
     * @param piecesFrom   all the pieces from
     */
    void checkMate(ChessMan checkedPiece, ChessMan... piecesFrom);
}
