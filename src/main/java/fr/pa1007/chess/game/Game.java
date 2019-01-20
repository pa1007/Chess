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

    private Map<Player, List<ChessMan>> graphic;
    private Map<Player, List<ChessMan>> deadMap;
    private Player                      playerToPlayer;
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
    }

    /**
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

    public Map<Player, List<ChessMan>> getGraphic() {
        return graphic;
    }

    public List<ChessMan> getActivePieces(Player player) {
        return graphic.getOrDefault(player, null);
    }

    public int remaining(ChessManType chess) {
        return 0;
    }

    public Player getOtherPlayer(Player player) {
        for (Player player1 : graphic.keySet()) {
            if (player != player1) {
                return player1;
            }
        }
        return null;
    }

    public Map<Player, List<ChessMan>> getDead() {
        return this.deadMap;
    }

    public Player getPlayerToPlayer() {
        return playerToPlayer;
    }

    public void setPlayerToPlayer(Player playerToPlayer) {
        this.playerToPlayer = playerToPlayer;
    }

    public void fireEvent(Class<? extends Event> e, Object... objects) {
        for (Listener listener : listeners) {
            for (Class<?> c : listener.getClass().getInterfaces()) {
                if (c.equals(e)) {
                    listener.fire(objects);
                }
            }
        }
    }

    public static GameStatePattern getPatternFrom(Player player) {
        return null;
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
}
