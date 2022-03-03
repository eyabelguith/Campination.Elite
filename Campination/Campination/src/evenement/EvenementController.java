/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evenement;


import Services.EvenementServices;
import entite.Evenement;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.Observable;
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
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author IHEB
 */
public class EvenementController implements Initializable {
public ObservableList<Evenement> rech;
        public String C,V;
    @FXML
    private TextField txtid;
    @FXML
    private TextField txtTitre;
    @FXML
    private TextField txtDestination;
    @FXML
    private TextField txtType;
    @FXML
    private TableColumn<?, ?> col_id;
    @FXML
    private TableColumn<?,?> col_titre;
    @FXML
    private TableColumn<?, ?> col_destination;
    @FXML
    private TableColumn<?, ?> col_type;
    @FXML
    private TableColumn<?, ?> col_description;
    @FXML
    private Button btnajouter;
    @FXML
    private TextField txtDescription;
    @FXML
    private TextField txtListCampers;
    @FXML
    private TableView<Evenement> tableevenement;
   ObservableList<Evenement> list;
    @FXML
    private ComboBox cmbRecherche;
    @FXML
    private TextField txtValeur;
    ObservableList<String> Choix = FXCollections.observableArrayList("Titre","Destination");
    @FXML
    private Button btnOk;
    @FXML
    private Button btnmodifier;
    @FXML
    private TableColumn<?, ?> col;
    @FXML
    private Button btnretourner;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        col_id.setCellValueFactory(new PropertyValueFactory<>("id_e"));
        col_titre.setCellValueFactory(new PropertyValueFactory<>("titre"));
        col_destination.setCellValueFactory(new PropertyValueFactory<>("destination_e"));
        col_type.setCellValueFactory(new PropertyValueFactory<>("type_e"));
        col_description.setCellValueFactory(new PropertyValueFactory<>("description"));
        col.setCellValueFactory(new PropertyValueFactory<>("personne_interessee"));
        EvenementServices sp=new EvenementServices();
        list = sp.getDataEvenement();
        tableevenement.setItems(list);
        cmbRecherche.setItems(Choix);
        
        
        tableevenement.setItems(des());
        btnOk.setOnAction(action -> {
            V = txtValeur.getText();
            C = (String) cmbRecherche.getValue();
            System.out.println(V);
            System.out.println(C);
            tableevenement.setItems(rech(V, C));
    }); 
        
       
        tableevenement.setItems(list);
    }    
    public ObservableList<Evenement> des(){
        EvenementServices dest = new EvenementServices();
        ObservableList<Evenement> Evenement = FXCollections.observableArrayList(dest.afficherEvenement());
              
     return Evenement;   
    }

    @FXML
    private void ajouter(ActionEvent event) {
        EvenementServices sp = new EvenementServices();
        Evenement e = new Evenement();
        
        e.setTitre(txtTitre.getText());
        e.setDestination_e(txtDestination.getText());
        e.setType_e(txtType.getText());
        e.setDescription(txtDescription.getText());
        e.setListCampers(txtListCampers.getText());
        
        sp.ajouterEvenement(e);
        
        clearFields();
        
        
       
    }
 
        
        private void clearFields() {
        
        txtTitre.clear();
        txtDescription.clear(); 
        txtDestination.clear();
        
        txtListCampers.clear(); 
        txtType.clear();
        
        
        
    }

     @FXML
    private void supprimer(ActionEvent event) {
        String tit = txtTitre.getText().toString();
        EvenementServices sp = new EvenementServices();
        Evenement e = new Evenement();
        e.setTitre(tit);
        sp.supprimerEvenement(e);
        clearFields();
        
    }
    public ObservableList<Evenement> rech(String V,String C){
        EvenementServices dest = new EvenementServices();
        ObservableList<Evenement> Evenement = FXCollections.observableArrayList(dest.rechercherEvenement(V, C));
              
     return Evenement;   
    }

    @FXML
    private void ok(ActionEvent event) {
    }

    @FXML
    private void modify(ActionEvent event) {
        String id=txtid.getText();
        String titre=txtTitre.getText();
        String destination=txtDestination.getText();
        String type=txtType.getText();
        String des=txtDescription.getText();
        String list=txtListCampers.getText();
        EvenementServices sp = new EvenementServices();
        Evenement e = new Evenement();
        e.setId_e(Integer.parseInt(id));
        e.setTitre(titre);
        e.setDestination_e(destination);
        e.setType_e(type);
        e.setDescription(des);
        e.setListCampers(list);
        e.setId_e(Integer.parseInt(id));
        sp.modifierEvenement(e);
        clearFields();
        
        
    }

    @FXML
    private void setOnMouseClicked(javafx.scene.input.MouseEvent event) {
        
            Evenement pl = tableevenement.getItems ().get (tableevenement.getSelectionModel ().getSelectedIndex());
            txtid.setText (String.valueOf(pl.getId_e()));
            txtTitre.setText (String.valueOf(pl. getTitre()));
            txtDestination.setText (pl. getDestination_e());
            txtType.setText (pl.getType_e());
            txtDescription.setText (pl.getDescription());
            txtListCampers.setText (pl.getListCampers());
           // search();
    
   

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
    }

    

    
    

