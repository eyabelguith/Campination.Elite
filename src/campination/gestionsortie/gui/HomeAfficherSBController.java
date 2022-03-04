/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campination.gestionsortie.gui;

import campination.gestionsortie.entities.Sortiebalade;
import campination.gestionsortie.services.SortiebaladeServices;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
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
import static javafx.scene.input.KeyCode.V;
import javafx.scene.layout.AnchorPane;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;
/**
 * FXML Controller class
 *
 * @author Eya
 */
public class HomeAfficherSBController implements Initializable {
public String C,V;
    @FXML
    private TableView<Sortiebalade> TSB;
    @FXML
    private Button BrechercheSB;
    @FXML
    private TextField Trecherche;
    @FXML
    private TableColumn<?,?> coldest;
    @FXML
    private TableColumn<?,?> coldep;
    @FXML
    private TableColumn<?,?> colret;
    @FXML
    private TableColumn<?,?> coltran;
    @FXML
    private TableColumn<?,?> colid;
    ObservableList<Sortiebalade>ListT;
      ObservableList<Sortiebalade>dataList;
    @FXML
    private Button button11;
    @FXML
    private TextField TxtId;
private Parent fxml;
    @FXML
    private ComboBox CBoxR1;
    
    
ObservableList<String> Choix = FXCollections.observableArrayList("destination","transport","date depart","date retour");
    @FXML
    private TextField t1;
    @FXML
    private TextField t5;
    @FXML
    private TextField t4;
    @FXML
    private TextField t3;
    @FXML
    private TextField t2;
    @FXML
    private Button buttonM;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          colid.setCellValueFactory(new PropertyValueFactory<>("id_SB"));
       coldest.setCellValueFactory(new PropertyValueFactory<>("id_destinationB"));
      coldep.setCellValueFactory(new PropertyValueFactory<>("date_depart"));
      colret.setCellValueFactory(new PropertyValueFactory<>("date_retour"));
      coltran.setCellValueFactory(new PropertyValueFactory<>("id_transporteur"));
    
         SortiebaladeServices des = new SortiebaladeServices();
         ListT=des.sbaffiche();
     TSB.setItems(ListT);
    //search();
    CBoxR1.setItems(Choix);
    
        
        
        /*TSB.setItems(des());
        BrechercheSB.setOnAction(action -> {
          V = Trecherche.getText();
            C = (String) CBoxR1.getValue();
            
            TSB.setItems(RechercherSB(C,V));
        });*/

    
    }    

    
  /* public ObservableList<Sortiebalade> des(){
        SortiebaladeServices desT = new SortiebaladeServices();
        ObservableList<Sortiebalade> Sortiebalade = FXCollections.observableArrayList(desT.sbaffiche());
              
     return Sortiebalade;   
    }
    public ObservableList<Sortiebalade> RechercherSB(String C,String V) {
        SortiebaladeServices dest = new SortiebaladeServices();
        ObservableList<Sortiebalade> Sortiebalade = FXCollections.observableArrayList(dest.rechercherSB(C,V));
              
     return Sortiebalade;

    }*/

    

    @FXML
    private void supprimer(ActionEvent event) {
         String tit = TxtId.getText();
        SortiebaladeServices sp = new SortiebaladeServices();
        Sortiebalade e = new Sortiebalade();
        e.setId_SB(Integer.parseInt(tit));
        sp.supprimerSortiebalade(e);
        UpdateTable();
        
    }

    @FXML
    private void RechercheSB(ActionEvent event) {
    }
    
 

    @FXML
    private void modifier(ActionEvent event) {
        String id = t1.getText().toString();
        String y = t2.getText().toString();
        String dt = t3.getText().toString();
        String dr = t4.getText().toString();
        String t = t5.getText().toString();
        
        SortiebaladeServices sp=new SortiebaladeServices();
        Sortiebalade p = new Sortiebalade();
       
        p.setId_SB(Integer.parseInt(id));
         p.setId_destinationB(Integer.parseInt(y));
         
          p.setDate_depart(java.sql.Date.valueOf(dt));
        p.setDate_retour(java.sql.Date.valueOf(dr));
          p.setId_transporteur(Integer.parseInt(t));
        
        sp.modifierSortiebalade(p);
       UpdateTable();
      UpdateTable();


    }
    
@FXML
    private void click(MouseEvent event)
    { Sortiebalade p=TSB.getItems().get(TSB.getSelectionModel().getSelectedIndex());
    t1.setText(String.valueOf(p.getId_SB()));
    t2.setText(String.valueOf(p.getId_destinationB()));
    t3.setText(String.valueOf(p.getDate_depart()));
    t4.setText(String.valueOf(p.getDate_retour()));
    t5.setText(String.valueOf(p.getId_transporteur()));
    }
    
    
    
    public void UpdateTable(){
       colid.setCellValueFactory(new PropertyValueFactory<>("id_SB"));
       coldest.setCellValueFactory(new PropertyValueFactory<>("id_destinationB"));
      coldep.setCellValueFactory(new PropertyValueFactory<>("date_depart"));
      colret.setCellValueFactory(new PropertyValueFactory<>("date_retour"));
      coltran.setCellValueFactory(new PropertyValueFactory<>("id_transporteur"));
     SortiebaladeServices des = new SortiebaladeServices();
       dataList = des.sbaffiche();
        TSB.setItems(dataList);
    }

    @FXML
    private void gov2(ActionEvent event) {
    try {
            Parent root=FXMLLoader.load(getClass().getResource("HomeAfficheVIP.fxml"));
            Scene scene =new Scene(root);
       Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex1) {
            Logger.getLogger(HomeAfficheVIPController.class.getName()).log(Level.SEVERE, null, ex1);
        }}

    @FXML
    private void goajout(ActionEvent event) {
    try {
            Parent root=FXMLLoader.load(getClass().getResource("HomeAjouterSB.fxml"));
            Scene scene =new Scene(root);
       Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex2) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex2);
        }}

    @FXML
    private void returni(ActionEvent event) {
     try {
            Parent root=FXMLLoader.load(getClass().getResource("choice.fxml"));
            Scene scene =new Scene(root);
       Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ChoiceController.class.getName()).log(Level.SEVERE, null, ex);
        }}
    
    
    }
