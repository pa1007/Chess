package fr.pa1007.chess.ai.guess.part;

import fr.pa1007.chess.chessman.ChessMan;
import fr.pa1007.chess.utils.Place;
import fr.pa1007.chess.utils.Player;

public class CompleteGuessPart extends GuessPart {


    /**
     * The movement done.
     *
     * @since 1.0
     */
    private Part move;

    public CompleteGuessPart(Player player) {
        super(player);
    }

    /**
     * @return The movement done.
     * @since 1.0
     */
    public Part getMove() {
        return this.move;
    }

    /**
     * Sets the <code>move</code> field.
     *
     * @param move The movement done.
     * @since 1.0
     */
    @Deprecated
    public void setMove(Part move) {
        this.move = move;
    }

    public void setMove(ChessMan start, Place place) {
        move = new Part(new String[]{start.toString(), place.toString()}, "move");
    }

    public void setMove(ChessMan start, String place) {
        move = new Part(new String[]{start.toString(), place}, "move");
    }

    public void setMove(String start, String place) {
        move = new Part(new String[]{start, place}, "move");
    }

    public void setMove(String start, Place place) {
        move = new Part(new String[]{start, place.toString()}, "move");
    }

    /**
     * @return All the game, display in 8 column, 8 row.
     * @since 1.0
     */
    public Part[] getGame() {
        return this.game;
    }


}
