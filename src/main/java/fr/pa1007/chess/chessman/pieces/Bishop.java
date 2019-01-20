package fr.pa1007.chess.chessman.pieces;

import fr.pa1007.chess.chessman.AbstractChessMan;
import fr.pa1007.chess.chessman.ChessManType;
import fr.pa1007.chess.game.Game;
import fr.pa1007.chess.utils.MovePattern;
import fr.pa1007.chess.utils.Place;
import fr.pa1007.chess.utils.Player;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class Bishop extends AbstractChessMan {

    private MovePattern movePattern;
    private int         move;

    public Bishop(Game chessGame, Rectangle graph, Place place, Player player) {
        super(chessGame, graph, place, player);
        this.graph.setFill(new ImagePattern(new Image("fr/pa1007/chess/display/"
                                                      + player.getTeam().toLowerCase()
                                                      + "/Bishop.png")));
        this.graph.setUserData(this);
        this.movePattern = new MovePattern(this);
        move = 0;
    }


    @Override
    public ChessManType type() {
        return ChessManType.BISHOP;
    }

    @Override
    public int remaining() {
        return chessGame.remaining(ChessManType.BISHOP);
    }

    @Override
    public Image getImage() {
        return new Image("/fr/pa1007/chess/display/black/Bishop.png");
    }

    @Override
    public Place place() {
        return this.place;
    }

    @Override
    public int movementNumber() {
        return move;
    }

    @Override
    public void setMoveNumber(int i) {
        move = i;
    }

    @Override
    public Place[] generateMovePlace() {
        return place.getDiagonal();
    }

    @Override
    public MovePattern movePattern() {
        return this.movePattern;
    }

    @Override
    public String toString() {
        return "B" + place.getRow() + player.getNumber();
    }
}
