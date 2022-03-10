/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Campination.App.Gui;

import Campination.App.Entity.Sortiebalade;
import Campination.App.Services.SortiebaladeServices;
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
public class HomeprofilSBController implements Initializable {

    @FXML
    private TextField t5;
    @FXML
    private TextField t4;
    private TextField t3;
    @FXML
    private TextField t2;
    @FXML
    private TextField t1;
    @FXML
    private TextField txtemt3ail;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          // TODO
    }    
    void inflateUI(Sortiebalade sortiebalade) {
           t1.setText(sortiebalade.getNom_S());
           t2.setText(sortiebalade.getNom());
           t3.setText(String.valueOf(sortiebalade.getDate_depart()));
           t4.setText(String.valueOf(sortiebalade.getDate_retour()));
           t5.setText(String.valueOf(sortiebalade.getCinT()));
    }
    @FXML
    private void supprimer(ActionEvent event) { 
        String name=t1.getText().toString();
        SortiebaladeServices sp=new SortiebaladeServices();
        Sortiebalade p = new Sortiebalade();
        p.setNom_S(name);
       
         
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                  alert.setTitle("Information ");
                  alert.setHeaderText("suppression du sortie");
                  alert.setContentText("vous etes sure?");
                 
                  if(alert.showAndWait().get()==ButtonType.OK){
                       sp.supprimerSortiebalade(p);
                       
            
                  }
                  else{
                  alert.close();
                  }
    }

    @FXML
    private void modifier(ActionEvent event) {
     String ps = t1.getText().toString();
        String nb = t2.getText().toString();
        String pl = t3.getText().toString();
        String f = t4.getText().toString();
        String t = t5.getText().toString();
        
               SortiebaladeServices sp=new SortiebaladeServices();
       Sortiebalade p = new Sortiebalade();
       
       
        p.setNom_S(ps);
        p.setNom(nb);
       
        p.setDate_depart( java.sql.Date.valueOf (pl));
        p.setDate_retour(java.sql.Date.valueOf (f));
        p.setCinT(Integer.parseInt(t));
     
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
                  alert.setTitle("Information Dialog");
                  alert.setHeaderText("Modifying Team");
                  alert.setContentText("Are you sure you want to modify ?");
               
                  if(alert.showAndWait().get()==ButtonType.OK){
                    sp.modifierSortiebalade(p);
                
                
                 
                  }
                  else{
                  alert.close();
                  }}
    
 


      
      
}
