package fr.pa1007.chess.ai.guess.part;

public class Part {


    /**
     * All the piece there is on it.
     *
     * @since 1.0
     */
    private String[] pieceOnIt;

    /**
     * The name of the part.
     *
     * @since 1.0
     */
    private String name;

    public Part(String[] pieceOnIt, String name) {
        this.pieceOnIt = pieceOnIt;
        this.name = name;
    }

    /**
     * @return All the piece there is on it.
     *
     * @since 1.0
     */
    public String[] getPieceOnIt() {
        return this.pieceOnIt;
    }

    /**
     * Sets the <code>pieceOnIt</code> field.
     *
     * @param pieceOnIt All the piece there is on it.
     *
     * @since 1.0
     */
    public void setPieceOnIt(String[] pieceOnIt) {
        this.pieceOnIt = pieceOnIt;
    }

    /**
     * @return The name of the part.
     *
     * @since 1.0
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the <code>name</code> field.
     *
     * @param name The name of the part.
     *
     * @since 1.0
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return com.google.common.base.Objects.toStringHelper(this)
                .add("pieceOnIt", pieceOnIt)
                .add("name", name)
                .toString();
    }
}
