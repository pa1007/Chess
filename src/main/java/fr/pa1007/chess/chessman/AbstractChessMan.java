package fr.pa1007.chess.chessman;

import fr.pa1007.chess.game.Game;
import fr.pa1007.chess.utils.Place;
import javafx.scene.shape.Rectangle;
import java.util.Objects;

public abstract class AbstractChessMan implements ChessMan {

    protected final Game      chessGame;
    protected final Rectangle graph;
    protected final Place     place;

    public AbstractChessMan(Game chessGame, Rectangle graph, Place place) {
        Objects.requireNonNull(chessGame);
        Objects.requireNonNull(graph);
        Objects.requireNonNull(place);
        this.graph = graph;
        this.chessGame = chessGame;
        this.place = place;
    }

}
