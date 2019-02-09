package fr.pa1007.chess.chessman;

import fr.pa1007.chess.game.Game;
import fr.pa1007.chess.utils.MovePattern;
import fr.pa1007.chess.utils.Place;
import fr.pa1007.chess.utils.Player;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

public interface ChessMan {

    /**
     * Get the move pattern of a piece
     *
     * @return {@link fr.pa1007.chess.utils.MovePattern MovePattern}
     */
    MovePattern movePattern();

    /**
     * Get the graphic representation of the piece
     *
     * @return {@link javafx.scene.shape.Rectangle Rectangle} the rectangle
     */
    Rectangle getGraphicRep();

    /**
     * The type of the piece
     *
     * @return {@link fr.pa1007.chess.chessman.ChessManType}
     */
    ChessManType type();

    /**
     * Get all remaining piece like this one
     *
     * @return an number of piece remaining like this one
     */
    int remaining();

    /**
     * To get the image of the piece
     *
     * @return {@link javafx.scene.image.Image Image}
     */
    Image getImage();

    /**
     * To get the current place of the piece
     *
     * @return {@link fr.pa1007.chess.utils.Place Place}
     */
    Place place();

    /**
     * Get the number of move done by this piece
     *
     * @return the number of move done
     */
    int movementNumber();

    /**
     * To get the player
     *
     * @return {@link fr.pa1007.chess.utils.Player Player}
     */
    Player getPlayer();

    /**
     * Set the move number
     *
     * @param i the number to set
     */
    void setMoveNumber(int i);

    /**
     * Generate the movement of a the piece, done with the {@link fr.pa1007.chess.utils.Place Place} class
     *
     * @return a tab of Place, with the place <code>P6</code> for given separator
     */
    Place[] generateMovePlace();

    /**
     * Make a special check <strong>BEFORE</strong> the move is made
     *
     * @param game the current game state
     */
    void specialMoveCheckBefore(Game game);

    /**
     * Make a special check <strong>After</strong> the move is made
     *
     * @param game the current game state
     */
    void specialMoveCheckAfter(Game game);
}
