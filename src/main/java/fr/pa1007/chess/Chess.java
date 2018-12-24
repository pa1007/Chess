package fr.pa1007.chess;

import fr.pa1007.chess.controller.GameController;
import fr.pa1007.chess.utils.exception.ChessOutOfBoundException;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.PrintWriter;
import java.io.StringWriter;

public class Chess extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fr/pa1007/chess/application/chessMain.fxml"));
        Pane           pane                = loader.load();
        GameController controllerMainTable = loader.getController();
        Stage          stage               = new Stage();
        stage.setScene(new Scene(pane));
        stage.setTitle("Main | Chess");
        stage.setResizable(false);
        stage.setOnCloseRequest((windowEvent) -> {
            Platform.exit();
            System.exit(0);
        });
        stage.show();
        controllerMainTable.init();
    }

    public static void createExceptionAlert(ChessOutOfBoundException e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Dialog");
        alert.setHeaderText(e.getMessage());
        StringWriter sw = new StringWriter();
        PrintWriter  pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        TextArea textArea = new TextArea(sw.toString());
        textArea.setEditable(false);
        textArea.setWrapText(true);
        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);
        alert.getDialogPane().setExpandableContent(textArea);
        alert.show();
    }
}
