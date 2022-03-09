/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campination.gestionsortie.gui;

import campination.gestionsortie.entities.VIP;
import campination.gestionsortie.services.VipServices;
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
public class HomeAfficheVIPController implements Initializable {

    @FXML
    private TableView<VIP> TSB;
    @FXML
    private TableColumn<?, ?> colid;
    @FXML
    private TableColumn<?, ?> colnbpt;
    @FXML
    private TableColumn<?, ?> colcin;
    @FXML
    private TableColumn<?, ?> colnbSS;
    @FXML
    private TableColumn<?, ?> colnbSB;
    @FXML
    private Button BrechercheSB;
    @FXML
    private TextField Trecherche;
ObservableList<VIP>ListT;
private Parent fxml;
    @FXML
    private Button button3;
    @FXML
    private TextField TxtId3;
    private TextField TX;
    private TextField TXX;
    private TextField TXXX;
    private TextField TXXXX;
    private TextField TXXXXX;
    /**
     * Initializes the controller class.
     */
    ObservableList<VIP>Listv;
    @FXML
    private AnchorPane navbar;
    @FXML
    private Button navItem;
    @FXML
    private Button button1;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      colid.setCellValueFactory(new PropertyValueFactory<>("id_vip"));
      colnbpt.setCellValueFactory(new PropertyValueFactory<>("nb_pt"));
      colcin.setCellValueFactory(new PropertyValueFactory<>("cin"));
      colnbSS.setCellValueFactory(new PropertyValueFactory<>("nb_SS"));
      colnbSB.setCellValueFactory(new PropertyValueFactory<>("nb_SB"));
    
         VipServices des = new VipServices();
         ListT=des.vaffiche();
     TSB.setItems(ListT);
     setValue ();
    }    

    @FXML
    private void RechercheSB(ActionEvent event) {
    }

    

    @FXML
    private void supprimer3(ActionEvent event) {
     String tit = TxtId3.getText();
        VipServices sp = new VipServices();
        VIP e = new VIP();
        e.setCin(Integer.parseInt(tit));
                
        sp.supprimerVip(e);
    UpdateTable();}
public void UpdateTable(){
       colid.setCellValueFactory(new PropertyValueFactory<>("id_vip"));
       colnbpt.setCellValueFactory(new PropertyValueFactory<>("nb_pt"));
      colcin.setCellValueFactory(new PropertyValueFactory<>("cin"));
      colnbSS.setCellValueFactory(new PropertyValueFactory<>("nb_SS"));
      colnbSB.setCellValueFactory(new PropertyValueFactory<>("NB_SB"));
     VipServices des = new VipServices();
       Listv = des.vaffiche();
        TSB.setItems(Listv);
    }

    

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

    private void goajout(ActionEvent event) {
    try {
            Parent root=FXMLLoader.load(getClass().getResource("HomeAjouterVIP.fxml"));
            Scene scene =new Scene(root);
       Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex2) {
            Logger.getLogger(HomeAjouterVIPController.class.getName()).log(Level.SEVERE, null, ex2);
        }}

    private void modifier(ActionEvent event) {
     String id = TX.getText().toString();
        String y = TXX.getText().toString();
        String dt = TXXX.getText().toString();
        String dr = TXXXX.getText().toString();
        String t = TXXXXX.getText().toString();
        
        VipServices sp=new VipServices();
        VIP p = new VIP();
       
        p.setId_vip(Integer.parseInt(id));
         p.setNb_pt(Integer.parseInt(t));
        p.setCin(Integer.parseInt(dr));
         p.setNb_SS(Integer.parseInt(dt));
          p.setNb_SB(Integer.parseInt(y));
        
        
        sp.modifierVip(p);
      UpdateTable();}
    
    
    
    
    
    
    

    private void gos(ActionEvent event) {
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
            VIP selectedForEdit = TSB.getSelectionModel().getSelectedItem();
             if (e.isPrimaryButtonDown() && e.getClickCount() == 2) {
            Stage home=new Stage ();
              try {
           FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeprofilVip.fxml"));
            Parent parent = loader.load();

            HomeprofilVipController controller = (HomeprofilVipController) loader.getController();
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
    private void Annuler(ActionEvent event) {
    }

    
    
}
