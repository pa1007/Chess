package fr.pa1007.chess.handler;

import fr.pa1007.chess.chessman.ChessMan;
import fr.pa1007.chess.event.type.EventTypes;
import fr.pa1007.chess.game.Game;
import fr.pa1007.chess.utils.Place;
import fr.pa1007.chess.utils.Player;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;
import java.util.List;

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
        int  row    = place.getRow() - 1;
        int  column = place.getColumnNumber();
        Node nodeT  = (Node) event.getTarget();
        if (nodeT.getId().contains("ate")) {
            System.out.println("Here");
            Player player = game.getOtherPlayer(chessMan.getPlayer());
            for (ChessMan man : game.getGraphic().get(player)) {
                Rectangle rec = man.getGraphicRep();
                Integer   cI  = GridPane.getColumnIndex(rec);
                Integer   rI  = GridPane.getRowIndex(rec);
                int       c   = cI == null ? 0 : cI;
                int       r   = rI == null ? 0 : rI;
                if (c == column && r == row) {
                    System.out.println("Found");
                    game.fireEvent(EventTypes.EATPIECEEVENT, chessMan, place, man);
                    grid.getChildren().remove(rec);
                    break;
                }
            }
        }

        grid.getChildren().removeIf(node -> node.getId().contains("help"));
        grid.getChildren().removeIf(node -> node == chessMan.getGraphicRep());
        grid.add(chessMan.getGraphicRep(), column, row);
        chessMan.place().setRow(place.getRow());
        chessMan.place().setColumn(place.getColumn());
        int i = chessMan.movementNumber() + 1;
        chessMan.setMoveNumber(i);
        game.fireEvent(EventTypes.PLAYERPLAYEREVENT, chessMan.getPlayer(), chessMan, place);
    }


}
