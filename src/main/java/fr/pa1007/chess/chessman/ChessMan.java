package fr.pa1007.chess.chessman;

import fr.pa1007.chess.utils.MovePattern;
import fr.pa1007.chess.utils.Place;
import fr.pa1007.chess.utils.Player;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

public interface ChessMan {

    //todo add javadoc

    MovePattern movePattern();

    Rectangle getGraphicRep();

    ChessManType type();

    int remaining();

    Image getImage();

    Place place();

    int movementNumber();

    Player getPlayer();

    void setMoveNumber(int i);

    Place[] generateMovePlace();
}
