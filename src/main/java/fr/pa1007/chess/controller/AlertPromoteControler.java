package fr.pa1007.chess.controller;

import fr.pa1007.chess.chessman.utils.ChessManType;
import fr.pa1007.chess.chessman.pieces.Paw;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AlertPromoteControler {

    public  ImageView queenI;
    public  ImageView bishopI;
    public  ImageView knightI;
    public  ImageView rookI;
    private Paw       paw;

    public void init(Paw paw) {
        this.paw = paw;
        queenI.setImage(new Image("fr/pa1007/chess/display/"
                                  + paw.getPlayer().getTeamName().toLowerCase()
                                  + "/Queen.png"));
        bishopI.setImage(new Image("fr/pa1007/chess/display/"
                                   + paw.getPlayer().getTeamName().toLowerCase()
                                   + "/Bishop.png"));
        knightI.setImage(new Image("fr/pa1007/chess/display/"
                                   + paw.getPlayer().getTeamName().toLowerCase()
                                   + "/Knight.png"));
        rookI.setImage(new Image("fr/pa1007/chess/display/"
                                 + paw.getPlayer().getTeamName().toLowerCase()
                                 + "/Rook.png"));

    }

    public void queenHandler(MouseEvent mouseEvent) {
        paw.promote(ChessManType.QUEEN);
        closeStage(mouseEvent);
    }

    public void rookHandler(MouseEvent mouseEvent) {
        paw.promote(ChessManType.ROOKS);
        closeStage(mouseEvent);
    }

    public void bishiopHandler(MouseEvent mouseEvent) {
        paw.promote(ChessManType.BISHOP);
        closeStage(mouseEvent);
    }

    public void knightHandler(MouseEvent mouseEvent) {
        paw.promote(ChessManType.KNIGHT);
        closeStage(mouseEvent);
    }

    private void closeStage(MouseEvent event) {
        Node  source = (Node) event.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
    }
}
