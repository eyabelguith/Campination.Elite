/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Campination.App.Gui;

import Campination.App.Entity.Sortiebalade;
import Campination.App.Entity.Sortiesportif;
import Campination.App.Services.SortiebaladeServices;
import Campination.App.Services.SortiesportifServices;
import Campination.App.Util.MyConnexion;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;

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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Eya
 */
public class HomeController implements Initializable {

    @FXML
    private Button button;
    @FXML
    private ComboBox<?> CBOXdestination;
    @FXML
    private ComboBox<?> CBOXtransporteur;
    @FXML
    private DatePicker Bdatedepart;
    @FXML
    private DatePicker BdateR;
    Connection coonx = null;
    Statement st;
    ResultSet rs = null;
    @FXML
    private TextField nomSB;
    @FXML
    private Button users;
    @FXML
    private Button dest;
    @FXML
    private Button mag;
    @FXML
    private Button eventt;
    @FXML
    private Button sortie;
    @FXML
    private Button transp;
    @FXML
    private Button vip;
    @FXML
    private AnchorPane anchor1;
    @FXML
    private AnchorPane anchor2;
    @FXML
    private Button logoutbtn1;
    @FXML
    private Button button2;

    public HomeController() {
          coonx = MyConnexion.getInstanceConnex().getConnection();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        affectationDuTransport();
        affectationDudestination();
        // TODO
    }

    private void affectationDuTransport() {

      try {

            rs = coonx.createStatement().executeQuery("select cinT from transporteur");

            ObservableList List = FXCollections.observableArrayList();
            while (rs.next()) {

                List.add(rs.getString(1));
            }
            CBOXtransporteur.setItems(List);
        } catch (Exception ex) {
            System.out.println("error while inserting record. ");
        }

    }

    private void affectationDudestination() {
 try {

            rs = coonx.createStatement().executeQuery("SELECT nom FROM `destination` WHERE type='balade'");

            ObservableList List = FXCollections.observableArrayList();
            while (rs.next()) {

                List.add(rs.getString(1));
            }
            CBOXdestination.setItems(List);
        } catch (Exception ex) {
            System.out.println("error while inserting record. ");
        }

    }

    @FXML
    private void Ajoutersb(ActionEvent event) throws ParseException {
       SortiebaladeServices service = new SortiebaladeServices();
        Sortiebalade s= new Sortiebalade();
 
        java.sql.Date date = java.sql.Date.valueOf(Bdatedepart.getValue());
        s.setDate_depart(date);
        java.sql.Date date2 = java.sql.Date.valueOf(BdateR.getValue());
        s.setDate_retour(date2);
 
        s.setCinT(Integer.parseInt(CBOXtransporteur.getValue().toString()));
  
        s.setNom_S(nomSB.getText().toString());
  String d = (String) CBOXdestination.getValue();
        s.setNom_S(d);
        service.ajouterSortiebalade(s);
 
        
    }

    private void gov2(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("HomeAfficheVIP.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex1) {
            Logger.getLogger(HomeAfficheVIPController.class.getName()).log(Level.SEVERE, null, ex1);
        }
    }

    @FXML
    private void returni(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("HomeAfficherSB.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex1) {
            Logger.getLogger(HomeAfficherSBController.class.getName()).log(Level.SEVERE, null, ex1);
        }
    }

    @FXML
    private void goAcceuil(ActionEvent event) {
    }

    @FXML
    private void godest(ActionEvent event) {
    }

    @FXML
    private void goMag(ActionEvent event) {
    }

    @FXML
    private void goevent(ActionEvent event) {
    }

    @FXML
    private void gosortie(ActionEvent event) {
    }

    @FXML
    private void goTransp(ActionEvent event) {
    }

    @FXML
    private void goVip(ActionEvent event) {
    }

    @FXML
    private void logout(ActionEvent event) {
    }

    @FXML
    private void annuler(ActionEvent event) {
    }
}
