package fr.pa1007.chess.chessman;

import fr.pa1007.chess.game.Game;
import fr.pa1007.chess.utils.MovePattern;
import fr.pa1007.chess.utils.Place;
import fr.pa1007.chess.utils.Player;
import javafx.scene.shape.Rectangle;
import java.util.Objects;

/**
 * This is an abstract class, help to create the piece constructor to have aces to some value
 */
public abstract class AbstractChessMan implements ChessMan {


    /**
     * The Game instance the piece is from get it with <code>this.chessGame</code>
     */
    protected final Game chessGame;

    /**
     * The Graphic representation ot the piece is from get it with <code>this.graph</code>
     */
    protected final Rectangle graph;

    /**
     * The place of the piece it is from is from get it with <code>this.chessGame</code>
     */
    protected Place place;


    /**
     * The player to with the piece belongs to, get if with <code>this.player</code>
     */
    protected final Player player;


    /**
     * The move number of the piece, get if with <code>this.move</code>
     */
    protected int move;


    /**
     * The move pattern of the piece, get if with <code>this.movePattern</code>
     */
    protected MovePattern movePattern;

    /**
     * this constructor is done for creating an identical constructor in every other piece, this help to have a game instance, the graphic representation
     * , the place and a player
     *
     * @param chessGame the instance of the {@link Game Game}
     * @param graph     the graphic representation
     * @param place     the {@link Place place} of the piece
     * @param player    the {@link Place player} who owns the piece
     */
    public AbstractChessMan(Game chessGame, Rectangle graph, Place place, Player player) {
        Objects.requireNonNull(chessGame);
        Objects.requireNonNull(graph);
        Objects.requireNonNull(place);
        Objects.requireNonNull(player);
        this.graph = graph;
        this.chessGame = chessGame;
        this.place = place;
        this.player = player;
    }

    @Override
    public Player getPlayer() {
        return player;
    }

    @Override
    public Rectangle getGraphicRep() {
        return graph;
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
    public Place place() {
        return this.place;
    }


    @Override
    public MovePattern movePattern() {
        return this.movePattern;
    }

}
