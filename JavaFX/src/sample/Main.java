package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception{
        Pane mainPane = (Pane) FXMLLoader.load(
                Main.class.getResource("sample.fxml"));
        stage.setScene(new Scene(mainPane));
        stage.show();
    }



}
