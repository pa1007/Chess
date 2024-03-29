package fr.pa1007.chess.controller;

import fr.pa1007.chess.AI;
import fr.pa1007.chess.ai.guess.part.GuessPart;
import fr.pa1007.chess.chessman.ChessMan;
import fr.pa1007.chess.chessman.pieces.*;
import fr.pa1007.chess.game.Game;
import fr.pa1007.chess.handler.ChessMoveEventHandler;
import fr.pa1007.chess.utils.*;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.util.*;

public class GameController {

    // FIXME: 20/01/2019 
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
        this.game = new Game(graphicRepresentation, board);
        initChess();
        game.setPlayerToPlayer(player1);
        board.setBackground(new Background(new BackgroundImage(new Image(
                "/fr/pa1007/chess/display/playgroundImage.png"), BackgroundRepeat.NO_REPEAT, null, null, null)));
        GameStatePattern gSP = new GameStatePattern(game, player1, null);
        GuessPart[]      l   = PatternReader.explodePattern(gSP.getPattern(), player1);
        System.out.println(Arrays.toString(l));
        player2.setIa(true, new AI(player2, game));
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
        if (game.getPlayerToPlayer() == cM.getPlayer()) {
            this.generateGraphicRepHelp(cM, cM.generateMovePlace());
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
        for (Place place : here) {
            if (place != null) {
                if (!place.is("P8")) {
                    Rectangle helpR = createRectangle();
                    helpR.setOnMouseClicked(new ChessMoveEventHandler(place, cM, board, game));
                    board.add(helpR, place.getColumnNumber(), place.getRow() - 1);
                    helpPlace = true;
                }
            }
        }
    }

    private Rectangle createRectangle() {
        Rectangle helpR = new Rectangle(150, 120);
        helpR.setFill(Color.YELLOW);
        helpR.setOpacity(0.5);
        helpR.setId("help");
        return helpR;
    }


    /**
     * This method inti all the chess, and give acces to all player on part of the board, and add the image on the rectangle
     */
    private void initChess() {
        this.p1List = new ArrayList<>();
        this.player1 = new Player(Team.BLACK);
        p1List.add(new Rooks(this.game, rook1w1, new Place("A8"), player1));
        p1List.add(new Paw(this.game, paw1w1, new Place("A7"), player1));
        p1List.add(new Knight(this.game, knight1w1, new Place("B8"), player1));
        p1List.add(new Paw(this.game, paw1w2, new Place("B7"), player1));
        p1List.add(new Bishop(this.game, bishop1w1, new Place("C8"), player1));
        p1List.add(new Paw(this.game, paw1w3, new Place("C7"), player1));
        ChessMan king1 = new King(this.game, king1w1, new Place("D8"), player1);
        p1List.add(king1);
        game.setBlackMain(king1);
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
        this.player2 = new Player(Team.WHITE);
        p2List.add(new Paw(this.game, paw2w1, new Place("A2"), player2));
        p2List.add(new Rooks(this.game, rook2w1, new Place("A1"), player2));
        p2List.add(new Paw(this.game, paw2w2, new Place("B2"), player2));
        p2List.add(new Knight(this.game, knight2w1, new Place("B1"), player2));
        p2List.add(new Paw(this.game, paw2w3, new Place("C2"), player2));
        p2List.add(new Bishop(this.game, bishop2w1, new Place("C1"), player2));
        p2List.add(new Paw(this.game, paw2w4, new Place("D2"), player2));
        ChessMan king2 = new King(this.game, king2w1, new Place("D1"), player2);
        p2List.add(king2);
        game.setWhiteMain(king2);
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
