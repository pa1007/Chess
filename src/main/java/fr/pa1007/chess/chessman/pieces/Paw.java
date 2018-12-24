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

public class Paw extends AbstractChessMan {

    private MovePattern movePattern;
    private int         move;

    public Paw(Game chessGame, Rectangle graph, Place place, Player player) {
        super(chessGame, graph, place, player);
        this.graph.setFill(new ImagePattern(new Image("fr/pa1007/chess/display/"
                                                      + player.getTeam().toLowerCase()
                                                      + "/Paw.png")));
        this.graph.setUserData(this);
        this.movePattern = new MovePattern(this);
    }

    @Override
    public MovePattern movePattern() {
        return this.movePattern;
    }


    @Override
    public Rectangle getGraphicRep() {
        return graph;
    }

    @Override
    public ChessManType type() {
        return ChessManType.PAW;
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
    public int movementNumber() {
        return move;
    }

    @Override
    public void setMoveNumber(int i) {
        move = i;
    }

}
