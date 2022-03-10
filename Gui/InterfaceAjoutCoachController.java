/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Campination.App.Gui;

import Campination.App.Entity.Coach;
import Campination.App.Services.CoachServices;
import Campination.App.Util.MailerService;

import java.io.IOException;
import java.net.URL;
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

import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Eya
 */
public class InterfaceAjoutCoachController implements Initializable {

    @FXML
    private AnchorPane navbar;
    @FXML
    private Button navItem;
    @FXML
    private TextField nomTxt;
    @FXML
    private TextField cinTxt;
    @FXML
    private TextField prenomTxt;
    @FXML
    private TextField EmailTxt;
    @FXML
    private TextField numTelTxt;

    @FXML
    private TextField pwdTxt;

    @FXML
    private TextField gouvT;
    @FXML
    private Text login;
    @FXML
    private TextField loginT;
    private Parent fxml;
    @FXML
    private Button button;
    @FXML
    private Button btnBack;
    @FXML
    private AnchorPane anchor;
    @FXML
    private ComboBox sexebox;
    @FXML
    private ComboBox sportBox;
    @FXML
    private ComboBox RoleBox;
    @FXML
    private AnchorPane anchor2;
    @FXML
    private Button logoutbtn;
    private static String path;
    ObservableList<String> ListSexe = FXCollections.observableArrayList("Femme", "Homme");
    ObservableList<String> ListSport = FXCollections.observableArrayList("Yoga", "Natation", "Cyclisme", "golf", "canoë-kayak", "kite surf", "athlétisme");
    ObservableList<String> ListD = FXCollections.observableArrayList("Coach", "Transporteur");

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        FileChooser fileChooser=new FileChooser();
        sexebox.setItems(ListSexe);
        sportBox.setItems(ListSport);
        RoleBox.setItems(ListD);
     /*   photo.setOnAction(action->{
            Stage stage=new Stage();
            File selectedFile = fileChooser.showOpenDialog(stage);
             path=selectedFile.getPath();
            
        });*/
    }

    @FXML
    private void AjouterCoach(ActionEvent event) {
        CoachServices co = new CoachServices();
        Coach c = new Coach();
        c.setNom(nomTxt.getText());
        c.setPrenom(prenomTxt.getText());
        c.setEmail(EmailTxt.getText());
        c.setNum_Tel(Integer.parseInt(numTelTxt.getText()));
        c.setCinCO(Integer.parseInt(cinTxt.getText()));
        c.setGouvernorat(gouvT.getText());
   
        c.setLogin(loginT.getText());
        c.setPwd(pwdTxt.getText());

        String x = (String) sexebox.getValue();
        c.setSexe(x);
        String y = (String) sportBox.getValue();
        c.setType_sport(y);
        String z = (String) RoleBox.getValue();
        c.setRole(z);

        co.AjouterCoach(c);
        //sending mail to coach
        MailerService m= new MailerService();
        m.replyMail(c.getEmail(), "user", "User created", "You have succefuly created your accout.Your pseudo= "+c.getLogin()+" your password = "+c.getPwd());
        Annuler();
         try {
            Parent root=FXMLLoader.load(getClass().getResource("InterfaceListCoach.fxml"));
            Scene scene =new Scene(root);
       Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(InterfaceListCoachController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void Annuler() {
        nomTxt.clear();
        prenomTxt.clear();
        EmailTxt.clear();
        numTelTxt.clear();
        cinTxt.clear();
        gouvT.clear();
  
        pwdTxt.clear();
   

    }

    @FXML
    private void retourner(ActionEvent event) {
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
    private void logout(ActionEvent event) {
          try {
            Parent root=FXMLLoader.load(getClass().getResource("login.fxml"));
            Scene scene =new Scene(root);
       Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void goProfil(ActionEvent event) {
    }


}
