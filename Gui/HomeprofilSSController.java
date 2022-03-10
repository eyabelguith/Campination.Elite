/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Campination.App.Gui;

import Campination.App.Entity.Sortiesportif;
import Campination.App.Services.SortiesportifServices;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Eya
 */
public class HomeprofilSSController implements Initializable {

    @FXML
    private TextField t1;
    @FXML
    private TextField t2;
    @FXML
    private TextField t3;
    @FXML
    private TextField t4;
    @FXML
    private TextField t5;
    @FXML
    private TextField t11;
    @FXML
    private TextField t12;
    @FXML
    private Button buttonM;
    @FXML
    private Button button2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void modifier(ActionEvent event) {
    String ps = t11.getText().toString();
        String nb = t1.getText().toString();
        String pl = t2.getText().toString();
        String f = t3.getText().toString();
        String t = t4.getText().toString();
        String u = t5.getText().toString();
        String d = t12.getText().toString();
               SortiesportifServices sp=new SortiesportifServices();
        Sortiesportif p = new Sortiesportif();
       
       
        p.setNom_S(ps);
        p.setNom(nb);
       
        p.setDate_depart( java.sql.Date.valueOf (pl));
        p.setDate_retour(java.sql.Date.valueOf (f));
        p.setType_sport(t);
        p.setCinT(Integer.parseInt(u));
        p.setCinCO(Integer.parseInt(d));
        p.setNom_S(ps);
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
                  alert.setTitle("Information ");
                  alert.setHeaderText("modification du sortie");
                  alert.setContentText("vous approuvez ?");
               
                  if(alert.showAndWait().get()==ButtonType.OK){
                    sp.modifierSortiesportif(p);
                
                
                 
                  }
                  else{
                  alert.close();
                  }}

    @FXML
    private void supprimer2(ActionEvent event) {
     String name=t11.getText().toString();
        SortiesportifServices sp=new SortiesportifServices();
        Sortiesportif p = new Sortiesportif();
        p.setNom_S(name);
       
         
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                  alert.setTitle("Information ");
                  alert.setHeaderText("suppression du sortie");
                  alert.setContentText("vous etes sure?");
                 
                  if(alert.showAndWait().get()==ButtonType.OK){
                       sp.supprimerSortiesportif(p);
                       
            
                  }
                  else{
                  alert.close();
                  }}
    
    
    
  public void send(Sortiesportif s)  {
        t11.setText(s.getNom_S());
        t1.setText(s.getNom());
        t2.setText(String.valueOf(s.getDate_depart()));
        t3.setText(String.valueOf(s.getDate_retour()));
        t4.setText(String.valueOf(s.getType_sport()));
        t5.setText(String.valueOf(s.getCinT()));
       
       t12.setText(String.valueOf(s.getCinCO()));
                }  

}
