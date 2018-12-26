package fr.pa1007.chess.controller;

import fr.pa1007.chess.chessman.ChessMan;
import fr.pa1007.chess.chessman.ChessManType;
import fr.pa1007.chess.chessman.pieces.*;
import fr.pa1007.chess.game.Game;
import fr.pa1007.chess.handler.ChessMoveEventHandler;
import fr.pa1007.chess.utils.GameStatePattern;
import fr.pa1007.chess.utils.Place;
import fr.pa1007.chess.utils.Player;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
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
    private boolean                     helpPlace;

    public void init() {
        this.graphicRepresentation = new HashMap<>();
        this.game = new Game(graphicRepresentation);
        initChess();
        board.setBackground(new Background(new BackgroundImage(new Image(
                "/fr/pa1007/chess/display/playgroundImage.png"), BackgroundRepeat.NO_REPEAT, null, null, null)));
        GameStatePattern gSP = new GameStatePattern(game, player1, null);
        System.out.println(gSP.getPattern());

    }

    /**
     * This method will recieve the event after clicking a piece and it will get the "UserData" stored in every piece <code>piece.getUserData()</code>
     * and use the {@link GameController#generateMoveHelp(ChessMan)} method to generate the possible movement
     *
     * @param mouseEvent The event catch by the handler
     */
    public void mouseClickedHandler(MouseEvent mouseEvent) {
        Rectangle piece = (Rectangle) mouseEvent.getSource();
        ChessMan  cM    = (ChessMan) piece.getUserData();
        generateMoveHelp(cM);
    }

    /**
     * This method generate help for moving the thing and help you choose witch place the piece can
     * go
     *
     * @param cM the piece clicked on
     */
    private void generateMoveHelp(ChessMan cM) {
        switch (cM.movePattern().getPattern()) {
            case "|":
                if (graphicRepresentation.get(player1).contains(cM)) {
                    this.generateGraphicRepHelp(cM, cM.place().more(-1, 0));
                }
                else {
                    this.generateGraphicRepHelp(cM, cM.place().more(1, 0));
                }
                break;
            case "||":
                if (graphicRepresentation.get(player1).contains(cM)) {
                    this.generateGraphicRepHelp(cM, cM.place().more(-1, 0), cM.place().more(-2, 0));
                }
                else {
                    this.generateGraphicRepHelp(cM, cM.place().more(1, 0), cM.place().more(2, 0));
                }
                break;
            case "H":
                this.generateGraphicRepHelp(cM, cM.place().getPlaceAround());
                break;
            case "X":
                this.generateGraphicRepHelp(cM, cM.place().getDiagonal());
                break;
            case "E":
                this.generateGraphicRepHelp(cM, cM.place().getLines());
                break;
            case "L":
                this.generateGraphicRepHelp(cM, ((Knight) cM).getPlacesToMove());
                break;
            case "XE":
                this.generateGraphicRepHelp(cM, Place.getAll(cM.place().getLines(), cM.place().getDiagonal()));
                break;
        }
    }

    /**
     * This generate the "Help" rectangle for the player to play in, he also check if the place is a piece of not, he can only take the fist piece of a enemy
     * and must not move when he is near team piece like a rook, he cannot fly hover his mate, we need to fix that
     *
     * @param cM   The piece clicked
     * @param here all the places in range of the movement can be a single piece or a array of piece
     */
    private void generateGraphicRepHelp(ChessMan cM, Place... here) {
        if (helpPlace) {
            board.getChildren().removeIf(node -> node.getId().contains("help"));
            helpPlace = false;
        }
        Rectangle rectangle = cM.getGraphicRep();
        Node      sav       = null;
        Integer   columnS   = GridPane.getColumnIndex(rectangle);
        Integer   rowS      = GridPane.getRowIndex(rectangle);
        boolean   second    = false;
        boolean   teamPLay  = false;
        for (Place place : here) {
            if (place != null && place.is("P6")) {
                second = false;
                teamPLay = false;
            }
            if (place != null && !place.is("P6")) {
                Rectangle helpR = new Rectangle(150, 120);
                helpR.setOnMouseClicked(new ChessMoveEventHandler(place, cM, board, game));
                helpR.setFill(Color.YELLOW);
                helpR.setOpacity(0.5);
                helpR.setId("help");
                int     row    = place.getRow() - 1;
                int     column = place.getColumnNumber();
                boolean canDo  = true;

                for (ChessMan man : graphicRepresentation.get(cM.getPlayer())) {
                    Rectangle rec = man.getGraphicRep();
                    Integer   cI  = GridPane.getColumnIndex(rec);
                    Integer   rI  = GridPane.getRowIndex(rec);
                    int       c   = cI == null ? 0 : cI;
                    int       r   = rI == null ? 0 : rI;
                    if (c == column && r == row) {
                        canDo = false;
                        teamPLay = true;
                        break;
                    }
                }

                if (canDo) {
                    if (second && cM.type() == ChessManType.KNIGHT) {
                        second = false;
                    }
                    if (!second) {
                        for (ChessMan man : graphicRepresentation.get(game.getOtherPlayer(cM.getPlayer()))) {
                            Rectangle rec = man.getGraphicRep();
                            Integer   cI  = GridPane.getColumnIndex(rec);
                            Integer   rI  = GridPane.getRowIndex(rec);
                            helpR.setId("help!eat");
                            int c = cI == null ? 0 : cI;
                            int r = rI == null ? 0 : rI;
                            if (c == column && r == row) {
                                second = true;
                                break;
                            }
                        }

                    }
                    else {
                        for (ChessMan man : graphicRepresentation.get(game.getOtherPlayer(cM.getPlayer()))) {
                            Rectangle rec = man.getGraphicRep();
                            Integer   cI  = GridPane.getColumnIndex(rec);
                            Integer   rI  = GridPane.getRowIndex(rec);
                            int       c   = cI == null ? 0 : cI;
                            int       r   = rI == null ? 0 : rI;
                            if (c == column && r == row) {
                                canDo = false;
                                break;
                            }
                        }
                    }
                }

                if (canDo && (!teamPLay || cM.type() == ChessManType.KNIGHT)) {
                    board.add(helpR, column, row);
                    System.out.println("Help added to :" + place);
                    helpPlace = true;
                }
            }
        }
    }


    /**
     * This method inti all the chess, and give acces to all player on part of the board, and add the image on the rectangle
     */
    private void initChess() {
        this.p1List = new ArrayList<>();
        this.player1 = new Player("Black");
        p1List.add(new Rooks(this.game, rook1w1, new Place("A8"), player1));
        p1List.add(new Paw(this.game, paw1w1, new Place("A7"), player1));
        p1List.add(new Knight(this.game, knight1w1, new Place("B8"), player1));
        p1List.add(new Paw(this.game, paw1w2, new Place("B7"), player1));
        p1List.add(new Bishop(this.game, bishop1w1, new Place("C8"), player1));
        p1List.add(new Paw(this.game, paw1w3, new Place("C7"), player1));
        p1List.add(new King(this.game, king1w1, new Place("D8"), player1));
        p1List.add(new Paw(this.game, paw1w4, new Place("D7"), player1));
        p1List.add(new Queen(this.game, queen1w1, new Place("E8"), player1));
        p1List.add(new Paw(this.game, paw1w5, new Place("E7"), player1));
        p1List.add(new Bishop(this.game, bishop1w2, new Place("F8"), player1));
        p1List.add(new Paw(this.game, paw1w6, new Place("F7"), player1));
        p1List.add(new Knight(this.game, knight1w2, new Place("G8"), player1));
        p1List.add(new Paw(this.game, paw1w7, new Place("G7"), player1));
        p1List.add(new Rooks(this.game, rook1w2, new Place("H8"), player1));
        p1List.add(new Paw(this.game, paw1w8, new Place("H7"), player1));
        this.graphicRepresentation.put(player1, p1List);
        this.p2List = new ArrayList<>();
        this.player2 = new Player("White");
        p2List.add(new Paw(this.game, paw2w1, new Place("A2"), player2));
        p2List.add(new Rooks(this.game, rook2w1, new Place("A1"), player2));
        p2List.add(new Paw(this.game, paw2w2, new Place("B2"), player2));
        p2List.add(new Knight(this.game, knight2w1, new Place("B1"), player2));
        p2List.add(new Paw(this.game, paw2w3, new Place("C2"), player2));
        p2List.add(new Bishop(this.game, bishop2w1, new Place("C1"), player2));
        p2List.add(new Paw(this.game, paw2w4, new Place("D2"), player2));
        p2List.add(new King(this.game, king2w1, new Place("D1"), player2));
        p2List.add(new Queen(this.game, queen2w1, new Place("E1"), player2));
        p2List.add(new Paw(this.game, paw2w5, new Place("E2"), player2));
        p2List.add(new Bishop(this.game, bishop2w2, new Place("F1"), player2));
        p2List.add(new Paw(this.game, paw2w6, new Place("F2"), player2));
        p2List.add(new Knight(this.game, knight2w2, new Place("G1"), player2));
        p2List.add(new Paw(this.game, paw2w7, new Place("G2"), player2));
        p2List.add(new Rooks(this.game, rook2w2, new Place("H1"), player2));
        p2List.add(new Paw(this.game, paw2w8, new Place("H2"), player2));
        this.graphicRepresentation.put(player2, p2List);
    }
}
