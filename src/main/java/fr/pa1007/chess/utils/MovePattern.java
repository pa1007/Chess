package fr.pa1007.chess.utils;

import fr.pa1007.chess.chessman.ChessMan;

public class MovePattern {


    /**
     * The pattern.
     *
     * @since 1.0
     */
    private String   pattern;
    /**
     * The pattern of the game.
     *
     * @since 1.0
     */
    private ChessMan piece;

    public MovePattern(ChessMan chessMan) {
        this.piece = chessMan;
        this.pattern = generatePattern();
    }

    /**
     * Return a string with a pattern;
     *
     * @return return a string with the info in :
     * <ul>
     * <li><strong>|</strong> Can move just 1 case up</li>
     * <li><strong>||</strong> Can move just 2 case up</li>
     * <li><strong>H</strong> Can move just around him (1 case) in every direction</li>
     * <li><strong>X</strong> Can move only with the diagonal in every direction</li>
     * <li><strong>E</strong> Can only move on a direct line in every direction</li>
     * <li><strong>L</strong> Can do a <code>L</code> shape around him in every direction</li>
     * <li><strong>XE</strong> Can do a diagonal and direct line move in every direction</li>
     * </ul>
     * Can also return a " " which means there is an error
     */
    public String getPattern() {
        this.pattern = generatePattern();
        return this.pattern;
    }

    /**
     * Sets the <code>pattern</code> field.
     *
     * @param pattern The pattern.
     *
     * @since 1.0
     */
    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    /**
     * @return The pattern of the game.
     *
     * @since 1.0
     */
    public ChessMan getPiece() {
        return this.piece;
    }

    /**
     * Sets the <code>piece</code> field.
     *
     * @param piece The pattern of the game.
     *
     * @since 1.0
     */
    public void setPiece(ChessMan piece) {
        this.piece = piece;
    }

    /**
     * Geneate a string with a pattern
     *
     * @return return a string with the info in :
     * <ul>
     * <li><strong>|</strong> Can move just 1 case up</li>
     * <li><strong>||</strong> Can move just 2 case up</li>
     * <li><strong>H</strong> Can move just around him (1 case) in every direction</li>
     * <li><strong>X</strong> Can move only with the diagonal in every direction</li>
     * <li><strong>E</strong> Can only move on a direct line in every direction</li>
     * <li><strong>L</strong> Can do a <code>L</code> shape around him in every direction</li>
     * <li><strong>XE</strong> Can do a diagonal and direct line move in every direction</li>
     * </ul>
     * Can also return a " " which means there is an error
     */
    private String generatePattern() {
        switch (this.piece.type()) {
            case PAW:
                return this.piece.movementNumber() == 0 ? "||" : "|";
            case KING:
                return "H";
            case QUEEN:
                return "XE";
            case ROOKS:
                return "E";
            case BISHOP:
                return "X";
            case KNIGHT:
                return "L";
            default:
                return " ";
        }
    }
}
