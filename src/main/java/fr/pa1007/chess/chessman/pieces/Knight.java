package fr.pa1007.chess.chessman.pieces;

import fr.pa1007.chess.chessman.AbstractChessMan;
import fr.pa1007.chess.chessman.utils.ChessManType;
import fr.pa1007.chess.chessman.utils.Move;
import fr.pa1007.chess.game.Game;
import fr.pa1007.chess.utils.MovePattern;
import fr.pa1007.chess.utils.Place;
import fr.pa1007.chess.utils.Player;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class Knight extends AbstractChessMan {


    public Knight(Game chessGame, Rectangle graph, Place place, Player player) {
        super(chessGame, graph, place, player);
        this.graph.setFill(new ImagePattern(new Image("fr/pa1007/chess/display/"
                                                      + player.getTeamName().toLowerCase()
                                                      + "/Knight.png")));
        this.graph.setUserData(this);
        this.movePattern = new MovePattern(this);
    }

    @Override
    public ChessManType type() {
        return ChessManType.KNIGHT;
    }

    @Override
    public int remaining() {
        return 0;
    }

    @Override
    public Image getImage() {
        return null;
    }

    @Override
    public Place[] generateMovePlace() {
        return Move.getKnightPossibleMove(chessGame, place, player);
    }

    @Override
    public void specialMoveCheckBefore(Game game) {

    }

    @Override
    public void specialMoveCheckAfter(Game game) {

    }

    @Override
    public int getValue() {
        return 3;
    }

    @Override
    public String toString() {
        return "KN" + "+" + place.getName() + "+" + player.getTeamName();
    }
}
