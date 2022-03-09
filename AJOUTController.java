/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entite.Destination;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javax.sql.rowset.serial.SerialBlob;
import services.DestinationServices;
import utils.MyConnexion;

/**
 * FXML Controller class
 *
 * @author chams
 */
public class AJOUTController implements Initializable {
    @FXML public TextField nom;
    @FXML public TextField gouvernorat;
    @FXML public TextField type;
    @FXML public TextArea description;
    @FXML public Button submit;
    @FXML public Button photo;
    @FXML public Label path1;
    @FXML public Label path2;
    @FXML public Label path3;
    @FXML public Label path4;
    @FXML public Label path5;
    public static int pathNum=1;
    public static String file1,file2,file3,file4,file5;

     Connection connx ;
    Statement ste;
    public AJOUTController() {       
        connx = MyConnexion.getInstanceConnex().getConnection();
        try {
            ste = connx.createStatement();
        } catch (SQLException ex) {
                    System.out.println(ex);
        }   
    }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        FileChooser fileChooser = new FileChooser();
        DestinationServices Ds= new DestinationServices();
        Destination D = new Destination(); 
        Alert a = new Alert(AlertType.NONE);
        photo.setOnAction(action -> {
            Stage stage = new Stage();
            File selectedFile = fileChooser.showOpenDialog(stage); 
            String path = selectedFile.getPath();
            switch(pathNum){
            case 1 :
                    path1.setText(path);
                    
                    file1=path;
                    pathNum ++;
                    break;
            case 2 :
                    path2.setText(path);
                   
                    file2=path;
                    pathNum ++;
                    break;  
            case 3 :
                    path3.setText(path);
                    
                    file3=path;
                    pathNum ++;
                    break;
            case 4 :
                    path4.setText(path);
                    
                    file4=path;
                    pathNum ++;
                    break;
            case 5 :
                    path5.setText(path);
                    
                    file5=path;
                    pathNum ++;
                    break;
            case 6 : pathNum = 1;
                     break;
        }
            
        });
        submit.setOnAction(action ->{
            String n = nom.getText();
            String g = gouvernorat.getText();
            String t = type.getText();
            String d = description.getText();
        if (pathNum != 6){
            a.setAlertType(AlertType.WARNING);
            a.setContentText("insérer 5 images!");
            a.show();
        }else{
            
          
              
                   /* FileInputStream fin1 = new FileInputStream(file1);
                    FileInputStream fin2 = new FileInputStream(file2);
                    FileInputStream fin3 = new FileInputStream(file3);
                    FileInputStream fin4 = new FileInputStream(file4);
                    FileInputStream fin5 = new FileInputStream(file5);
                 */ D.setNom(n);
                    D.setGouvernorat(g);
                    D.setType(t);
                    D.setDescription(d);
                    D.setPhoto1(file1);
                    D.setPhoto2(file2);
                    D.setPhoto3(file3);
                    D.setPhoto4(file4);
                    D.setPhoto5(file5);
                    Ds.ajouterDestination(D);
                    
               
                }
              
             
        
        
        }
        );
    }       
}



