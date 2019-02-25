package fr.pa1007.chess.utils;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Place {


    /**
     * The name of the place composed of a Letter and a number.
     *
     * @since 1.0
     */
    private String name;


    /**
     * The column character.
     *
     * @since 1.0
     */
    private String column;
    /**
     * The row number.
     *
     * @since 1.0
     */
    private int    row;


    public Place(String s) {
        this.name = s.toUpperCase();
        generatePlace();
    }

    public Place(String name, int row) {
        this.column = name.toUpperCase();
        this.row = row;
        this.name = column + this.row;
    }

    /**
     * @return The column character.
     * @since 1.0
     */
    public String getColumn() {
        return this.column;
    }

    /**
     * Sets the <code>column</code> field.
     *
     * @param column The column character.
     * @since 1.0
     */
    public void setColumn(String column) {
        this.name = this.name.replaceFirst(this.column, column);
        this.column = column;
    }

    /**
     * @return The row number.
     * @since 1.0
     */
    public int getRow() {
        return this.row;
    }

    /**
     * Sets the <code>row</code> field.
     *
     * @param row The row number.
     * @since 1.0
     */
    public void setRow(int row) {
        this.name = this.name.replaceFirst(String.valueOf(this.row), String.valueOf(row));
        this.row = row;
    }

    /**
     * @return The name of the place composed of a Letter and a number.
     * @since 1.0
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the <code>name</code> field.
     *
     * @param name The name of the place composed of a Letter and a number.
     * @since 1.0
     */
    public void setName(String name) {
        this.name = name;
        generatePlace();
    }

    /**
     * This method give you the current place with the moved of row and column add in parameters <br>
     * The column is between "A" and "H", the row is between 1 and 8
     *
     * @param row    the amount of row to move from max 7
     * @param column the amount of column to move from max 7
     * @return a new place with the moved column and row or P8 if the place is outside the board
     */
    public Place more(int row, int column) {
        int tempR = this.row + row;
        int tempC = (int) this.column.toLowerCase().charAt(0) + column;
        if (tempR > 8 || tempR < 1) {
            return new Place("P8");
        }
        if (tempC > 104 || tempC < 97) {
            return new Place("P8");
        }
        return new Place(String.valueOf(Character.valueOf((char) tempC)), tempR);
    }


    /**
     * @return
     */
    public int getColumnNumber() {
        return column.toLowerCase().charAt(0) - 'a';
    }

    /**
     * @return
     */
    public Place[] getLines() {
        Place[] places     = new Place[8 * 4];
        int     placeCount = 0;
        for (int i = 1; i != 8; i++) {
            places[placeCount] = more(0, i);
            placeCount++;
        }
        places[placeCount] = new Place("P6");
        placeCount++;
        for (int i = 1; i != 8; i++) {
            places[placeCount] = more(i, 0);
            placeCount++;
        }
        places[placeCount] = new Place("P6");
        placeCount++;
        for (int i = 1; i != 8; i++) {
            places[placeCount] = more(0, -i);
            placeCount++;
        }
        places[placeCount] = new Place("P6");
        placeCount++;
        for (int i = 1; i != 8; i++) {
            places[placeCount] = more(-i, 0);
            placeCount++;
        }
        places[placeCount] = new Place("P6");
        return places;
    }

    /**
     * @return
     */
    public Place[] getDiagonal() {
        Place[] places     = new Place[8 * 4];
        int     placeCount = 0;
        for (int i = 1; i != 8; i++) {
            places[placeCount] = more(i, i);
            placeCount++;
        }
        places[placeCount] = new Place("P6");
        placeCount++;
        for (int i = 1; i != 8; i++) {
            places[placeCount] = more(i, -i);
            placeCount++;
        }
        places[placeCount] = new Place("P6");
        placeCount++;
        for (int i = 1; i != 8; i++) {
            places[placeCount] = more(-i, i);
            placeCount++;
        }
        places[placeCount] = new Place("P6");
        placeCount++;
        for (int i = 1; i != 8; i++) {
            places[placeCount] = more(-i, -i);
            placeCount++;
        }
        places[placeCount] = new Place("P6");
        return places;
    }

    /**
     * @return
     */
    public Place[] getPlaceAround() {
        Place[] places = new Place[8];
        places[0] = more(-1, -1);
        places[1] = more(-1, 1);
        places[2] = more(-1, 0);
        places[3] = more(0, -1);
        places[4] = more(0, 1);
        places[5] = more(1, -1);
        places[6] = more(1, 0);
        places[7] = more(1, 1);
        return places;
    }

    /**
     * @return
     */
    public Place[] getKnightMove() {
        Place[] places = new Place[8];
        places[0] = this.more(2, 1);
        places[1] = this.more(2, -1);
        places[2] = this.more(-2, -1);
        places[3] = this.more(-2, 1);
        places[4] = this.more(1, 2);
        places[5] = this.more(-1, 2);
        places[6] = this.more(-1, -2);
        places[7] = this.more(1, -2);
        return places;
    }

    /**
     * @param p6
     * @return
     */
    public boolean is(String p6) {
        return name.equals(p6.toUpperCase());
    }

    /**
     * @param place
     * @return
     */
    public boolean is(Place place) {
        return name.equalsIgnoreCase(place.name);
    }

    /**
     * @return
     */
    public Place[] getDiagonalBlackPaw() {
        Place[] places = new Place[2];
        places[0] = this.more(-1, -1);
        places[1] = this.more(-1, 1);
        return places;
    }

    /**
     * @return
     */
    public Place[] getDiagonalWhitePaw() {
        Place[] places = new Place[2];
        places[0] = this.more(1, 1);
        places[1] = this.more(1, -1);
        return places;
    }

    /**
     * @return
     */
    public Place[] getDiagonalErrorPaw() {
        Place[] places = new Place[2];
        places[0] = new Place("P6");
        places[1] = new Place("P6");
        return places;
    }

    /**
     * @return
     */
    public Place[] getQueenMove() {
       return Place.getAll(this.getLines(), this.getDiagonal());
    }

    /**
     *
     */
    private void generatePlace() {
        column = String.valueOf(name.charAt(0));
        row = Character.digit(name.charAt(1), 10);
    }

    /**
     * @return
     */
    public static Place[] getAllPieces() {
        String[] apha   = new String[]{"A", "B", "C", "D", "E", "F", "G", "H"};
        Place[]  places = new Place[64];
        int      c      = 0;
        for (int i = 0; i < 8; i++) {
            for (int z = 1; z < 9; z++) {
                places[c] = new Place(apha[i], z);
                c++;
            }
        }
        return places;
    }

    /**
     * @return
     */
    public static Place[] getAllPiecesOrderByRow() {
        Place[]  places = new Place[64];
        String[] apha   = new String[]{"A", "B", "C", "D", "E", "F", "G", "H"};
        int      c      = 0;
        for (int i = 1; i < 9; i++) {
            for (int z = 0; z < 8; z++) {
                places[c] = new Place(apha[z], i);
                c++;
            }
        }
        return places;

    }

    /**
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Place)) {
            return false;
        }
        Place place = (Place) o;
        return row == place.row &&
               Objects.equal(name, place.name) &&
               Objects.equal(column, place.column);
    }

    /**
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(name, column, row);
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return name;
    }

    /**
     * @param lines
     * @param diagonal
     * @return
     */
    public static Place[] getAll(Place[] lines, Place[] diagonal) {
        List<Place> places = new ArrayList<>(Arrays.asList(lines));
        places.addAll(Arrays.asList(diagonal));
        return places.toArray(new Place[0]);
    }
}
