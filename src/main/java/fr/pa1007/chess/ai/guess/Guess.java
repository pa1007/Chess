package fr.pa1007.chess.ai.guess;

import fr.pa1007.chess.ai.builder.GuessBuilder;
import fr.pa1007.chess.chessman.ChessMan;
import fr.pa1007.chess.utils.Place;

public class Guess {

    /**
     * To get the builder
     */
    public final static GuessBuilder BUILDER = new GuessBuilder();

    /**
     * The result you have, raw.
     *
     * @since 1.0
     */
    private int[][] rawResult;

    /**
     * The piece you move.
     *
     * @since 1.0
     */
    private ChessMan piece;

    /**
     * The movement pattern.
     *
     * @since 1.0
     */
    private GuessPattern movePattern;

    /**
     * The ending place.
     *
     * @since 1.0
     */
    private Place end;

    /**
     * The starting place.
     *
     * @since 1.0
     */
    private Place start;

    /**
     * The number of the geuss it is.
     *
     * @since 1.0
     */
    private int guessNumber;


    /**
     * The reward attacht to it.
     *
     * @since 1.0
     */
    private Reward reward;

    public Guess(
            int[][] rawResult,
            ChessMan piece,
            GuessPattern movePattern,
            Place end,
            Place start,
            int guessNumber,
            Reward reward
    ) {
        this.rawResult = rawResult;
        this.piece = piece;
        this.movePattern = movePattern;
        this.end = end;
        this.start = start;
        this.guessNumber = guessNumber;
        this.reward = reward;
    }

    /**
     * @return The reward attacht to it.
     *
     * @since 1.0
     */
    public Reward getReward() {
        return this.reward;
    }

    /**
     * Sets the <code>reward</code> field.
     *
     * @param reward The reward attacht to it.
     *
     * @since 1.0
     */
    public void setReward(Reward reward) {
        this.reward = reward;
    }

    /**
     * @return The result you have, raw.
     *
     * @since 1.0
     */
    public int[][] getRawResult() {
        return this.rawResult;
    }

    /**
     * Sets the <code>rawResult</code> field.
     *
     * @param rawResult The result you have, raw.
     *
     * @since 1.0
     */
    public void setRawResult(int[][] rawResult) {
        this.rawResult = rawResult;
    }

    /**
     * @return The piece you move.
     *
     * @since 1.0
     */
    public ChessMan getPiece() {
        return this.piece;
    }

    /**
     * Sets the <code>piece</code> field.
     *
     * @param piece The piece you move.
     *
     * @since 1.0
     */
    public void setPiece(ChessMan piece) {
        this.piece = piece;
    }

    /**
     * @return The movement pattern.
     *
     * @since 1.0
     */
    public GuessPattern getGuessPattern() {
        return this.movePattern;
    }

    /**
     * Sets the <code>movePattern</code> field.
     *
     * @param movePattern The movement pattern.
     *
     * @since 1.0
     */
    public void setGuessPattern(GuessPattern movePattern) {
        this.movePattern = movePattern;
    }

    /**
     * @return The ending place.
     *
     * @since 1.0
     */
    public Place getEnd() {
        return this.end;
    }

    /**
     * Sets the <code>end</code> field.
     *
     * @param end The ending place.
     *
     * @since 1.0
     */
    public void setEnd(Place end) {
        this.end = end;
    }

    /**
     * @return The starting place.
     *
     * @since 1.0
     */
    public Place getStart() {
        return this.start;
    }

    /**
     * Sets the <code>start</code> field.
     *
     * @param start The starting place.
     *
     * @since 1.0
     */
    public void setStart(Place start) {
        this.start = start;
    }

    /**
     * @return The number of the geuss it is.
     *
     * @since 1.0
     */
    public int getGuessNumber() {
        return this.guessNumber;
    }

    /**
     * Sets the <code>guessNumber</code> field.
     *
     * @param guessNumber The number of the geuss it is.
     *
     * @since 1.0
     */
    public void setGuessNumber(int guessNumber) {
        this.guessNumber = guessNumber;
    }

    @Override
    public String toString() {
        return com.google.common.base.Objects.toStringHelper(this)
                .add("rawResult", rawResult)
                .add("piece", piece)
                .add("movePattern", movePattern)
                .add("end", end)
                .add("start", start)
                .add("guessNumber", guessNumber)
                .add("reward", reward)
                .toString();
    }
}
