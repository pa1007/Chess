package fr.pa1007.chess.game;

import fr.pa1007.chess.chessman.ChessMan;
import fr.pa1007.chess.chessman.ChessManType;
import fr.pa1007.chess.event.Event;
import fr.pa1007.chess.listener.Listener;
import fr.pa1007.chess.listener.game.EatEventListenerEvent;
import fr.pa1007.chess.listener.player.PlayerPlayedListener;
import fr.pa1007.chess.utils.GameStatePattern;
import fr.pa1007.chess.utils.Place;
import fr.pa1007.chess.utils.Player;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {

    /**
     * The graphic representation of the game
     */
    private Map<Player, List<ChessMan>> graphic;
    /**
     * The death list of piece
     */
    private Map<Player, List<ChessMan>> deadMap;
    /**
     * The player who need to play
     */
    private Player                      playerToPlayer;
    /**
     * All the listeners, if you want to add some, add them in the constructor
     */
    private Listener[]                  listeners;

    /**
     * Constructor for copping a game
     *
     * @param game the game to copy from
     */
    public Game(Game game) {
        this.graphic = new HashMap<>(game.graphic);
        this.deadMap = new HashMap<>(game.deadMap);
        this.playerToPlayer = game.playerToPlayer;
        this.listeners = game.listeners;
    }

    /**
     * Main constructor,
     *
     * @param graphicRepresentation all the pieces to use
     */
    public Game(Map<Player, List<ChessMan>> graphicRepresentation) {
        this.graphic = graphicRepresentation;
        this.deadMap = new HashMap<>();
        listeners = new Listener[]{
                new PlayerPlayedListener(this),
                new EatEventListenerEvent(this)
        };
    }

    /**
     * Getter of all the piece from the game, stored by player
     *
     * @return all the piece object
     */
    public Map<Player, List<ChessMan>> getGraphic() {
        return graphic;
    }

    /**
     * Get a list of the active piece of a player
     *
     * @param player The player to get the pieces
     * @return list of piece or null if the player doesn't exist
     */
    public List<ChessMan> getActivePieces(Player player) {
        return graphic.getOrDefault(player, null);
    }

    /**
     * Get all the remaining similar piece on the board
     *
     * @param chess {@link fr.pa1007.chess.chessman.ChessManType ChessManType} The type of the piece search
     * @return a number of the remaining piece like the one in param
     */
    public int remaining(ChessManType chess) {
        int i = 0;
        for (List<ChessMan> mans : getGraphic().values()) {
            for (ChessMan man : mans) {
                if (man.type().equals(chess)) {
                    i++;
                }
            }
        }
        return i;
    }

    /**
     * To get the enemy of a given player
     *
     * @param player the {@link fr.pa1007.chess.utils.Player Player} you want the enemy
     * @return a player
     */
    public Player getOtherPlayer(Player player) {
        for (Player player1 : graphic.keySet()) {
            if (player != player1) {
                return player1;
            }
        }
        return null;
    }

    /**
     * Get all the dead pieces of the game
     *
     * @return a map of list, stored by player
     */
    public Map<Player, List<ChessMan>> getDead() {
        return this.deadMap;
    }

    /**
     * @return The current player to play
     */
    public Player getPlayerToPlayer() {
        return playerToPlayer;
    }

    /**
     * Setter of the player that will need to play
     *
     * @param playerToPlayer the player that need to play
     */
    public void setPlayerToPlayer(Player playerToPlayer) {
        this.playerToPlayer = playerToPlayer;
    }

    /**
     * Method used for fired event
     * <br>
     * <strong>WILL BE CHANGE LATER</strong>
     *
     * @param e       The event you want to launch
     * @param objects All the object given for running the thing
     */
    public void fireEvent(Class<? extends Event> e, Object... objects) {
        for (Listener listener : listeners) {
            for (Class<?> c : listener.getClass().getInterfaces()) {
                if (c.equals(e)) {
                    listener.fire(objects);
                }
            }
        }
    }

    public int validateMove(ChessMan piece, Place start, Place end) {
        if (piece.getPlayer() != playerToPlayer) {
            return -3;
        }
        if (!piece.place().equals(start)) {
            return -2;
        }
        for (Place place : piece.generateMovePlace()) {
            if (place.equals(end)) {
                return 0;
            }
        }
        return -1;
    }

    public static GameStatePattern getPatternFrom(Player player) {
        return null;
    }
}
