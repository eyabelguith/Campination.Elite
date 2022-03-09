/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campination.gestionsortie.gui;

import campination.gestionsortie.entities.VIP;
import campination.gestionsortie.services.VipServices;
import campination.gestionsortie.utils.MyConnexion;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
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
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Eya
 */
public class HomeAjouterVIPController implements Initializable {

    @FXML
    private Button button;
    @FXML
    private ComboBox<?> CBOXcin;
    @FXML
    private ComboBox<?> CBOXnbsb;
    @FXML
    private ComboBox<?> CBOXnbss;
Connection coonx =null;
    Statement st;
    ResultSet rs = null;
    public HomeAjouterVIPController() {
        coonx = MyConnexion.getInstanceConnex().getConnection();
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       affectationDuCin  ();
      affectationDuNbSB  ();
    affectationDuNbSS  (); }    

    @FXML
    private void Ajouter(ActionEvent event) {
      VipServices service = new VipServices();
      VIP s = new VIP ();
   s.setCin(Integer.parseInt( CBOXcin.getValue().toString()));
    
  
     s.setNb_SB(Integer.parseInt(  CBOXnbsb.getValue().toString()));
      s.setNb_SS(Integer.parseInt(  CBOXnbss.getValue().toString()));
   s.getNb_pt();
      service.ajouterSVip(s);
         }

   

    private void affectationDuCin() {
        try{
       
       rs = coonx.createStatement().executeQuery("select cin  from camper");
       
       ObservableList List = FXCollections.observableArrayList();
     while (rs.next ()) {
         
          List.add (rs.getString (1));
          
      //List.add (rs.getString (1),rs.getInt (2),rs.getString (3));
     }
     
     CBOXcin.setItems(List);
   CBOXnbsb.setItems(List);
   CBOXnbss.setItems(List);
    }catch (Exception ex) {
        System.out.println("error while inserting record. ");
            }
   
     }
  
    
    
    
    private void affectationDuNbSS() {
        try{
       
       rs = coonx.createStatement().executeQuery("select nb_SS from camper");
       
       ObservableList List = FXCollections.observableArrayList();
     while (rs.next ()) {
         
          List.add (rs.getString (1));
          
      //List.add (rs.getString (1),rs.getInt (2),rs.getString (3));
     }
     
    
   CBOXnbss.setItems(List);
    }catch (Exception ex) {
        System.out.println("error while inserting record. ");
            }
   
     }

    
    private void affectationDuNbSB() {
        try{
       
       rs = coonx.createStatement().executeQuery("select nb_SB from camper");
       
       ObservableList List = FXCollections.observableArrayList();
     while (rs.next ()) {
         
          List.add (rs.getString (1));
          
      //List.add (rs.getString (1),rs.getInt (2),rs.getString (3));
     }
     
    
   CBOXnbsb.setItems(List);
 
    }catch (Exception ex) {
        System.out.println("error while inserting record. ");
            }
   
     }

    @FXML
    private void gov2(ActionEvent event) {
    }

    @FXML
    private void returni(ActionEvent event) {
     try {
            Parent root=FXMLLoader.load(getClass().getResource("HomeAfficheVIP.fxml"));
            Scene scene =new Scene(root);
       Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(HomeAfficheVIPController.class.getName()).log(Level.SEVERE, null, ex);
        }}

    @FXML
    private void gos(ActionEvent event) {
    try {
            Parent root=FXMLLoader.load(getClass().getResource("choice.fxml"));
            Scene scene =new Scene(root);
       Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ChoiceController.class.getName()).log(Level.SEVERE, null, ex);
        } }

}



