/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Campination.App.Gui;

import Campination.App.Entity.Camper;

import Campination.App.Services.CamperServices;
import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.event.ActionEvent;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;

import javafx.fxml.Initializable;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;


/**
 * FXML Controller class
 *
 * @author Eya
 */
public class InterfaceInfoCamperController implements Initializable {

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
    private TextField txtgov;
    @FXML
    private TextField txtsexe;
    @FXML
    private TextField txtdaten;
    @FXML
    private TextField txtskill;
    @FXML
    private TextField txtrole;
    @FXML
    private TextField txtlogin;
    @FXML
    private TextField txtpwd;
    @FXML
    private TextField txtnbSS;
    @FXML
    private TextField txtnbSB;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
public void inflateUI(Camper camper) throws FileNotFoundException, IOException {
        txtnom.setText(camper.getNom());
        txtprenom.setText(camper.getPrenom());
        txtnumt.setText(String.valueOf(camper.getNum_Tel()));
        txtcin.setText(String.valueOf(camper.getCin()));
        txtemail.setText(camper.getEmail());
        txtgov.setText(camper.getGouvernorat());
        txtsexe.setText(camper.getSexe());
        txtdaten.setText(String.valueOf(camper.getDate_naissance()));
        txtskill.setText(camper.getSkills());
        txtrole.setText(camper.getRole());
        txtlogin.setText(camper.getLogin());
        txtpwd.setText(camper.getPwd());
        txtnbSS.setText(String.valueOf(camper.getNb_SS()));
                txtnbSB.setText(String.valueOf(camper.getNb_SB()));
}
  @FXML
    private void modifier(ActionEvent event) {
          String nom = txtnom.getText();
        String prenom = txtprenom.getText();
        String num = txtnumt.getText().toString();
        String mail = txtemail.getText().toString();
        String date = txtdaten.getText().toString();
        String cin = txtcin.getText().toString();
        String skills = txtskill.getText().toString();
        String gov = txtgov.getText().toString();
        String role=txtrole.getText().toString();
        String login=txtlogin.getText().toString();
        String mdp=txtpwd.getText().toString();
         String SS=txtnbSS.getText().toString();
          String SB=txtnbSB.getText().toString();
        
        
        CamperServices sp=new CamperServices();
        Camper c = new Camper();
       
        c.setNom(nom);
        c.setPrenom(prenom);
        c.setNum_Tel(Integer.parseInt(num));
        c.setEmail(mail);
        c.setDate_naissance(java.sql.Date.valueOf(date)); 
        c.setPwd(mdp);
        c.setLogin(login);
        
        c.setGouvernorat(gov);
        c.setCin(Integer.parseInt(cin));
        c.setSkills(skills);
        c.setNb_SS(Integer.parseInt(SS));
        c.setNb_SB(Integer.parseInt(SB));
        c.setRole(role);
        
        
       
    
        sp.ModifierCamper(c);
         Alert a = new Alert(AlertType.NONE);
        a.setAlertType(AlertType.INFORMATION);
 
                // set content text
                a.setContentText("Modification avec succée !");
 
                // show the dialog
                a.show();
         

    }

  
    }
       

