package fr.pa1007.chess.chessman.pieces;

import fr.pa1007.chess.chessman.AbstractChessMan;
import fr.pa1007.chess.game.Game;
import fr.pa1007.chess.utils.Pattern;
import fr.pa1007.chess.utils.Place;
import fr.pa1007.chess.utils.Player;
import fr.pa1007.chess.utils.Type;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class Knight extends AbstractChessMan {

    public Knight(Game chessGame, Rectangle graph, Place place) {
        super(chessGame, graph, place);
        this.graph.setFill(new ImagePattern(new Image("fr/pa1007/chess/display/Knight.png")));
    }

    @Override
    public Pattern movePattern(Player player) {
        return null;
    }

    @Override
    public void move() {

    }

    @Override
    public Type type() {
        return null;
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
        return null;
    }
}
