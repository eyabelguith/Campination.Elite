/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campination.gestionsortie.gui;

import campination.gestionsortie.entities.Sortiesportif;
import campination.gestionsortie.services.SortiesportifServices;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

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
    @FXML
    private Button button2;
    @FXML
    private TextField TxtId2;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          colid2.setCellValueFactory(new PropertyValueFactory<>("id_SS"));
       coldest2.setCellValueFactory(new PropertyValueFactory<>("id_destinationS"));
      coldep2.setCellValueFactory(new PropertyValueFactory<>("date_depart"));
      colret2.setCellValueFactory(new PropertyValueFactory<>("date_retour"));
      colspo.setCellValueFactory(new PropertyValueFactory<>("type_sport"));
     colcoa.setCellValueFactory(new PropertyValueFactory<>("id_coach"));
      coltran2.setCellValueFactory(new PropertyValueFactory<>("id_transporteur"));
         SortiesportifServices des = new SortiesportifServices();
         Listm=des.sbaffiche();
     TS.setItems(Listm);}
    
    
    
 

    @FXML
    private void RechercheSB(ActionEvent event) {
    }


    @FXML
    private void supprimer2(ActionEvent event) {
    String tit = TxtId2.getText();
        SortiesportifServices sp = new SortiesportifServices();
        Sortiesportif e = new Sortiesportif();
        e.setId_SS(Integer.parseInt(tit));
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

    @FXML
    private void modifier(ActionEvent event) {
    }
    
}
