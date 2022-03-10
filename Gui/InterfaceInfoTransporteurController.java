/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Campination.App.Gui;

import Campination.App.Entity.Transporteur;
import Campination.App.Services.TransporteurServices;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Eya
 */
public class InterfaceInfoTransporteurController implements Initializable {
@FXML
    private TextField txtnom;

    @FXML
    private TextField txtnumt;
    @FXML
    private TextField txtcin;
  
    @FXML
    private TextField txtGov;
    @FXML
    private TextField txtT;
    @FXML
    private TextField txtC;
    @FXML
    private TextField txtM;
  
    @FXML
    private TextField txtdispo;
    @FXML
    private TextField txtRole;
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

      
public void inflateUI(Transporteur transporteur) throws FileNotFoundException, IOException {
        txtnom.setText(transporteur.getNom());
              txtnumt.setText(String.valueOf(transporteur.getNum_tel()));
        txtcin.setText(String.valueOf(transporteur.getCinT()));
    txtT.setText(transporteur.getMoyenT());
    txtM.setText(transporteur.getMatricule());
    txtC.setText(String.valueOf(transporteur.getCapacite()));
        txtGov.setText(transporteur.getGouvernorat());
     txtdispo.setText(transporteur.getDisponibilite());
     
        txtRole.setText(transporteur.getRole());
    
}


    @FXML
    private void modiff(ActionEvent event) {
         String nom = txtnom.getText();
   
        String num = txtnumt.getText().toString();
 
 
        String cin = txtcin.getText().toString();

        String capacite = txtC.getText().toString();
        String gov = txtGov.getText();
         String T = txtT.getText();
          String matricule = txtM.getText();
        String role=txtRole.getText();
             String dispo=txtdispo.getText();
             
      
        
        
        TransporteurServices sp=new TransporteurServices();
        Transporteur t = new Transporteur();
       
        t.setNom(nom);
     
        t.setNum_tel(Integer.parseInt(num));
        t.setDisponibilite(dispo);
        t.setMatricule(matricule);
        t.setCapacite(Integer.parseInt(capacite));
         t.setMoyenT(T);
        t.setGouvernorat(gov);
        t.setCinT(Integer.parseInt(cin));
      
        
        t.setRole(role);
        
        
       
    
        sp.ModifierTransporteur(t);
         Alert a = new Alert(Alert.AlertType.NONE);
        a.setAlertType(Alert.AlertType.INFORMATION);
 
                // set content text
                a.setContentText("Modification avec succée !");
 
                // show the dialog
                a.show();
    }
}
