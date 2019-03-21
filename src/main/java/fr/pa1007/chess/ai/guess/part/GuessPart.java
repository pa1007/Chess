package fr.pa1007.chess.ai.guess.part;

import fr.pa1007.chess.utils.Player;

/**
 * Just for linking all the part to them-self
 */
public abstract class GuessPart {

    public static final String MOVE_LINE_SEPARATOR = "";

    /**
     * All the game, display in 8 column, 8 row.
     *
     * @since 1.0
     */
    protected Part[] game;


    /**
     * The player this is the enemy .
     *
     * @since 1.0
     */
    protected Player playerFrom;

    public GuessPart(Player playerFrom) {
        this.game = new Part[8];
        this.playerFrom = playerFrom;
    }


    /**
     * Sets the <code>game</code> field.
     *
     * @param game All the game, display in 8 column, 8 row.
     * @since 1.0
     */
    public void setGame(Part[] game) {
        this.game = game;
    }

    /**
     * Set the row with a given part
     *
     * @param row  the int, must be under 8 and with a min of 0
     * @param part the part add on
     */
    public void setRow(int row, Part part) {
        game[row] = part;
    }

    /**
     * @return The player this is the enemy .
     * @since 1.0
     */
    public Player getPlayerFrom() {
        return this.playerFrom;
    }

    /**
     * Sets the <code>playerFrom</code> field.
     *
     * @param playerFrom The player this is the enemy .
     * @since 1.0
     */
    public void setPlayerFrom(Player playerFrom) {
        this.playerFrom = playerFrom;
    }
}
