package sample;
import javafx.fxml.*;
imp
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Window;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private TextField txt;

    @FXML
    private Label lbl;

    @FXML
    private Button btn;

    @FXML
    private Pane rootPane;

    int intClicker = 0;

    @FXML
    private void onSubmitClick(ActionEvent event){
        Window owner = btn.getScene().getWindow();
        intClicker = intClicker + 1;
        btn.setText("Clicked: " + intClicker);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
