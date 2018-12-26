package fr.pa1007.chess.utils;

import fr.pa1007.chess.chessman.ChessMan;
import fr.pa1007.chess.game.Game;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
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
    private String               pattern;
    private Map<Place, ChessMan> placeMap;

    public GameStatePattern(Game game, Player player, ChessMan chessMan) {
        this.game = new Game(game);
        this.player = player;
        this.mainPiece = chessMan;
        this.placeMap = this.generatePlaceMap();
        this.pattern = this.generatePattern();
    }

    /**
     * @return The pattern of the game.
     *
     * @since 1.0
     */
    public String getPattern() {
        return this.pattern;
    }

    /**
     * Sets the <code>pattern</code> field.
     *
     * @param pattern The pattern of the game.
     *
     * @since 1.0
     */
    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    /**
     * @return The piece from where the pattern is generated.
     *
     * @since 1.0
     */
    public ChessMan getMainPiece() {
        return this.mainPiece;
    }

    /**
     * Sets the <code>mainPiece</code> field.
     *
     * @param mainPiece The piece from where the pattern is generated.
     *
     * @since 1.0
     */
    public void setMainPiece(ChessMan mainPiece) {
        this.mainPiece = mainPiece;
    }

    /**
     * @return The player from where the pattern emit.
     *
     * @since 1.0
     */
    public Player getPlayer() {
        return this.player;
    }

    /**
     * Sets the <code>player</code> field.
     *
     * @param player The player from where the pattern emit.
     *
     * @since 1.0
     */
    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * @return The game where the pattern is from.
     *
     * @since 1.0
     */
    public Game getGame() {
        return this.game;
    }

    /**
     * Sets the <code>game</code> field.
     *
     * @param game The game where the pattern is from.
     *
     * @since 1.0
     */
    public void setGame(Game game) {
        this.game = game;
    }

    private Map<Place, ChessMan> generatePlaceMap() {
        Place[]              places = Place.getAllPieces();
        Map<Place, ChessMan> map    = new HashMap<>();
        for (Place place : places) {
            map.put(place, null);
        }
        Collection<List<ChessMan>> col = game.getGraphic().values();
        for (List<ChessMan> man : col) {
            for (ChessMan na : man) {
                map.put(na.place(), na);
            }
        }
        return map;
    }

    private String generatePattern() {
        Place[]       places = Place.getAllPiecesOrderByRow();
        StringBuilder sb     = new StringBuilder();

        for (Place place : places) {
            sb.append(this.placeMap.get(place) == null ? "*" : this.placeMap.get(place));
            sb.append(place.is("H1")
                      || place.is("H2")
                      || place.is("H3")
                      || place.is("H4")
                      || place.is("H5")
                      || place.is("H6")
                      || place.is("H7")
                      || place.is("H8") ? place.is("H8") ? "!" : "," : "-");
        }


        return sb.toString();
    }
}
