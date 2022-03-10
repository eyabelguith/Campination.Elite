/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Campination.App.Gui;

import Campination.App.Entity.Admin;
import Campination.App.Services.AdminServices;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author farouk
 */
public class LoginController implements Initializable {

    final TextField textField = new TextField();
    @FXML
    private AnchorPane anchor;
    @FXML
    private TextField loginfx;
    private TextField pwdfx;
    @FXML
    private PasswordField pass;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void loginbtn(ActionEvent event) throws IOException {

        String login = loginfx.getText().toString();
        String pwd = pass.getText().toString();

        textField.setVisible(false);

        AdminServices se = new AdminServices();
        Admin a = new Admin();
        a.setLogin(login);
        a.setPwd(pwd);

        if (se.login(a) == 1) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("acceuil.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(AcceuilController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @FXML
    private void annulerbtn(ActionEvent event) {
    }

}
