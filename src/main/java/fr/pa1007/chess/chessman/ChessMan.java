package fr.pa1007.chess.chessman;

import fr.pa1007.chess.utils.Pattern;
import fr.pa1007.chess.utils.Place;
import fr.pa1007.chess.utils.Player;
import fr.pa1007.chess.utils.Type;
import javafx.scene.image.Image;

public interface ChessMan {

    Pattern movePattern(Player player);

    void move();

    Type type();

    int remaining();

    Image getImage();

    Place place();
}
