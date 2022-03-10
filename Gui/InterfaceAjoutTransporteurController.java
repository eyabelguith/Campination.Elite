/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Campination.App.Gui;

import Campination.App.Entity.Transporteur;

import Campination.App.Services.TransporteurServices;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Eya
 */
public class InterfaceAjoutTransporteurController implements Initializable {

    @FXML
    private AnchorPane navbar;
    @FXML
    private Button navItem;
    @FXML
    private Button button;
    @FXML
    private TextField nom;
    @FXML
    private TextField cin;

    @FXML
    private TextField num_tel;
    @FXML
    private TextField go;

    @FXML
    private TextField cap;
    @FXML
    private TextField mat;
    @FXML
    private ComboBox role;
    @FXML
    private AnchorPane anchor;
    @FXML
    private ComboBox dispo;
    @FXML
    private AnchorPane anchor2;
    @FXML
    private Button logoutbtn1;
    @FXML
    private ComboBox transp;
    ObservableList<String> ListT = FXCollections.observableArrayList("Bus", "Mini Bus", "Louage");
    ObservableList<String> ListR = FXCollections.observableArrayList("Admin", "Transporteur", "Coach");
    ObservableList<String> ListD = FXCollections.observableArrayList("OUI", "NON");

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO 
        transp.setItems(ListT);
        dispo.setItems(ListD);

        role.setItems(ListR);
    }

    @FXML
    private void AjouterTransporteur(ActionEvent event) {
        TransporteurServices ts = new TransporteurServices();
        Transporteur t = new Transporteur();
        t.setNom(nom.getText());
        t.setCinT(Integer.parseInt(cin.getText()));
        t.setNum_tel(Integer.parseInt(num_tel.getText()));
        t.setGouvernorat(go.getText());
        // t.setMoyenT(transp.getText());
        String x = (String) transp.getValue();
        t.setMoyenT(x);
        t.setCapacite(Integer.parseInt(cap.getText()));
        // t.setDisponibilite(dispo.getText());
        String z = (String) dispo.getValue();
        t.setDisponibilite(z);
        t.setMatricule(mat.getText());
        String y = (String) role.getValue();
        t.setRole(y);
        //  t.setRole(role.getText());

        ts.AjouterTranporteur(t);

        try {
            Parent root = FXMLLoader.load(getClass().getResource("InterfaceListTransporteur.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);

            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(InterfaceListTransporteurController.class.getName()).log(Level.SEVERE, null, ex);
        }

        Annuler();
    }

    private void Annuler() {
        nom.clear();
        cin.clear();

        num_tel.clear();
        go.clear();

        mat.clear();

    }

    @FXML
    private void retourner(ActionEvent event) {

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

    @FXML
    private void logout(ActionEvent event) {
        logoutbtn1.setOnAction(e -> {

            try {
                Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

}
