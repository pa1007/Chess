package fr.pa1007.chess.chessman.pieces;

import fr.pa1007.chess.Chess;
import fr.pa1007.chess.chessman.AbstractChessMan;
import fr.pa1007.chess.chessman.ChessManType;
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
                                                      + player.getTeam().toLowerCase()
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
        if (promotedType == null) {
            switch (movePattern.getPattern()) {
                case "|":
                    if (this.player.getTeam().equalsIgnoreCase("black")) {
                        return new Place[]{this.place.more(-1, 0)};
                    }
                    else {
                        return new Place[]{this.place.more(1, 0)};
                    }
                case "||":
                    if (this.player.getTeam().equalsIgnoreCase("black")) {
                        return new Place[]{this.place.more(-1, 0), this.place.more(-2, 0)};
                    }
                    else {
                        return new Place[]{this.place.more(1, 0), this.place.more(2, 0)};
                    }
                default:
                    throw new NullPointerException("No movement pattern");

            }
        }
        else {
            switch (promotedType) {
                case QUEEN:
                    return Place.getAll(place.getLines(), place.getDiagonal());
                case KNIGHT:
                    Place[] places = new Place[8];
                    places[0] = place.more(2, 1);
                    places[1] = place.more(2, -1);
                    places[2] = place.more(-2, -1);
                    places[3] = place.more(-2, 1);
                    places[4] = place.more(1, 2);
                    places[5] = place.more(-1, 2);
                    places[6] = place.more(-1, -2);
                    places[7] = place.more(1, -2);
                    return places;
                case BISHOP:
                    return place.getDiagonal();
                case ROOKS:
                    return place.getLines();
                default:
                    throw new NullPointerException("No movement pattern");

            }
        }
    }

    @Override
    public void specialMoveCheckBefore(Game game) {

    }

    @Override
    public void specialMoveCheckAfter(Game game) {
        if (player.getTeam().equalsIgnoreCase("black")) {
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

    public Place[] getDiagonal() {
        Place[] places = new Place[2];
        switch (player.getTeam().toLowerCase()) {
            case "white":
                places[0] = place.more(1, 1);
                places[1] = place.more(1, -1);
                break;
            case "black":
                places[0] = place.more(-1, -1);
                places[1] = place.more(-1, 1);
                break;
            default:
                places[0] = new Place("P6");
                places[1] = new Place("P6");
                break;
        }
        return places;
    }

    public void promote(ChessManType type) {
        promotedType = type;
        String link = "fr/pa1007/chess/display/"
                      + player.getTeam().toLowerCase();
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

    @Override
    public String toString() {
        return "P" + "+" + place.getName() + "+" + player.getTeam();
    }
}
