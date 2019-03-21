package fr.pa1007.chess;

import fr.pa1007.chess.ai.algorithm.Algorithm;
import fr.pa1007.chess.ai.guess.GuessPattern;
import fr.pa1007.chess.ai.guess.part.MoveGuessPart;
import fr.pa1007.chess.chessman.ChessMan;
import fr.pa1007.chess.event.type.EventTypes;
import fr.pa1007.chess.game.Game;
import fr.pa1007.chess.utils.Place;
import fr.pa1007.chess.utils.Player;
import java.util.ArrayList;
import java.util.List;

public class AI {

    /**
     * This give a direct link into the API where all the move will be referenced
     */
    private final static String apiURl = "http://www.pa1007.fr/ia/api/";

    /**
     * This give a direct link to the Upload Part for adding new record into the API, need registration before for
     * no "False" things created
     */
    private final static String uploadURL = "http://www.pa1007.fr/ia/put.php";

    /**
     * The player the AI represent.
     *
     * @since 1.0
     */
    private Player player;
    /**
     * The game instance.
     *
     * @since 1.0
     */
    private Game   game;

    public AI(Player player, Game game) {
        this.player = player;
        this.game = game;
    }

    /**
     * @return The player the AI represent.
     * @since 1.0
     */
    public Player getPlayer() {
        return this.player;
    }

    /**
     * Sets the <code>player</code> field.
     *
     * @param player The player the AI represent.
     * @since 1.0
     */
    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * @return The game instance.
     * @since 1.0
     */
    public Game getGame() {
        return this.game;
    }

    /**
     * Sets the <code>game</code> field.
     *
     * @param game The game instance.
     * @since 1.0
     */
    public void setGame(Game game) {
        this.game = game;
    }

    public void play() {
        List<MoveGuessPart> all = new ArrayList<>();

        int malus  = 0;
        int rCheck = game.checkCheck(game.getMain(player), new Place("P6"));
        if (rCheck > 0) {
            malus += 1000;
        }

        if (game.inRangeOf(game.getMain(player).place(), game.getOtherPlayer(player))) {
            malus += 3;
        }

        for (ChessMan man : game.getActivePieces(player)) {
            Algorithm     alg = new Algorithm(game, man, malus);
            MoveGuessPart mgp = alg.getBestMove();
            if (mgp != null) {
                all.add(mgp);
            }
        }
        MoveGuessPart p = game.getBest(all);
        game.make(p);
        game.fireEvent(EventTypes.PLAYER_PLAYED_EVENT, p.getFrom().getPlayer(), p.getFrom(), p.getPlace());
    }

    private GuessPattern checkAPI(String game, String team, String enemy) {
        return null;
    }

}
