import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class FxmlLoader {

    private Pane view;

    public Pane getPage(String strFileName) {

        URL fileURL = TheStart.class.getResource(strFileName);

        try {
            view = new FXMLLoader().load(fileURL);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return view;
    }
}