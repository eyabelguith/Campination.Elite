/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionmagasin.gui;

import gestionmagasin.utils.MyConnexion;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * 
 */
public class FXMLstatController implements Initializable {

    @FXML
    private PieChart piechart;
    
    Connection con;
    private Statement st;
    private ResultSet rs;
    ObservableList<PieChart.Data>data=FXCollections.observableArrayList();
    @FXML
    private AnchorPane retour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        statproduit();
    }    

    private void statproduit()
    {
          Connection con = MyConnexion.getInstanceConnex().getConnection();
          
      try {
           
          String query = "select count(*) As value,categorie As nom from produit group by categorie" ;
       
         PreparedStatement PreparedStatement = con.prepareStatement(query);
          ResultSet rs = PreparedStatement.executeQuery();
             
                     
            while (rs.next()){  
               
               data.add(new PieChart.Data(rs.getString("nom"),rs.getInt("value")));
            }     
        } catch (SQLException ex) {
            Logger.getLogger(FXMLstatController.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        piechart.setTitle("*Statistique des produits selon categorie*");
        piechart.setLegendSide(Side.LEFT);
        piechart.setData(data);
    
    }
    @FXML
    void retour(ActionEvent event) throws IOException {
    Parent root = FXMLLoader .load(getClass().getResource("/gestionmagasin/gui/AjoutProduit.fxml"));
    Stage window = (Stage) retour.getScene().getWindow();
    window.setScene(new Scene(root));
    }
    
}
