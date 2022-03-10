/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Campination.App.Gui;

import Campination.App.Entity.Admin;
import Campination.App.Entity.Transporteur;
import Campination.App.Services.AdminServices;
import static Campination.App.Services.AdminServices.infoBox;
import Campination.App.Services.TransporteurServices;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Eya
 */
public class InterfaceProfilsController implements Initializable {
   
    @FXML
    private AnchorPane navbar;
    @FXML
    private Button navItem;
    @FXML
    private AnchorPane anchor;
    @FXML
    private AnchorPane anchor2;
    @FXML
    private Button logoutbtn1;
    @FXML
    private AnchorPane anchor31;
    @FXML
    private Label noml;
    @FXML
    private Label emailL;
    @FXML
    private Label pwd;
    @FXML
    private Button btnM;
    @FXML
    private AnchorPane anchor3;
     Admin a;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
       
       for( int i=0; i<des().size(); i++){
           noml.setText(des().get(i).getNom());
          pwd.setText(des().get(i).getPwd());
          emailL.setText(des().get(i).getLogin());
       }
      
       
       
       Admin a;
    
    }    

    @FXML
    private void logout(ActionEvent event) {
         logoutbtn1.setOnAction(e -> {
            
   try {
            Parent root=FXMLLoader.load(getClass().getResource("login.fxml"));
            Scene scene =new Scene(root);
       Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
});
    }

    @FXML
    private void modifier(ActionEvent event) {
    }
    public ObservableList<Admin> des(){
        AdminServices As = new AdminServices();
        ObservableList<Admin> Admins = FXCollections.observableArrayList(As.AfficherAdmin());
              
     return Admins;   
    }

    @FXML
    private void gouser(ActionEvent event) {
                     try {
            Parent root=FXMLLoader.load(getClass().getResource("acceuil.fxml"));
            Scene scene =new Scene(root);
       Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AcceuilController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void goTransporteur(ActionEvent event) {
         try {
            Parent root=FXMLLoader.load(getClass().getResource("InterfaceListTransporteur.fxml"));
            Scene scene =new Scene(root);
       Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(InterfaceListTransporteurController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  }
    

