package fr.pa1007.chess.ai.guess;

public final class Reward {


    /**
     * The number the AI really win.
     *
     * @since 1.0
     */
    private final int totalReward;

    /**
     * The total of point "Lose" from the action.
     *
     * @since 1.0
     */
    private final int totalLose;

    /**
     * The total "Gain" from the action.
     *
     * @since 1.0
     */
    private final int totalWin;

    public Reward(int totalLose, int totalWin) {
        this.totalLose = totalLose;
        this.totalWin = totalWin;
        this.totalReward = totalWin - totalLose;
    }

    /**
     * @return The number the AI realy win.
     *
     * @since 1.0
     */
    public int getTotalReward() {
        return this.totalReward;
    }


    /**
     * @return The total of point "Lose" from the action.
     *
     * @since 1.0
     */
    public int getTotalLose() {
        return this.totalLose;
    }

    /**
     * @return The total "Gain" from the action.
     *
     * @since 1.0
     */
    public int getTotalWin() {
        return this.totalWin;
    }

    @Override
    public String toString() {
        return com.google.common.base.Objects.toStringHelper(this)
                .add("totalReward", totalReward)
                .add("totalLose", totalLose)
                .add("totalWin", totalWin)
                .toString();
    }
}
