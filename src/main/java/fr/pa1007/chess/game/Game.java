package fr.pa1007.chess.game;

import fr.pa1007.chess.ai.algorithm.Simultation;
import fr.pa1007.chess.ai.guess.part.MoveGuessPart;
import fr.pa1007.chess.ai.guess.part.MoveGuessPartIncomplete;
import fr.pa1007.chess.chessman.ChessMan;
import fr.pa1007.chess.chessman.utils.ChessManType;
import fr.pa1007.chess.event.Event;
import fr.pa1007.chess.event.type.EventTypes;
import fr.pa1007.chess.listener.Listener;
import fr.pa1007.chess.listener.game.CheckMatePieceEventListener;
import fr.pa1007.chess.listener.game.CheckPieceEventListener;
import fr.pa1007.chess.listener.game.EatEventListenerEvent;
import fr.pa1007.chess.listener.player.PlayerPlayedListener;
import fr.pa1007.chess.utils.GameStatePattern;
import fr.pa1007.chess.utils.Place;
import fr.pa1007.chess.utils.Player;
import javafx.scene.layout.GridPane;
import java.util.*;

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
    private Player playerToPlayer;

    /**
     * All the listeners, if you want to add some, add them in the constructor
     */
    private Listener[] listeners;

    /**
     * This is the main piece (The more important one) of the white team.
     *
     * @since 1.0
     */
    private ChessMan whiteMain;

    /**
     * This is the main piece (The more important one) of the black team.
     *
     * @since 1.0
     */
    private ChessMan blackMain;

    /**
     * The map that link the place and a chessMan or null if empty
     */
    private Map<Place, ChessMan> map;


    /**
     * The grid of the graphic
     */
    private GridPane grid;

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
        this.whiteMain = game.whiteMain;
        this.blackMain = game.blackMain;
        this.map = game.map;
        this.grid = game.grid;
    }


    /**
     * Main constructor,
     *
     * @param graphicRepresentation all the pieces to use
     * @param grid                  the graphic representation
     */
    public Game(Map<Player, List<ChessMan>> graphicRepresentation, GridPane grid) {
        this.graphic = graphicRepresentation;
        this.grid = grid;
        this.deadMap = new HashMap<>();
        this.generatePlaceMap();
        listeners = new Listener[]{
                new PlayerPlayedListener(this),
                new EatEventListenerEvent(this),
                new CheckMatePieceEventListener(this),
                new CheckPieceEventListener(this)
        };
    }

    /**
     * @return This is the main piece (The more important one) of the white team.
     * @since 1.0
     */
    public ChessMan getWhiteMain() {
        return this.whiteMain;
    }

    /**
     * Sets the <code>whiteMain</code> field.
     *
     * @param whiteMain This is the main piece (The more important one) of the white team.
     * @since 1.0
     */
    public void setWhiteMain(ChessMan whiteMain) {
        this.whiteMain = whiteMain;
    }

    /**
     * @return This is the main piece (The more important one) of the black team.
     * @since 1.0
     */
    public ChessMan getBlackMain() {
        return this.blackMain;
    }

    /**
     * Sets the <code>blackMain</code> field.
     *
     * @param blackMain This is the main piece (The more important one) of the black team.
     * @since 1.0
     */
    public void setBlackMain(ChessMan blackMain) {
        this.blackMain = blackMain;
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
     * @param chess {@link ChessManType ChessManType} The type of the piece search
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
     * @return a player or null if not found
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
     * Method for getting the number of the player at a given place
     *
     * @param p The place you want to test
     * @return 0 if no team or give {@link fr.pa1007.chess.utils.Player#getNumber()} the number of the team
     */
    public int pieceAtThisPlace(Place p) {
        this.generatePlaceMap();
        ChessMan m = map.get(p);
        if (m == null) {
            return 0;
        }
        else {
            return m.getPlayer().getNumber();
        }
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
                    break;
                }
            }
        }
    }

    /**
     * This will simulate a game, and check a lot of things,
     *
     * @param MoveCollection the collection  of {@link MoveGuessPartIncomplete MoveGuessPartIncomplete} you want to simulate
     * @return a simulation with the best MoveGuessPartIncomplete (of the collection) in it
     */
    public Simultation simulate(Collection<MoveGuessPartIncomplete> MoveCollection) {
        System.out.println("Start simulation");
        Map<Integer, MoveGuessPartIncomplete> temp = new HashMap<>();
        int                                   max  = 0;
        for (MoveGuessPartIncomplete mvi : MoveCollection) {
            System.out.println(MoveCollection);
            ChessMan m = mvi.getFrom();
            int      r = validateMove(m, m.place(), mvi.getPlace());
            System.out.println("if the move is validated " + r);
            if (r == 0) {
                List<ChessMan> polist = getActivePieces(getOtherPlayer(m.getPlayer()));
                for (ChessMan t : polist) {
                    if (t.place().is(mvi.getPlace())) {
                        mvi.addPossibleWin(t.getValue());
                        break;
                    }
                }
                int rCheck = checkCheck(mvi.getFrom(), mvi.getPlace());
                System.out.println("If there is a check" + rCheck);
                if (rCheck > 0) {
                    mvi.setMakeCheck();
                    mvi.addPossibleWin(rCheck * 2);
                }
                temp.putIfAbsent(mvi.calPossibleReward(), mvi);
                if (mvi.calPossibleReward() > max) {
                    max = mvi.calPossibleReward();
                }
            }

        }
        MoveGuessPartIncomplete win = temp.get(max);
        int                     z   = 0;
        for (MoveGuessPartIncomplete w : temp.values()) {
            if (w == win) {
                win.setChecked();
                break;
            }
            z++;

        }

        System.out.println("End simulation");
        return new Simultation(z, win, max, 1, true);
    }

    /**
     * Move possible (Check before)
     * This method is for seen if the piece will make check or checkmate
     *
     * @param from  the piece you want to move
     * @param place to the place
     * @return 1 if the piece is check, 2 if check mate, 0 if nothing
     */
    public int checkCheck(ChessMan from, Place place) {
        ChessMan main;
        switch (from.getPlayer().getTeam()) {
            case BLACK:
                main = blackMain;
                break;
            case WHITE:
                main = whiteMain;
                break;
            default:
                throw new NullPointerException("There is an error with the team of the player ! ");
        }
        int     i   = 0;
        Place[] all = main.generateMovePlace();
        for (Place p : all) {
            if (inRangeOf(p, getOtherPlayer(main.getPlayer()))) {
                i++;
            }

        }
        if (inRangeOf(main.place(), getOtherPlayer(main.getPlayer()))) {
            if (i == all.length && i != 0) {
                fireEvent(EventTypes.CHECK_MATE_PIECE_EVENT, main, getActivePieces(getOtherPlayer(from.getPlayer())));
                return 2;
            }
            return 1;
        }
        return 0;
    }

    /**
     * @return the Place's stored map
     */
    public Map<Place, ChessMan> getMap() {
        return map;
    }

    /**
     * To get the place at a given place
     *
     * @param place the place you want to know the {@link ChessMan}
     * @return a chessMan(if found) or null(if not found)
     */
    public ChessMan getPieceAt(Place place) {
        return map.get(place);
    }

    /**
     * <strong>This method is still in WIP</strong>
     * <p>
     * This method will get the best move from a list <br>
     * This will compare them by the totalReward there is in, <br>
     * <em>if everyting is equals, will give a random thing (Will be rework with deep leaning and maybe recusive work) </em>
     * will return the make check ones and where you eat somethings
     * </p>
     *
     * @param all the list of move you want to get
     * @return a {@link MoveGuessPart MoveGuessPart}, who is the <code>BEST</code> one
     */
    public MoveGuessPart getBest(List<MoveGuessPart> all) {
        Map<Integer, List<MoveGuessPart>> range = new HashMap<>();
        int                               max   = Integer.MIN_VALUE;
        for (MoveGuessPart p : all) {
            int i = p.getReward().getTotalWin();
            if (i >= max) {
                max = i;
                if (range.containsKey(max)) {
                    List<MoveGuessPart> l = range.get(max);
                    l.add(p);
                    range.replace(max, l);
                }
                else {
                    List<MoveGuessPart> l = new ArrayList<>();
                    l.add(p);
                    range.put(max, l);
                }
            }
        }
        List<MoveGuessPart> l    = range.get(max);
        int                 size = 0;
        try {
            size = l.size();
        }
        catch (Exception e) {
            System.err.println(max);
            System.err.println(range);
            System.err.println(l);
            System.err.println(all);
            e.printStackTrace();
        }
        if (all.size() == size) {
            return l.get((int) (Math.random() * all.size()));
        }
        if (size == 1) {
            return l.get(0);
        }
        for (MoveGuessPart p : l) {
            if (p.getMeta().contains("makeCheck=true")) {
                return p;
            }
        }
        for (MoveGuessPart p : l) {
            if (p.getMeta().contains("eat=true")) {
                return p;
            }
        }
        return l.get(0);
    }

    /**
     * <strong>This method is still in WIP</strong>
     * <p>
     * With this method the AI will move the piece and throws events like if the player just play,
     * <br> like if we have pressed a button but whit a given move to follow
     * </p>
     *
     * @param p the {@link MoveGuessPart MoveGuessPart} you want to do
     */
    public void make(MoveGuessPart p) {
        System.out.println("Piece moved");
        ChessMan chessMan = p.getFrom();
        grid.getChildren().removeIf(node -> node == chessMan.getGraphicRep());
        grid.add(chessMan.getGraphicRep(), p.getPlace().getColumnNumber(), p.getPlace().getRow() - 1);
        chessMan.place().setRow(p.getPlace().getRow());
        chessMan.place().setColumn(p.getPlace().getColumn());
        chessMan.setMoveNumber(chessMan.movementNumber() + 1);
        ChessMan m = getPieceAt(p.getPlace());
        if (m != null) {
            fireEvent(EventTypes.EAT_CHESS_PIECE_EVENT, chessMan, p.getPlace(), m);
            grid.getChildren().removeIf(node -> m.getGraphicRep() == node);
        }
        System.out.println(chessMan);
    }

    /**
     * This method is here for getting the main piece of a player
     *
     * @param p the player you want to get the main piece
     * @return a black or white king or null if not found
     */
    public ChessMan getMain(Player p) {
        switch (p.getTeam()) {
            case BLACK:
                return blackMain;
            case WHITE:
                return whiteMain;
            default:
                return null;
        }
    }

    /**
     * <strong>This method is still in WIP</strong>
     * <p>
     * This method will test if every piece of a player is in range of the place given
     * </p>
     *
     * @param p           the place you want to know
     * @param otherPlayer the player you want to know if he has the abilities to go to this place
     * @return true if he is in range of, false if not
     */
    public boolean inRangeOf(Place p, Player otherPlayer) {
        List<ChessMan> m = getActivePieces(otherPlayer);
        for (ChessMan man : m) {
            for (Place place : man.generateMovePlace()) {
                if (place.is(p)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @param piece the piece you want to move
     * @param start the place you start
     * @param end   The place you will go
     * @return -3 if the wrong player is playing, -2 if the start place is not the same,
     * -1 if the place is not in range of the piece, 0 if it is possible
     */
    private int validateMove(ChessMan piece, Place start, Place end) {
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

    /**
     * This method is for generating the map of all place / piece or null
     */
    private void generatePlaceMap() {
        Place[]              places = Place.getAllPieces();
        Map<Place, ChessMan> map    = new HashMap<>();
        for (Place place : places) {
            map.put(place, null);
        }
        Collection<List<ChessMan>> col = this.getGraphic().values();
        col.forEach(man -> man.forEach(na -> map.put(na.place(), na)));
        this.map = map;
    }


    public static GameStatePattern getPatternFrom(Player player) {
        return null;
    }
}
