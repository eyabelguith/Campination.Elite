/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Campination.App.Gui;

import Campination.App.Entity.Camper;
import Campination.App.Entity.Coach;
import Campination.App.Services.CamperServices;
import Campination.App.Services.CoachServices;
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
public class InterfaceInfoCoachController implements Initializable {
   @FXML
    private TextField txtnom;
    @FXML
    private TextField txtprenom;
    @FXML
    private TextField txtnumt;
    @FXML
    private TextField txtcin;
    @FXML
    private TextField txtemail;
    @FXML
    private TextField txtGov;
    @FXML
    private TextField txtsexe;
    @FXML
    private TextField txtTypeS;
    @FXML
    private TextField txtrole;
    @FXML
    private TextField txtlogin;
    @FXML
    private TextField txtpwd;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
      
public void inflateUI(Coach coach) throws FileNotFoundException, IOException {
        txtnom.setText(coach.getNom());
        txtprenom.setText(coach.getPrenom());
        txtnumt.setText(String.valueOf(coach.getNum_Tel()));
        txtcin.setText(String.valueOf(coach.getCinCO()));
        txtemail.setText(coach.getEmail());
        txtGov.setText(coach.getGouvernorat());
        txtsexe.setText(coach.getSexe());
      txtTypeS.setText(coach.getType_sport());
        txtrole.setText(coach.getRole());
        txtlogin.setText(coach.getLogin());
        txtpwd.setText(coach.getPwd());
    
}

    @FXML
    private void modif(ActionEvent event) {
             String nom = txtnom.getText();
        String prenom = txtprenom.getText();
        String num = txtnumt.getText().toString();
        String mail = txtemail.getText();
    String types = txtTypeS.getText();
        String cin = txtcin.getText().toString();
      String sexe=txtsexe.getText();
        String gov = txtGov.getText();
        String role=txtrole.getText();
        String login=txtlogin.getText();
        String mdp=txtpwd.getText();
        
        
        CoachServices sp=new CoachServices();
        Coach c = new Coach();
       
        c.setNom(nom);
        c.setPrenom(prenom);
        c.setNum_Tel(Integer.parseInt(num));
        c.setEmail(mail);
        c.setType_sport(types);
        c.setPwd(mdp);
        c.setLogin(login);
        c.setSexe(sexe);
        
        c.setGouvernorat(gov);
        c.setCinCO(Integer.parseInt(cin));
      
        
        c.setRole(role);
        
        
       
    
        sp.ModifierCoach(c);
         Alert a = new Alert(Alert.AlertType.NONE);
        a.setAlertType(Alert.AlertType.INFORMATION);
 
                // set content text
                a.setContentText("Modification avec succée !");
 
                // show the dialog
                a.show();
         
    }

    
}
    /*private void modifier(ActionEvent event) {
          String nom = txtnom.getText();
        String prenom = txtprenom.getText();
        String num = txtnumt.getText().toString();
        String mail = txtemail.getText();
    String types = txtTypeS.getText();
        String cin = txtcin.getText().toString();
      String sexe=txtsexe.getText();
        String gov = txtGov.getText();
        String role=txtrole.getText();
        String login=txtlogin.getText();
        String mdp=txtpwd.getText();
        
        
        CoachServices sp=new CoachServices();
        Coach c = new Coach();
       
        c.setNom(nom);
        c.setPrenom(prenom);
        c.setNum_Tel(Integer.parseInt(num));
        c.setEmail(mail);
        c.setType_sport(types);
        c.setPwd(mdp);
        c.setLogin(login);
        c.setSexe(sexe);
        
        c.setGouvernorat(gov);
        c.setCin(Integer.parseInt(cin));
      
        
        c.setRole(role);
        
        
       
    
        sp.ModifierCoach(c);
         Alert a = new Alert(Alert.AlertType.NONE);
        a.setAlertType(Alert.AlertType.INFORMATION);
 
                // set content text
                a.setContentText("Modification avec succée !");
 
                // show the dialog
                a.show();
         

    }*/

