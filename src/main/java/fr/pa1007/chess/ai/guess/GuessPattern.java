package fr.pa1007.chess.ai.guess;

import fr.pa1007.chess.ai.guess.part.CompleteGuessPart;
import fr.pa1007.chess.ai.guess.part.EnemyGuessPart;
import fr.pa1007.chess.ai.guess.part.MoveGuessPart;
import fr.pa1007.chess.ai.guess.part.TeamGuessPart;

public class GuessPattern {


    /**
     * The team placement pattern.
     *
     * @since 1.0
     */
    private TeamGuessPart team;

    /**
     * The entire pattern.
     *
     * @since 1.0
     */
    private CompleteGuessPart all;

    /**
     * The enemy pattern.
     *
     * @since 1.0
     */
    private EnemyGuessPart enemy;

    /**
     * The move to do.
     *
     * @since 1.0
     */
    private MoveGuessPart move;

    public GuessPattern(TeamGuessPart team, EnemyGuessPart enemy, MoveGuessPart move) {
        this.team = team;
        this.enemy = enemy;
        this.move = move;
    }

    public GuessPattern(CompleteGuessPart all) {
        this.all = all;
    }

    /**
     * @return The move to do.
     *
     * @since 1.0
     */
    public MoveGuessPart getMove() {
        return this.move;
    }

    /**
     * Sets the <code>move</code> field.
     *
     * @param move The move to do.
     *
     * @since 1.0
     */
    public void setMove(MoveGuessPart move) {
        this.move = move;
    }

    /**
     * @return The enemy pattern.
     *
     * @since 1.0
     */
    public EnemyGuessPart getEnemy() {
        return this.enemy;
    }

    /**
     * Sets the <code>enemy</code> field.
     *
     * @param enemy The enemy pattern.
     *
     * @since 1.0
     */
    public void setEnemy(EnemyGuessPart enemy) {
        this.enemy = enemy;
    }

    /**
     * @return The team placement pattern.
     *
     * @since 1.0
     */
    public TeamGuessPart getTeam() {
        return this.team;
    }

    /**
     * Sets the <code>team</code> field.
     *
     * @param team The team placement pattern.
     *
     * @since 1.0
     */
    public void setTeam(TeamGuessPart team) {
        this.team = team;
    }

    /**
     * @return The entire pattern.
     *
     * @since 1.0
     */
    public CompleteGuessPart getAll() {
        return this.all;
    }

    /**
     * Sets the <code>all</code> field.
     *
     * @param all The entire pattern.
     *
     * @since 1.0
     */
    public void setAll(CompleteGuessPart all) {
        this.all = all;
    }
}
