package fr.pa1007.chess.ai.algorithm;

import fr.pa1007.chess.ai.guess.part.MoveGuessPartIncomplete;

public class Simultation {


    /**
     * The id of the simulation (the number of simulation defore this one).
     *
     * @since 1.0
     */
    private int id;

    /**
     * The move from the simulation.
     *
     * @since 1.0
     */
    private MoveGuessPartIncomplete from;

    /**
     * all the point earn from the move down.
     *
     * @since 1.0
     */
    private int earn;

    /**
     * <strong>NOT USE NOW</strong> the depth of the move.
     *
     * @since 1.0
     */
    private int depth;

    /**
     * Is this move possible ?.
     *
     * @since 1.0
     */
    private boolean possible;

    public Simultation(int id, MoveGuessPartIncomplete from, int earn, int depth, boolean possible) {
        this.id = id;
        this.from = from;
        this.earn = earn;
        this.depth = depth;
        this.possible = possible;
    }

    /**
     * @return The id of the simulation (the number of simulation defore this one).
     * @since 1.0
     */
    public int getId() {
        return this.id;
    }

    /**
     * Sets the <code>id</code> field.
     *
     * @param id The id of the simulation (the number of simulation defore this one).
     * @since 1.0
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return The move from the simulation.
     * @since 1.0
     */
    public MoveGuessPartIncomplete getFrom() {
        return this.from;
    }

    /**
     * Sets the <code>from</code> field.
     *
     * @param from The move from the simulation.
     * @since 1.0
     */
    public void setFrom(MoveGuessPartIncomplete from) {
        this.from = from;
    }

    /**
     * @return all the point earn from the move down.
     * @since 1.0
     */
    public int getEarn() {
        return this.earn;
    }

    /**
     * Sets the <code>earn</code> field.
     *
     * @param earn all the point earn from the move down.
     * @since 1.0
     */
    public void setEarn(int earn) {
        this.earn = earn;
    }

    /**
     * @return <strong>NOT USE NOW</strong> the depth of the move.
     * @since 1.0
     */
    public int getDepth() {
        return this.depth;
    }

    /**
     * Sets the <code>depth</code> field.
     *
     * @param depth <strong>NOT USE NOW</strong> the depth of the move.
     * @since 1.0
     */
    public void setDepth(int depth) {
        this.depth = depth;
    }

    /**
     * @return Is this move possible ?.
     * @since 1.0
     */
    public boolean getPossible() {
        return this.possible;
    }

    /**
     * Sets the <code>possible</code> field.
     *
     * @param possible Is this move possible ?.
     * @since 1.0
     */
    public void setPossible(boolean possible) {
        this.possible = possible;
    }
}
