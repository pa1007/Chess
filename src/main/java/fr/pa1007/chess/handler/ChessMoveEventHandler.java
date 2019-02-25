package fr.pa1007.chess.handler;

import fr.pa1007.chess.chessman.ChessMan;
import fr.pa1007.chess.event.type.EventTypes;
import fr.pa1007.chess.game.Game;
import fr.pa1007.chess.utils.Place;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class ChessMoveEventHandler implements EventHandler<MouseEvent> {

    private       Place    place;
    private       ChessMan chessMan;
    private final GridPane grid;
    private final Game     game;

    public ChessMoveEventHandler(Place place, ChessMan cM, GridPane plane, Game game) {
        this.place = place;
        this.chessMan = cM;
        this.grid = plane;
        this.game = game;
    }

    /**
     * Invoked when a specific event of the type for which this handler is
     * registered happens.
     *
     * @param event the event which occurred
     */
    @Override
    public void handle(MouseEvent event) {
        chessMan.specialMoveCheckBefore(game);
        int      row    = place.getRow() - 1;
        int      column = place.getColumnNumber();
        ChessMan m      = game.getPieceAt(place);
        if (m != null) {
            game.fireEvent(EventTypes.EAT_CHESS_PIECE_EVENT, chessMan, place, m);
            grid.getChildren().removeIf(node -> m.getGraphicRep() == node);
        }

        grid.getChildren().removeIf(node -> node.getId().contains("help"));
        grid.getChildren().removeIf(node -> node == chessMan.getGraphicRep());
        grid.add(chessMan.getGraphicRep(), column, row);
        chessMan.place().setRow(place.getRow());
        chessMan.place().setColumn(place.getColumn());
        chessMan.setMoveNumber(chessMan.movementNumber() + 1);
        chessMan.specialMoveCheckAfter(game);
        game.fireEvent(EventTypes.PLAYER_PLAYED_EVENT, chessMan.getPlayer(), chessMan, place);
    }


}
