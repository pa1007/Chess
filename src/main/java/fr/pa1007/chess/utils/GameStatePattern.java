package fr.pa1007.chess.utils;

import fr.pa1007.chess.ai.guess.part.CompleteGuessPart;
import fr.pa1007.chess.ai.guess.part.Part;
import fr.pa1007.chess.chessman.ChessMan;
import fr.pa1007.chess.game.Game;
import java.util.Arrays;
import java.util.Map;

public class GameStatePattern {

    /**
     * The game where the pattern is from.
     *
     * @since 1.0
     */
    private Game game;

    /**
     * The player from where the pattern emit.
     *
     * @since 1.0
     */
    private Player player;

    /**
     * The piece from where the pattern is generated.
     *
     * @since 1.0
     */
    private ChessMan mainPiece;


    /**
     * The pattern of the game.
     *
     * @since 1.0
     */
    private CompleteGuessPart    pattern;
    private Map<Place, ChessMan> placeMap;

    public GameStatePattern(Game game, Player player, ChessMan chessMan) {
        this.game = new Game(game);
        this.placeMap = game.getMap();
        this.player = player;
        this.mainPiece = chessMan;
        this.pattern = this.generatePattern();
    }

    public GameStatePattern(Game game, ChessMan chessMan) {
        this.game = new Game(game);
        this.placeMap = game.getMap();
        this.player = chessMan.getPlayer();
        this.mainPiece = chessMan;
        this.pattern = this.generatePattern();
    }

    /**
     * @return The pattern of the game.
     * @since 1.0
     */
    public CompleteGuessPart getPattern() {
        return this.pattern;
    }

    /**
     * Sets the <code>pattern</code> field.
     *
     * @param pattern The pattern of the game.
     * @since 1.0
     */
    public void setPattern(CompleteGuessPart pattern) {
        this.pattern = pattern;
    }

    /**
     * @return The piece from where the pattern is generated.
     * @since 1.0
     */
    public ChessMan getMainPiece() {
        return this.mainPiece;
    }

    /**
     * Sets the <code>mainPiece</code> field.
     *
     * @param mainPiece The piece from where the pattern is generated.
     * @since 1.0
     */
    public void setMainPiece(ChessMan mainPiece) {
        this.mainPiece = mainPiece;
    }

    /**
     * @return The player from where the pattern emit.
     * @since 1.0
     */
    public Player getPlayer() {
        return this.player;
    }

    /**
     * Sets the <code>player</code> field.
     *
     * @param player The player from where the pattern emit.
     * @since 1.0
     */
    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * @return The game where the pattern is from.
     * @since 1.0
     */
    public Game getGame() {
        return this.game;
    }

    /**
     * Sets the <code>game</code> field.
     *
     * @param game The game where the pattern is from.
     * @since 1.0
     */
    public void setGame(Game game) {
        this.game = game;
    }

    public Map<Place, ChessMan> getPlaceMap() {
        return placeMap;
    }

    public void setPlaceMap(Map<Place, ChessMan> placeMap) {
        this.placeMap = placeMap;
    }


    //Maybe change with List the 2nd part
    private CompleteGuessPart generatePattern() {
        CompleteGuessPart part = new CompleteGuessPart(player);

        Place[]  places = Place.getAllPiecesOrderByRow();
        int      lastC  = 1, c = 0;
        String[] row    = new String[8];
        for (Place place : places) {
            if (place.getRow() == lastC) {
                ChessMan m = placeMap.get(place);
                row[c] = m == null ? "*" : m.toString();
                c++;
            }
            else {
                c = 1;
                part.setRow(lastC, new Part(Arrays.copyOf(row, row.length), String.valueOf(lastC)));
                row = new String[8];
                lastC = place.getRow();
                ChessMan m = placeMap.get(place);
                row[0] = m == null ? "*" : m.toString();
            }
        }


        return part;
    }
}
