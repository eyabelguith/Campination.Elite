/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campination.gestionsortie.gui;

import campination.gestionsortie.entities.Sortiebalade;
import campination.gestionsortie.services.SortiebaladeServices;
import campination.gestionsortie.services.VipServices;
import campination.gestionsortie.utils.MyConnexion;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.time.LocalDate;
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
 Connection coonx =null;
    Statement st;
    ResultSet rs = null;
    @FXML
    private TextField nomSB;
    public HomeController() {
        coonx = MyConnexion.getInstanceConnex().getConnection();
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       affectationDuTransport  ();
       affectationDudestination ();
        // TODO
    }    

    

    
    
    
  
    



private void affectationDuTransport () {
   
    //system.out.printin (query);
    
    try{
       
       rs = coonx.createStatement().executeQuery("select cinT from transporteur");
       
       ObservableList List = FXCollections.observableArrayList();
     while (rs.next ()) {
         
          List.add (rs.getString (1));
     }
     CBOXtransporteur.setItems(List);
    }catch (Exception ex) {
        System.out.println("error while inserting record. ");
            }
   
    
    
   
            }






private void affectationDudestination () {
   
    //system.out.printin (query);
    
    try{
       
       rs = coonx.createStatement().executeQuery("select * from destination");
       
       ObservableList List = FXCollections.observableArrayList();
     while (rs.next ()) {
         
          List.add (rs.getString (1));
     }
     CBOXdestination.setItems(List);
    }catch (Exception ex) {
        System.out.println("error while inserting record. ");
            }
   
    
    
   
            }

    @FXML
    private void Ajoutersb(ActionEvent event) throws ParseException {
    SortiebaladeServices service = new SortiebaladeServices();
       Sortiebalade s = new Sortiebalade();
        //LocalDate value = Bdatedepart.getValue();
        //LocalDate value1 = BdateR.getValue();
        System.out.println(Bdatedepart.getValue().getYear());
                System.out.println(BdateR.getValue().getYear());
 s.setId_destinationB(Integer.parseInt(  CBOXdestination.getValue().toString()));
        java.sql.Date date=java.sql.Date.valueOf(Bdatedepart.getValue());
        s.setDate_depart(date);
        java.sql.Date date2=java.sql.Date.valueOf(BdateR.getValue());
        s.setDate_retour(date2);
        //s.setDate_depart((TextField)Bdatedepart.getEditor());.getText());
       // s.setDate_depart.setText(String.valueOf(Bdatedepart.getValue()));
    s.setCinT(Integer.parseInt(  CBOXtransporteur.getValue().toString()));
    s.setNom_S(nomSB.getText().toString());
     /*int x=(int)CBOXtransporteur.getValue();
     s.setId_transporteur(x);
      int y=(int)CBOXdestination.getValue();
     s.setId_destinationB(y);*/
      service.ajouterSortiebalade(s);}

    @FXML
    private void gov2(ActionEvent event) {
    try {
            Parent root=FXMLLoader.load(getClass().getResource("HomeAfficheVIP.fxml"));
            Scene scene =new Scene(root);
       Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex1) {
            Logger.getLogger(HomeAfficheVIPController.class.getName()).log(Level.SEVERE, null, ex1);
        }}

    @FXML
    private void returni(ActionEvent event) {
    try {
            Parent root=FXMLLoader.load(getClass().getResource("HomeAfficherSB.fxml"));
            Scene scene =new Scene(root);
       Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex1) {
            Logger.getLogger(HomeAfficherSBController.class.getName()).log(Level.SEVERE, null, ex1);
        }}
}




    

