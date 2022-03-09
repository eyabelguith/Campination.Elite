/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campination.gestionsortie.gui;

import campination.gestionsortie.entities.Sortiebalade;
import campination.gestionsortie.services.SortiebaladeServices;
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
    private Button button11;
    @FXML
    private Button buttonM;
    @FXML
    private TextField t5;
    @FXML
    private TextField t4;
    @FXML
    private TextField t3;
    @FXML
    private TextField t2;
    @FXML
    private TextField t1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
        p.setId_destinationB(Integer.parseInt(nb));
       
        p.setDate_depart( java.sql.Date.valueOf (pl));
        p.setDate_retour(java.sql.Date.valueOf (f));
        p.setCinT(Integer.parseInt(t));
        p.setNom_S(ps);
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
    
      public void send(Sortiebalade s)  {
        t1.setText(s.getNom_S());
        t2.setText(String.valueOf(s.getId_destinationB()));
        t3.setText(String.valueOf(s.getDate_depart()));
        t4.setText(String.valueOf(s.getDate_retour()));
        t5.setText(String.valueOf(s.getCinT()));
       
       
                }
      
      
}
