package fr.pa1007.chess.controller;

import fr.pa1007.chess.chessman.ChessMan;
import fr.pa1007.chess.chessman.pieces.*;
import fr.pa1007.chess.game.Game;
import fr.pa1007.chess.utils.Place;
import fr.pa1007.chess.utils.Player;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameController {

    public GridPane  board;
    public Rectangle rook1w1;
    public Rectangle knight1w1;
    public Rectangle bishop1w1;
    public Rectangle king1w1;
    public Rectangle queen1w1;
    public Rectangle bishop1w2;
    public Rectangle knight1w2;
    public Rectangle rook1w2;
    public Rectangle rook2w2;
    public Rectangle knight2w2;
    public Rectangle bishop2w2;
    public Rectangle queen2w1;
    public Rectangle king2w1;
    public Rectangle bishop2w1;
    public Rectangle knight2w1;
    public Rectangle rook2w1;
    public Rectangle paw2w1;
    public Rectangle paw2w2;
    public Rectangle paw2w3;
    public Rectangle paw2w4;
    public Rectangle paw2w5;
    public Rectangle paw2w6;
    public Rectangle paw2w7;
    public Rectangle paw2w8;
    public Rectangle paw1w8;
    public Rectangle paw1w7;
    public Rectangle paw1w6;
    public Rectangle paw1w5;
    public Rectangle paw1w4;
    public Rectangle paw1w3;
    public Rectangle paw1w2;
    public Rectangle paw1w1;


    private Map<Player, List<ChessMan>> graphicRepresentation;
    private Game                        game;
    private Player                      player1;
    private Player                      player2;
    private List<ChessMan>              p2List;
    private List<ChessMan>              p1List;

    public void init() {
        this.graphicRepresentation = new HashMap<>();
        this.game = new Game();
        initChess();
        board.setBackground(new Background(new BackgroundImage(new Image(
                "/fr/pa1007/chess/display/playgroundImage.png"), BackgroundRepeat.NO_REPEAT, null, null, null)));


    }

    private void initChess() {
        this.p1List = new ArrayList<>();
        p1List.add(new Rooks(this.game, rook1w1, new Place("A1")));
        p1List.add(new Knight(this.game, knight1w1, new Place("B1")));
        p1List.add(new Bishop(this.game, bishop1w1, new Place("C1")));
        p1List.add(new King(this.game, king1w1, new Place("D1")));
        p1List.add(new Queen(this.game, queen1w1, new Place("E1")));
        p1List.add(new Bishop(this.game, bishop1w2, new Place("F1")));
        p1List.add(new Knight(this.game, knight1w2, new Place("G1")));
        p1List.add(new Rooks(this.game, rook1w2, new Place("H1")));
        p1List.add(new Paw(this.game, paw1w1, new Place("A2")));
        p1List.add(new Paw(this.game, paw1w2, new Place("B2")));
        p1List.add(new Paw(this.game, paw1w3, new Place("C2")));
        p1List.add(new Paw(this.game, paw1w4, new Place("D2")));
        p1List.add(new Paw(this.game, paw1w5, new Place("E2")));
        p1List.add(new Paw(this.game, paw1w6, new Place("F2")));
        p1List.add(new Paw(this.game, paw1w7, new Place("G2")));
        p1List.add(new Paw(this.game, paw1w8, new Place("H2")));
        this.player1 = new Player();
        this.graphicRepresentation.put(player1, p1List);
        this.p2List = new ArrayList<>();
        p2List.add(new Rooks(this.game, rook2w1, new Place("A8")));
        p2List.add(new Knight(this.game, knight2w1, new Place("B8")));
        p2List.add(new Bishop(this.game, bishop2w1, new Place("C8")));
        p2List.add(new King(this.game, king2w1, new Place("D8")));
        p2List.add(new Queen(this.game, queen2w1, new Place("E8")));
        p2List.add(new Bishop(this.game, bishop2w2, new Place("F8")));
        p2List.add(new Knight(this.game, knight2w2, new Place("G8")));
        p2List.add(new Rooks(this.game, rook2w2, new Place("H8")));
        p2List.add(new Paw(this.game, paw2w1, new Place("A7")));
        p2List.add(new Paw(this.game, paw2w2, new Place("B7")));
        p2List.add(new Paw(this.game, paw2w3, new Place("C7")));
        p2List.add(new Paw(this.game, paw2w4, new Place("D7")));
        p2List.add(new Paw(this.game, paw2w5, new Place("E7")));
        p2List.add(new Paw(this.game, paw2w6, new Place("F7")));
        p2List.add(new Paw(this.game, paw2w7, new Place("G7")));
        p2List.add(new Paw(this.game, paw2w8, new Place("H7")));
        this.player2 = new Player();
        this.graphicRepresentation.put(player2, p2List);
    }
}
