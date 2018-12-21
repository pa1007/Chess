package fr.pa1007.chess.utils;

public class Place {


    /**
     * The name of the place composed of a Letter and a number.
     *
     * @since 1.0
     */
    private String name;

    public Place(String s) {
        this.name = s;
    }

    /**
     * @return The name of the place composed of a Letter and a number.
     *
     * @since 1.0
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the <code>name</code> field.
     *
     * @param name The name of the place composed of a Letter and a number.
     *
     * @since 1.0
     */
    public void setName(String name) {
        this.name = name;
    }

    public static void transformGridToPlace() {

    }
}
