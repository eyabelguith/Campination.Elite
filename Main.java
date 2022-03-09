package gui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import utils.MyConnexion;

import entite.Destination;
import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import services.DestinationServices;
import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author chams
 */

public class Main extends Application{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       MyConnexion.getInstanceConnex();
       DestinationServices destination = new DestinationServices();

       Destination D = new Destination();
 
       destination.afficherDestination();
       launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
      //  Parent root = FXMLLoader.load(getClass().getResource(InterfaceAFFICHAGE.fxml));
      //Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("gui/interfaceRECHERCHE.fxml"));
      Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("gui/interfaceAFFICHAGE.fxml"));
      //Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("gui/AJOUT.fxml"));
      Scene scene = new Scene(root);
        
      
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
}




    
    
 
    

