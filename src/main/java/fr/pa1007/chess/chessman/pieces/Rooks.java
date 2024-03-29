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

public class Rooks extends AbstractChessMan {


    public Rooks(Game chessGame, Rectangle graph, Place place, Player player) {
        super(chessGame, graph, place, player);
        this.graph.setFill(new ImagePattern(new Image("fr/pa1007/chess/display/"
                                                      + player.getTeamName().toLowerCase()
                                                      + "/Rook.png")));
        this.graph.setUserData(this);
        this.movePattern = new MovePattern(this);
    }

    @Override
    public ChessManType type() {
        return ChessManType.ROOKS;
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
    public Place place() {
        return this.place;
    }


    @Override
    public Place[] generateMovePlace() {
        return Move.getRookPossibleMove(chessGame, place, player);
    }

    @Override
    public void specialMoveCheckBefore(Game game) {

    }

    @Override
    public void specialMoveCheckAfter(Game game) {

    }

    @Override
    public int getValue() {
        return 5;
    }

    @Override
    public String toString() {
        return "R" + "+" + place.getName() + "+" + player.getTeamName();
    }
}
