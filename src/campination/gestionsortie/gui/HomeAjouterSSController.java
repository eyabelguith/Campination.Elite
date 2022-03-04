/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campination.gestionsortie.gui;

import campination.gestionsortie.entities.Sortiesportif;
import campination.gestionsortie.services.SortiesportifServices;
import campination.gestionsortie.utils.MyConnexion;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
 
/**
 * FXML Controller class
 *
 * @author Eya
 */
public class HomeAjouterSSController implements Initializable {
Connection coonx =null;
    Statement st;
    ResultSet rs = null;
 public HomeAjouterSSController() {
        coonx = MyConnexion.getInstanceConnex().getConnection();
    }
    @FXML
    private Button button;
    @FXML
    private ComboBox<?> CBOXdestination2;
    @FXML
    private ComboBox<?> CBOXcoach;
    @FXML
    private DatePicker Bdatedepart2;
    @FXML
    private DatePicker BdateR2;
    @FXML
    private ComboBox CBOXtypeSport;
    @FXML
    private ComboBox<?> CBOXtransporteur2;
private ComboBox choixS;
ObservableList<String> choix=FXCollections.observableArrayList("yoga","natation","skie","gymnastique");    
/**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        affectationDudestination ();
        affectationDuTransport  ();
        affectationDuCoach ();
       CBOXtypeSport.setItems(choix) ;
    }    

    @FXML
    private void Ajouterss(ActionEvent event) {
    SortiesportifServices service = new SortiesportifServices();
     Sortiesportif s = new Sortiesportif();
        //LocalDate value = Bdatedepart.getValue();
        //LocalDate value1 = BdateR.getValue();
        System.out.println(Bdatedepart2.getValue().getYear());
                System.out.println(BdateR2.getValue().getYear());
 s.setId_destinationS(Integer.parseInt(  CBOXdestination2.getValue().toString()));
        java.sql.Date date=java.sql.Date.valueOf(Bdatedepart2.getValue());
        s.setDate_depart(date);
        java.sql.Date date2=java.sql.Date.valueOf(BdateR2.getValue());
        s.setDate_retour(date2);
        //s.setDate_depart((TextField)Bdatedepart.getEditor());.getText());
       // s.setDate_depart.setText(String.valueOf(Bdatedepart.getValue()));
    s.setId_transporteur(Integer.parseInt(  CBOXtransporteur2.getValue().toString()));
    s.setId_coach(Integer.parseInt(  CBOXcoach.getValue().toString()));
    String x=(String)CBOXtypeSport.getValue();
    s.setType_sport(x);
    
     /*int x=(int)CBOXtransporteur.getValue();
     s.setId_transporteur(x);
      int y=(int)CBOXdestination.getValue();
     s.setId_destinationB(y);*/
      service.ajouterSortiesportif(s);}

    private void affectationDudestination() {
        try{
       
       rs = coonx.createStatement().executeQuery("select * from destination");
       
       ObservableList List = FXCollections.observableArrayList();
     while (rs.next ()) {
         
          List.add (rs.getString (1));
     }
     CBOXdestination2.setItems(List);
    }catch (Exception ex) {
        System.out.println("error while inserting record. ");
            }
         }

    private void affectationDuTransport() {
     try{
       
       rs = coonx.createStatement().executeQuery("select * from transporteur");
       
       ObservableList List = FXCollections.observableArrayList();
     while (rs.next ()) {
         
          List.add (rs.getString (1));
     }
     CBOXtransporteur2.setItems(List);
    }catch (Exception ex) {
        System.out.println("error while inserting record. ");
            }    }

    private void affectationDuCoach() {
        try{
       
       rs = coonx.createStatement().executeQuery("select * from coach");
       
       ObservableList List = FXCollections.observableArrayList();
     while (rs.next ()) {
         
          List.add (rs.getString (1));
     }
     CBOXcoach.setItems(List);
    }catch (Exception ex) {
        System.out.println("error while inserting record. ");
            }}

    @FXML
    private void gov2(ActionEvent event) {
    }

    @FXML
    private void returni(ActionEvent event) {
    }

}

    

   

  

  
    
    
    
    
    
