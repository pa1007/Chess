package fr.pa1007.chess.chessman.pieces;

import fr.pa1007.chess.Chess;
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
import java.io.IOException;

public class Paw extends AbstractChessMan {

    private ChessManType promotedType;

    public Paw(Game chessGame, Rectangle graph, Place place, Player player) {
        super(chessGame, graph, place, player);
        this.graph.setFill(new ImagePattern(new Image("fr/pa1007/chess/display/"
                                                      + player.getTeamName().toLowerCase()
                                                      + "/Paw.png")));
        this.graph.setUserData(this);
        this.movePattern = new MovePattern(this);
    }


    @Override
    public ChessManType type() {
        return promotedType == null ? ChessManType.PAW : promotedType;
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
        return Move.getPawPossibleMove(chessGame, this);
    }

    @Override
    public void specialMoveCheckBefore(Game game) {

    }

    @Override
    public void specialMoveCheckAfter(Game game) {
        if (promotedType == null) {
            if (player.getTeamName().equalsIgnoreCase("black")) {
                if (place.getRow() == 1) {
                    try {
                        Chess.askPromotion(this);
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            else {
                if (place.getRow() == 8) {
                    try {
                        Chess.askPromotion(this);
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @Override
    public int getValue() {
        return 1;
    }

    public Place[] getDiagonal() {
        switch (player.getTeamName().toLowerCase()) {
            case "white":

                return place.getDiagonalWhitePaw();
            case "black":
                return place.getDiagonalBlackPaw();
            default:
                return place.getDiagonalErrorPaw();
        }
    }

    public void promote(ChessManType type) {
        promotedType = type;
        String link = "fr/pa1007/chess/display/"
                      + player.getTeamName().toLowerCase();
        switch (type) {
            case QUEEN:
                link += "/Queen.png";
                break;
            case KNIGHT:
                link += "/Knight.png";
                break;
            case BISHOP:
                link += "/Bishop.png";
                break;
            case ROOKS:
                link += "/Rook.png";
                break;

        }

        this.graph.setFill(new ImagePattern(new Image(link)));
    }

    public boolean isPromoted() {
        return promotedType != null;
    }

    public ChessManType getPromotedType() {
        return promotedType;
    }

    @Override
    public String toString() {
        return "P" + "+" + place.getName() + "+" + player.getTeamName();
    }
}
