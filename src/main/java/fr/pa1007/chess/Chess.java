package fr.pa1007.chess;

import fr.pa1007.chess.controller.GameController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Chess extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fr/pa1007/chess/application/chessMain.fxml"));
        Pane           pane                = loader.load();
        GameController controllerMainTable = loader.getController();
        Stage          stage               = new Stage();
        stage.setScene(new Scene(pane));
        stage.setTitle("Main | Snake");
        stage.setOnCloseRequest((windowEvent) -> {
            Platform.exit();
            System.exit(0);
        });
        stage.show();
    }
}
