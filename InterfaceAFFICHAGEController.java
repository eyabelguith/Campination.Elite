package gui;

import entite.Destination;
import java.awt.event.MouseEvent;
import java.io.IOException;
import services.*;
import java.net.URL;
import java.util.Collections;
import java.util.Comparator;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
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
import javafx.stage.Stage;

/**
 *
 * @author chams
 */
public class InterfaceAFFICHAGEController implements Initializable  {
    public static ObservableList<Destination> selectedItems;
    String selection;
    
    public static Destination D2 = new Destination();
    ObservableList<String> Choix = FXCollections.observableArrayList("nom","gouvernorat","type");
    public String c,v;
    @FXML public Button ok;
    @FXML public Button ajouter;
    @FXML public ComboBox choixC;
    @FXML public TextField valeur;
    public static ObservableList<Destination> tests;
    @FXML public ComboBox choixC1;
    @FXML private TableView<Destination> tableView;
    @FXML private TableColumn<Destination , String> Nom;
    @FXML private TableColumn<Destination , String> Gouvernorat;
    @FXML private TableColumn<Destination , String> Type;
    @FXML private TableColumn<Destination , String> Description;
  
    
    
    @Override
    public void initialize(URL location, ResourceBundle rb) {
        DestinationServices Ds = new DestinationServices();
        //SET UP COLUMNS IN TABLE
        Nom.setCellValueFactory(new PropertyValueFactory<Destination ,String>("Nom") );
        Gouvernorat.setCellValueFactory(new PropertyValueFactory<Destination ,String>("Gouvernorat") );
        Type.setCellValueFactory(new PropertyValueFactory<Destination ,String>("Type") );
        Description.setCellValueFactory(new PropertyValueFactory<Destination ,String>("Description") );
        choixC.setItems(Choix);
        choixC1.setItems(Choix);
       // colBtn.setCellValueFactory(new PropertyValueFactory<Destination ,Button>("Button"));
        //GET DATA
        tableView.setItems(Ds.afficherDestination());
      
         
       
       
       
       
        
        selectedItems = tableView.getSelectionModel().getSelectedItems();
        
        selectedItems.addListener(new ListChangeListener<Destination>() {
           
         @Override
        public void onChanged(Change<? extends Destination> change) {
        System.out.println("Selection changed: " + change.getList());
        
        
        
        
        try {
            
            D2.setSelection(tableView.getSelectionModel().getSelectedIndex());
            System.out.println("mlloul"+D2.selection);
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("gui/Profil.fxml"));           
            Scene scene =new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            
         
            
        } catch (IOException ex) {
            Logger.getLogger(InterfaceAFFICHAGEController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      
        }
        });
        
        
        
        choixC.setOnAction((event) -> {  
            selection = (String) choixC.getValue();
        Object selectedItem = choixC.getSelectionModel().getSelectedItem();   
        System.out.println( choixC.getValue());
        tableView.setItems(Ds.Tri(tableView.getItems(),selection));
        });
        
        ok.setOnAction(action -> {
            v =valeur.getText();
            c = (String) choixC1.getValue();
            System.out.println(c);
            System.out.println(v);
            tableView.setItems(Ds.rechercherDestination(v,c));
        });
        ajouter.setOnAction(action -> {
                      
            try {
                Parent root; 
                root = FXMLLoader.load(getClass().getClassLoader().getResource("gui/Ajout.fxml"));
           
            Scene scene =new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
             } catch (IOException ex) {
                Logger.getLogger(InterfaceAFFICHAGEController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
    }
   
}