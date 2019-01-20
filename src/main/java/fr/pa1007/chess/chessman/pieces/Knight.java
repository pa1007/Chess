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

public class Knight extends AbstractChessMan {

    private final MovePattern movePattern;
    private       int         move;

    public Knight(Game chessGame, Rectangle graph, Place place, Player player) {
        super(chessGame, graph, place, player);
        this.graph.setFill(new ImagePattern(new Image("fr/pa1007/chess/display/"
                                                      + player.getTeam().toLowerCase()
                                                      + "/Knight.png")));
        this.graph.setUserData(this);
        this.movePattern = new MovePattern(this);
    }

    @Override
    public MovePattern movePattern() {
        return this.movePattern;
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
    public Place place() {
        return place;
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
    }

    @Override
    public String toString() {
        return "KN" + place.getRow() + player.getNumber();
    }
}
