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
    @FXML
    private Button buttonM;
    @FXML
    private TextField TX;
    @FXML
    private TextField TXX;
    @FXML
    private TextField TXXX;
    @FXML
    private TextField TXXXX;
    @FXML
    private TextField TXXXXX;
    /**
     * Initializes the controller class.
     */
    ObservableList<VIP>Listv;
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

    @FXML
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

    @FXML
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
    
    
    
    
     @FXML
    private void click(MouseEvent event) {
    VIP p=TSB.getItems().get(TSB.getSelectionModel().getSelectedIndex());
    TX.setText(String.valueOf(p.getId_vip()));
    TXX.setText(String.valueOf(p.getNb_pt()));
    TXXX.setText(String.valueOf(p.getCin()));
   TXXXX.setText(String.valueOf(p.getNb_SS()));
    TXXXXX.setText(String.valueOf(p.getNb_SB()));}
    
    
    

    @FXML
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

   
    
}
