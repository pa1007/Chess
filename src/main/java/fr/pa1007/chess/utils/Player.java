package fr.pa1007.chess.utils;

public class Player {


    /**
     * If the player is an ia or nor.
     *
     * @since 1.0
     */
    private boolean ia;

    /**
     * The team of the player.
     *
     * @since 1.0
     */
    private String team;

    public Player(String team) {
        this.team = team;
    }

    /**
     * @return If the player is an ia or nor.
     *
     * @since 1.0
     */
    public boolean getIa() {
        return this.ia;
    }

    /**
     * Sets the <code>ia</code> field.
     *
     * @param ia If the player is an ia or nor.
     *
     * @since 1.0
     */
    public void setIa(boolean ia) {
        this.ia = ia;
    }

    /**
     * @return The team of the player.
     *
     * @since 1.0
     */
    public String getTeam() {
        return this.team;
    }

    /**
     * Sets the <code>team</code> field.
     *
     * @param team The team of the player.
     *
     * @since 1.0
     */
    public void setTeam(String team) {
        this.team = team;
    }

    public String getNumber() {
        return this.team.contains("Black") ? "2" : "1";
    }
}
