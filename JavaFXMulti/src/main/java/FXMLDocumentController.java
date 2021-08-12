import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class FXMLDocumentController implements Initializable {

    @FXML
    private Label lbl;

    @FXML
    private BorderPane mainPane;

    @FXML
    private void btn1Click(ActionEvent event) {

        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("Form1.fxml");
        mainPane.setCenter(view);
    }

    @FXML
    private void btn2Click(ActionEvent event) {

        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("Form2.fxml");
        mainPane.setCenter(view);
    }

    @FXML
    private void btn3Click(ActionEvent event) {

        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("Form3.fxml");
        mainPane.setCenter(view);
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub

    }


}