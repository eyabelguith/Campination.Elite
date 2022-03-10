/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Campination.App.Gui;

import Campination.App.Entity.Coach;
import Campination.App.Entity.Sortiebalade;
import Campination.App.Services.SortiebaladeServices;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
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
import static javafx.scene.input.KeyCode.V;
import javafx.scene.layout.AnchorPane;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;

//import org.controlsfx.control.Rating;
/**
 * FXML Controller class
 *
 * @author Eya
 */
public class HomeAfficherSBController implements Initializable {
 //   @FXML
 //   private Rating rating;
    @FXML
    private Label msg;
    
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
    private TextField TxtId;
private Parent fxml;
    @FXML
    private ComboBox CBoxR1;
    
    
ObservableList<String> Choix = FXCollections.observableArrayList("destination","transport","date depart","date retour","nom_S");
    
    @FXML
    private AnchorPane navbar;
    @FXML
    private Button navItem;
    @FXML
    private AnchorPane anchor;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          colid.setCellValueFactory(new PropertyValueFactory<>("nom_S"));
       coldest.setCellValueFactory(new PropertyValueFactory<>("nom"));
      coldep.setCellValueFactory(new PropertyValueFactory<>("date_depart"));
      colret.setCellValueFactory(new PropertyValueFactory<>("date_retour"));
      coltran.setCellValueFactory(new PropertyValueFactory<>("cinT"));
    
         SortiebaladeServices des = new SortiebaladeServices();
         ListT=des.sbaffiche();
     TSB.setItems(ListT);
    //search();
    CBoxR1.setItems(Choix);
    
       setValue (); 
        
        /*TSB.setItems(des());
        BrechercheSB.setOnAction(action -> {
          V = Trecherche.getText();
            C = (String) CBoxR1.getValue();
            
            TSB.setItems(RechercherSB(C,V));
        });*/

   /* rating.ratingProperty().addListener(new ChangeListener<Number>() {
           
       
            @Override
            public void changed(ObservableValue<? extends Number> url, Number t, Number t1){
            msg.setText("Rating : "+t1.toString());
           
        }

       
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

    

    private void supprimer(ActionEvent event) {
         String tit = TxtId.getText().toString();
        SortiebaladeServices sp = new SortiebaladeServices();
        Sortiebalade e = new Sortiebalade();
        e.setNom_S(tit);
        sp.supprimerSortiebalade(e);
        UpdateTable();
        
    }

    @FXML
    private void RechercheSB(ActionEvent event) {
    }
    
 

    
@FXML
    private void click(MouseEvent event)
    {   TSB.setOnMousePressed ((MouseEvent e) -> {
               Sortiebalade selectedForEdit = TSB.getSelectionModel().getSelectedItem();
        if (e.isPrimaryButtonDown() && e.getClickCount() == 2) {
            Stage home=new Stage ();
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeprofilSB.fxml"));
                Parent parent = loader.load();
                
                HomeprofilSBController controller = (HomeprofilSBController) loader.getController();
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
    
    
    
    public void UpdateTable(){
       colid.setCellValueFactory(new PropertyValueFactory<>("nom_S"));
       coldest.setCellValueFactory(new PropertyValueFactory<>("nom"));
      coldep.setCellValueFactory(new PropertyValueFactory<>("date_depart"));
      colret.setCellValueFactory(new PropertyValueFactory<>("date_retour"));
      coltran.setCellValueFactory(new PropertyValueFactory<>("cinT"));
     SortiebaladeServices des = new SortiebaladeServices();
       dataList = des.sbaffiche();
        TSB.setItems(dataList);
    }

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
    
    
    
    Stage stage = new Stage();
      private void setValue () {
    TSB.setOnMousePressed (new EventHandler<MouseEvent> (){
        @Override
        public void handle (MouseEvent e) {
            Sortiebalade selectedForEdit = TSB.getSelectionModel().getSelectedItem();
             if (e.isPrimaryButtonDown() && e.getClickCount() == 2) {
            Stage home=new Stage ();
              try {
           FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeprofilSB.fxml"));
            Parent parent = loader.load();

            HomeprofilSBController controller = (HomeprofilSBController) loader.getController();
            controller.inflateUI(selectedForEdit);

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
    
    
    
    
   
