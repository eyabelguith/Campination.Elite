/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campination.gestionsortie.gui;

import campination.gestionsortie.entities.Sortiebalade;
import campination.gestionsortie.entities.Sortiesportif;
import campination.gestionsortie.services.SortiesportifServices;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    private TableView<Sortiesportif> TSB;
    @FXML
    private TableColumn<?, ?> colid2;
    @FXML
    private TableColumn<?, ?> coldest2;
    @FXML
    private TableColumn<?, ?> coldep2;
    @FXML
    private TableColumn<?, ?> colret2;
    @FXML
    private TableColumn<?, ?> colspo;
    @FXML
    private TableColumn<?, ?> colcoa;
    @FXML
    private TableColumn<?, ?> coltran2;

    
    ObservableList<Sortiesportif>Listm;
    @FXML
    private TableView<Sortiesportif> TS;
    private TextField TxtId2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          colid2.setCellValueFactory(new PropertyValueFactory<>("nom_S"));
       coldest2.setCellValueFactory(new PropertyValueFactory<>("id_destinationS"));
      coldep2.setCellValueFactory(new PropertyValueFactory<>("date_depart"));
      colret2.setCellValueFactory(new PropertyValueFactory<>("date_retour"));
      colspo.setCellValueFactory(new PropertyValueFactory<>("type_sport"));
     colcoa.setCellValueFactory(new PropertyValueFactory<>("cinCO"));
      coltran2.setCellValueFactory(new PropertyValueFactory<>("cinT"));
         SortiesportifServices des = new SortiesportifServices();
         Listm=des.sbaffiche();
     TS.setItems(Listm);
    setValue () ;}
    
    
    
 

    @FXML
    private void RechercheSB(ActionEvent event) {
    }


    private void supprimer2(ActionEvent event) {
    String tit = TxtId2.getText().toString();
        SortiesportifServices sp = new SortiesportifServices();
        Sortiesportif e = new Sortiesportif();
        e.setNom_S(tit);
        sp.supprimerSortiesportif(e);
         }

    @FXML
    private void gov2(ActionEvent event) {
    }

    @FXML
    private void returni(ActionEvent event) {
    }

    @FXML
    private void goajout(ActionEvent event) {
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

    
}
