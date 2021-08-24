package Controllers;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;


public class FXMLDocumentController implements Initializable {

    FxmlLoader loader = new FxmlLoader();

    @FXML
    private BorderPane mainPane;

    @FXML
    private TextField txtFirstName;

    @FXML
    private TextField txtLastName;

    @FXML
    private TextField txtUserName;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtEmail;

    @FXML
    private Button btnCreateAccount;

    @FXML
    private TextField txtUserNameLogin;

    @FXML
    private TextField txtPasswordLogin;

    @FXML
    private TextArea txtInfo;


    @FXML
    private void onClickLoginPage(ActionEvent event) {
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

    @FXML
    private void onClickLogin() throws SQLException {
        String userName = null;
        String password = null;
        String dbUserName = null;
        String dbPassword = null;
        String dbFirst = null;
        String dbLast = null;
        String dbEmail = null;
        StringBuilder sb = new StringBuilder();


        if (!txtUserNameLogin.getText().isEmpty() && !txtPasswordLogin.getText().isEmpty()){
            userName = txtUserNameLogin.getText();
            password = txtPasswordLogin.getText();

            ResultSet db = DB.selectPersonAccount(password, userName);

            while (db.next()){
                dbFirst = db.getString(1);
                dbLast = db.getString(2);
                dbUserName =  db.getString(3);
                dbEmail = db.getString(4);
                dbPassword = db.getString(5);
            }

            if (userName.equals(dbUserName) && password.equals(dbPassword)) {
                sb.append("Welcome ").append(dbFirst + " " + dbLast + "\n");
                sb.append("User Name: ").append(dbUserName).append("\n");
                sb.append("Email: ").append(dbEmail);
                txtInfo.setText(sb.toString());
            } else {
                txtInfo.setText("Incorrect User Name or Password");
            }
        } else {
            txtInfo.setText("You cannot leave Login areas Blank");
        }
        txtUserNameLogin.clear();
        txtPasswordLogin.clear();
    }

    @FXML
    private void onClickCreateAccount () {
        String FirstName = txtFirstName.getText();
        String LastName = txtLastName.getText();
        String UserName = txtUserName.getText();
        String Email = txtEmail.getText();
        String Password = txtPassword.getText();
        DB.insertPerson(FirstName, LastName, UserName, Email, Password );
        txtFirstName.clear();
        txtLastName.clear();
        txtUserName.clear();
        txtEmail.clear();
        txtPassword.clear();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }





}