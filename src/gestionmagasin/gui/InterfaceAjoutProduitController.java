/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionmagasin.gui;

import gestionmagasin.entity.Produit;
import gestionmagasin.services.ProduitServices;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * 
 */
public class InterfaceAjoutProduitController implements Initializable {

    @FXML
    private AnchorPane navbar;
    @FXML
    private Button navItem;
    @FXML
    private AnchorPane anchor;
    @FXML
    private Button button;
    @FXML
    private TextField txtnom;
    @FXML
    private TextField txtp;
    @FXML
    private TextField txtref;
    @FXML
    private TextField txtcat;
    @FXML
    private TextField txtetat;
   
    @FXML
    private DatePicker txtdatep;
    @FXML
    private DatePicker txtdatev;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AjouterProduit(ActionEvent event) {
        ProduitServices Ps = new ProduitServices();
        Produit p = new Produit();
        p.setNomProduit(txtnom.getText());
        //p.setReferenceProduit(txtref.getText());
         p.setEtat(txtetat.getText());
         p.setCategorie(txtcat.getText());
        p.setPrix(Float.parseFloat(txtp.getText()));
       
    //    p.getCinclient(Integer.parseInt(txtcin.getText()));

     
   //   p.getDescription(txtdescription.getText());
        
      Ps.AjouterProduit(p);
  
         
    }

    @FXML
    private void Annuler(ActionEvent event) {
    }
    
}
