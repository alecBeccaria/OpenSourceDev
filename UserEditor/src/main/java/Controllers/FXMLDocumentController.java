package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;


public class FXMLDocumentController implements Initializable {

    FxmlLoader loader = new FxmlLoader();

    @FXML
    private Label lbl;

    @FXML
    private BorderPane mainPane;

    @FXML
    private TextField FirstName;

    @FXML
    private TextField LastName;

    @FXML
    private TextField UserName;

    @FXML
    private TextField Email;


    @FXML
    private void onClickLogin(ActionEvent event) {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("Login.fxml");
        mainPane.setCenter(view);
    }

    @FXML
    private void onClickAccount(ActionEvent event) {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("Account.fxml");
        mainPane.setCenter(view);
    }

    @FXML
    private void onClickHome(ActionEvent event) {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("Home.fxml");
        mainPane.setCenter(view);
    }

    @FXML private void onClickLogin2() {

    }

    @FXML
    private void onClickCreateAccount () {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }





}