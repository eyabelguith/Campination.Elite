/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Campination.App.Gui;

import Campination.App.Entity.Camper;

import Campination.App.Services.CamperServices;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Eya
 */
public class InterfaceCamperController implements Initializable {
ObservableList<Camper> List;
ObservableList<Camper> Listm;
   public String x,y;
    @FXML
    private Button users;
    @FXML
    private Button dest;
    @FXML
    private Button mag;
    @FXML
    private Button eventt;
    @FXML
    private Button sortie;
    @FXML
    private Button transp;
    @FXML
    private Button vip;
    @FXML
    private AnchorPane anchor;
    @FXML
    private AnchorPane anchor2;
    @FXML
    private TableColumn<Camper, String> noml;
    private TableColumn<Camper, String> prenoml;
    private TableColumn<Camper, String> numl;
    @FXML
    private TableColumn<Camper, String> emaill;
    private TableColumn<Camper, String> daten;
    private TableColumn<Camper, String> cin;
    @FXML
    private TableColumn<Camper, String> skills;
    private TableColumn<Camper, String> role;
    @FXML
    private TableColumn<Camper, String> gov;
    private TableColumn<Camper, String> log;
    private TableColumn<Camper, String> mdp;
    @FXML
    private ComboBox  choixC;
    @FXML
    private TextField rech;
    @FXML
    private TableView<Camper> TableCamper;
    ObservableList<String> Choix = FXCollections.observableArrayList("Nom","Skills");
    @FXML
    private Label number;
    @FXML
    private Button resh;
    private TextField txtnom;
    private TextField txtprenom;
    private TextField txtnum;
    private TextField txtskills;
    private TextField txtmail;
    private TextField txtgov;
    private TextField txtrole;
    private TextField txtdate;
    private TextField txtlogin;
    private TextField txtmdp;
    private TextField txtcin;
    private TextField txtcins;
    @FXML
    private Button logoutbtn1;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                noml.setCellValueFactory(new PropertyValueFactory<Camper, String>("nom"));
               //    prenoml.setCellValueFactory(new PropertyValueFactory<Camper, String>("prenom"));
                 //  numl.setCellValueFactory(new PropertyValueFactory<Camper, String>("num_Tel"));
                     emaill.setCellValueFactory(new PropertyValueFactory<Camper, String>("email"));
                //  daten.setCellValueFactory(new PropertyValueFactory<Camper, String>("date_naissance"));
                //  cin.setCellValueFactory(new PropertyValueFactory<Camper, String>("cin"));
                  skills.setCellValueFactory(new PropertyValueFactory<Camper, String>("skills"));
                 // role.setCellValueFactory(new PropertyValueFactory<Camper, String>("role"));
                  gov.setCellValueFactory(new PropertyValueFactory<Camper, String>("gouvernorat"));
                  //log.setCellValueFactory(new PropertyValueFactory<Camper, String>("login"));
                  //mdp.setCellValueFactory(new PropertyValueFactory<Camper, String>("pwd"));
                  
                  choixC.setItems(Choix);
                         number.setText(String.valueOf(AfficherCampers().size()));
                        
                                 Button deleteIcon = new Button();
      //System.out.println();
      
      TableCamper.setItems(AfficherCampers());
      
                        
        resh.setOnAction(action -> {
            x=rech.getText();
            y = (String) choixC.getValue();
          
            TableCamper.setItems(rechercherC(x,y));
            });   
        /*    private void setCellValueFromTableTOTextField () {
           TableCamper.setOnMousePressed ((MouseEvent e) -> {
               Camper selectedForEdit = TableCamper.getSelectionModel().getSelectedItem();
        if (e.isPrimaryButtonDown() && e.getClickCount() == 2) {
            Stage home=new Stage ();
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceInfoCamper.fxml"));
                Parent parent = loader.load();
                
                InterfaceInfoCamperController controller = (InterfaceInfoCamperController) loader.getController();
                controller.inflateUI(selectedForEdit);
                
                Stage stage = new Stage();
                
                stage.setScene(new Scene(parent));
                stage.show();
                
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    });*/
       
}
              
                 
    
  
    
 public ObservableList<Camper> rechercherC(String  y,String x){
        CamperServices Ts = new CamperServices();
        ObservableList<Camper> Camp = FXCollections.observableArrayList(Ts.RechercherCamper(x, y));
   
              
     return Camp;   
    }    
      public ObservableList<Camper> AfficherCampers(){
        CamperServices c = new CamperServices();
        ObservableList<Camper> Campers = FXCollections.observableArrayList(c.AfficherCamper());
              
     return Campers;   
    }

    @FXML
    private void goAcceuil(ActionEvent event) {
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
    private void godest(ActionEvent event) {
    }

    @FXML
    private void goMag(ActionEvent event) {
    }

    @FXML
    private void goevent(ActionEvent event) {
    }

    @FXML
    private void gosortie(ActionEvent event) {
    }

    @FXML
    private void goTransp(ActionEvent event) {
    }

    @FXML
    private void goVip(ActionEvent event) {
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

    private void goProfil(ActionEvent event) {
         try {
            Parent root=FXMLLoader.load(getClass().getResource("InterfaceProfils.fxml"));
            Scene scene =new Scene(root);
       Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(InterfaceProfilsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void rechercher(ActionEvent event) {
    }
    @FXML
    private void selctionner(MouseEvent event) {
     /*   Camper pl = TableCamper.getItems ().get (TableCamper.getSelectionModel ().getSelectedIndex());
            txtnom.setText (pl.getNom());
            txtprenom.setText (pl. getPrenom());
            txtnum.setText (String.valueOf(pl. getNum_Tel()));
            txtmail.setText (pl.getEmail());
            txtdate.setText (String.valueOf(pl.getDate_naissance()));
            txtcin.setText (String.valueOf(pl.getCin()));
            txtskills.setText (pl.getSkills());
            txtrole.setText (pl.getRole());
            txtgov.setText (pl.getGouvernorat());
            txtlogin.setText (pl.getLogin());
            txtmdp.setText (pl.getPwd());*/
              
       
    }
     public void UpdateTable(){
        noml.setCellValueFactory(new PropertyValueFactory<Camper, String>("nom"));
                   prenoml.setCellValueFactory(new PropertyValueFactory<Camper, String>("prenom"));
                   numl.setCellValueFactory(new PropertyValueFactory<Camper, String>("num_Tel"));
                     emaill.setCellValueFactory(new PropertyValueFactory<Camper, String>("email"));
                  daten.setCellValueFactory(new PropertyValueFactory<Camper, String>("date_naissance"));
                  cin.setCellValueFactory(new PropertyValueFactory<Camper, String>("cin"));
                  skills.setCellValueFactory(new PropertyValueFactory<Camper, String>("skills"));
                  role.setCellValueFactory(new PropertyValueFactory<Camper, String>("role"));
                  gov.setCellValueFactory(new PropertyValueFactory<Camper, String>("gouvernorat"));
                  log.setCellValueFactory(new PropertyValueFactory<Camper, String>("login"));
                  mdp.setCellValueFactory(new PropertyValueFactory<Camper, String>("pwd"));
        CamperServices sp=new CamperServices();
       // Listm = sp.ListCampers();
        TableCamper.setItems(AfficherCampers());
    }

    private void modifierC(ActionEvent event) {
        String nom = txtnom.getText().toString();
      //  String prenom = txtprenom.getText().toString();
       // String num = txtnum.getText().toString();
        String mail = txtmail.getText().toString();
     //   String date = txtdate.getText().toString();
      //  String cin = txtcin.getText().toString();
        String skills = txtskills.getText().toString();
        String gov = txtgov.getText().toString();
      //  String role=txtrole.getText().toString();
       // String login=txtlogin.getText().toString();
       // String mdp=txtmdp.getText().toString();
        
        
        CamperServices sp=new CamperServices();
        Camper c = new Camper();
       
        c.setNom(nom);

        c.setEmail(mail);
     
        
        c.setGouvernorat(gov);
     
        c.setSkills(skills);
   
        
        
       
    
        sp.ModifierCamper(c);
        
       UpdateTable();
     







    }


    private void Supprimer(ActionEvent event) {
         String t = txtcins.getText();
        CamperServices sp = new CamperServices();
        Camper c = new Camper();
        c.setCin(Integer.parseInt(t));
        sp.SuprimerCamper(c);
        UpdateTable();
        
    }

    @FXML
    private void CellValueFromTableTOTextField(MouseEvent event) {
         TableCamper.setOnMousePressed ((MouseEvent e) -> {
               Camper selectedForEdit = TableCamper.getSelectionModel().getSelectedItem();
        if (e.isPrimaryButtonDown() && e.getClickCount() == 2) {
            Stage home=new Stage ();
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceInfoCamper.fxml"));
                Parent parent = loader.load();
                
                InterfaceInfoCamperController controller = (InterfaceInfoCamperController) loader.getController();
                controller.inflateUI(selectedForEdit);
                
                Stage stage = new Stage();
                
                stage.setScene(new Scene(parent));
                stage.show();
                
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    });
    }

    @FXML
    private void refresh(ActionEvent event) {
        noml.setCellValueFactory(new PropertyValueFactory<Camper, String>("nom"));
//                   prenoml.setCellValueFactory(new PropertyValueFactory<Camper, String>("prenom"));
             //      numl.setCellValueFactory(new PropertyValueFactory<Camper, String>("num_Tel"));
                     emaill.setCellValueFactory(new PropertyValueFactory<Camper, String>("email"));
               //   daten.setCellValueFactory(new PropertyValueFactory<Camper, String>("date_naissance"));
                 // cin.setCellValueFactory(new PropertyValueFactory<Camper, String>("cin"));
                  skills.setCellValueFactory(new PropertyValueFactory<Camper, String>("skills"));
                  //role.setCellValueFactory(new PropertyValueFactory<Camper, String>("role"));
                  gov.setCellValueFactory(new PropertyValueFactory<Camper, String>("gouvernorat"));
                  //log.setCellValueFactory(new PropertyValueFactory<Camper, String>("login"));
                  //mdp.setCellValueFactory(new PropertyValueFactory<Camper, String>("pwd"));
        CamperServices sp=new CamperServices();
       // Listm = sp.ListCampers();
        TableCamper.setItems(AfficherCampers());
          number.setText(String.valueOf(AfficherCampers().size()));
    }

    @FXML
    private void goAjout(ActionEvent event) {
        
    }



    
}
