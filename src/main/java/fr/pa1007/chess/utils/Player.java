package fr.pa1007.chess.utils;

import fr.pa1007.chess.AI;

public class Player {


    /**
     * The instance of the ai if the player is an IA or will be null if not.
     *
     * @since 1.0
     */
    private AI aiInstance;

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
     * @return The instance of the ai if the player is an IA or will be null if not.
     *
     * @since 1.0
     */
    public AI getAiInstance() {
        return this.aiInstance;
    }

    /**
     * @return If the player is an ia or nor.
     *
     * @since 1.0
     */
    public boolean isIa() {
        return this.ia;
    }

    /**
     * Sets the <code>ia</code> field.
     *
     * @param ia If the player is an ia or nor.
     *
     * @since 1.0
     */
    public void setIa(boolean ia, AI instance) {
        this.ia = ia;
        this.aiInstance = instance;
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
