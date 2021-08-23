package Controllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        DBController.testConnection();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root, 800, 400);
        stage.setTitle("User Editor");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
