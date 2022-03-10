/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Campination.App.Gui;

import Campination.App.Entity.Sortiebalade;
import Campination.App.Entity.Sortiesportif;
import Campination.App.Services.SortiesportifServices;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class HomeAfficheSSController implements Initializable {

    @FXML
    private Button BrechercheSB;
    @FXML
    private TextField Trecherche;

    @FXML
    private TableColumn<Sortiesportif, String> colid2;
    @FXML
    private TableColumn<Sortiesportif, String> coldest2;
    @FXML
    private TableColumn<Sortiesportif, String> coldep2;
    @FXML
    private TableColumn<Sortiesportif, String> colret2;
    @FXML
    private TableColumn<Sortiesportif, String> colspo;
    @FXML
    private TableColumn<Sortiesportif, String> colcoa;
    @FXML
    private TableColumn<Sortiesportif, String> coltran2;

    
    ObservableList<Sortiesportif>Listm;
    @FXML
    private TableView<Sortiesportif> TS;

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
    private AnchorPane anchor1;
    @FXML
    private AnchorPane anchor2;
    @FXML
    private Button logoutbtn1;
    @FXML
    private ComboBox choixR;
    @FXML
    private TextField txtrech;
    @FXML
    private Button res;
   
  

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          colid2.setCellValueFactory(new PropertyValueFactory<Sortiesportif, String>("nom_S"));
       coldest2.setCellValueFactory(new PropertyValueFactory<Sortiesportif, String>("id_destinationS"));
      coldep2.setCellValueFactory(new PropertyValueFactory<Sortiesportif, String>("date_depart"));
      colret2.setCellValueFactory(new PropertyValueFactory<Sortiesportif, String>("date_retour"));
      colspo.setCellValueFactory(new PropertyValueFactory<Sortiesportif, String>("type_sport"));
     colcoa.setCellValueFactory(new PropertyValueFactory<Sortiesportif, String>("cinCO"));
      coltran2.setCellValueFactory(new PropertyValueFactory<Sortiesportif, String>("cinT"));
         SortiesportifServices des = new SortiesportifServices();
         Listm=des.sbaffiche();
     TS.setItems(Listm);
    setValue () ;
    }
    
    
    
 

    @FXML
    private void RechercheSB(ActionEvent event) {
    }


 /*   private void supprimer2(ActionEvent event) {
    String tit = TxtId2.getText().toString();
        SortiesportifServices sp = new SortiesportifServices();
        Sortiesportif e = new Sortiesportif();
        e.setNom_S(tit);
        sp.supprimerSortiesportif(e);
         }*/


    @FXML
    private void returni(ActionEvent event) {
    }

    @FXML
    private void goajout(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("HomeAjouterSS.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(InterfaceAjoutTransporteurController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

       Stage stage = new Stage();
      private void setValue () {
    TS.setOnMousePressed (new EventHandler<MouseEvent> (){
        @Override
        public void handle (MouseEvent e) {
            Sortiesportif selectedForEdit = TS.getSelectionModel().getSelectedItem();
             if (e.isPrimaryButtonDown() && e.getClickCount() == 2) {
            Stage home=new Stage ();
              try {
           FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeprofilSS.fxml"));
            Parent parent = loader.load();

            HomeprofilSSController controller = (HomeprofilSSController) loader.getController();
            controller.send(selectedForEdit);

            Stage stage = new Stage();
           
            stage.setScene(new Scene(parent));
            stage.show();
           /// search();

           
           
        } catch (IOException ex) {
            ex.printStackTrace();
        }                  
      }
         
   
   

        }
        });
       
}

    @FXML
    private void goAcceuil(ActionEvent event) {
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
    }


    @FXML
    private void refresh(ActionEvent event) {
            colid2.setCellValueFactory(new PropertyValueFactory<Sortiesportif, String>("nom_S"));
       coldest2.setCellValueFactory(new PropertyValueFactory<Sortiesportif, String>("id_destinationS"));
      coldep2.setCellValueFactory(new PropertyValueFactory<Sortiesportif, String>("date_depart"));
      colret2.setCellValueFactory(new PropertyValueFactory<Sortiesportif, String>("date_retour"));
      colspo.setCellValueFactory(new PropertyValueFactory<Sortiesportif, String>("type_sport"));
     colcoa.setCellValueFactory(new PropertyValueFactory<Sortiesportif, String>("cinCO"));
      coltran2.setCellValueFactory(new PropertyValueFactory<Sortiesportif, String>("cinT"));
         SortiesportifServices des = new SortiesportifServices();
         Listm=des.sbaffiche();
     TS.setItems(Listm);
    setValue () ;
    }

    @FXML
    private void ViewAll(ActionEvent event) {
    }

    @FXML
    private void rechercher(ActionEvent event) {
    }

    
}
