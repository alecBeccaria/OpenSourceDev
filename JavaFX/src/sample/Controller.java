package sample;
import javafx.fxml.*;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Window;
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
    private Pane rootpane;

    int intClickCounter = 0;

    @FXML
    void onSubmitClick(javafx.event.ActionEvent event) {

        Window owner = btn.getScene().getWindow();

        intClickCounter = intClickCounter + 1;
        btn.setText("clicked: " + intClickCounter);
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
    }

}
