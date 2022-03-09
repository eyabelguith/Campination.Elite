/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entite.Destination;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import static gui.InterfaceAFFICHAGEController.selectedItems;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import services.DestinationServices;

/**
 * FXML Controller class
 *
 * @author chams
 */
public class ModifierController implements Initializable {

    @FXML public TextField nom;
    @FXML public TextField gouvernorat;
    @FXML public TextField type;
    @FXML public TextArea description;
    @FXML public ImageView photo1;
    @FXML public ImageView photo2;
    @FXML public ImageView photo3;
    @FXML public ImageView photo4;
    @FXML public ImageView photo5;
    @FXML public Button confirmer;
    Destination D1;
    
    DestinationServices DS=new DestinationServices();
    public String file1 = DS.afficherDestination().get(InterfaceAFFICHAGEController.D2.getSelection()).photo1;
    String file2 = DS.afficherDestination().get(InterfaceAFFICHAGEController.D2.getSelection()).photo2;
    String file3 = DS.afficherDestination().get(InterfaceAFFICHAGEController.D2.getSelection()).photo3;
    String file4 = DS.afficherDestination().get(InterfaceAFFICHAGEController.D2.getSelection()).photo4;
    String file5 = DS.afficherDestination().get(InterfaceAFFICHAGEController.D2.getSelection()).photo5;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        FileChooser fileChooser = new FileChooser();
       // System.out.println("selection mbaaed : "+InterfaceAFFICHAGEController.D2.getSelection());
        nom.setText(selectedItems.get(0).nom);
        gouvernorat.setText(selectedItems.get(0).gouvernorat);
        description.setText(selectedItems.get(0).description);
        type.setText(selectedItems.get(0).type);
        
        try {
            photo1.setImage(pathtoimage(file1));
            photo2.setImage(pathtoimage(file2));
            photo3.setImage(pathtoimage(file3));
            photo4.setImage(pathtoimage(file4));
            photo5.setImage(pathtoimage(file5));
        
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ModifierController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
           
        photo1.setOnMouseClicked(action -> {          
            
                Stage stage = new Stage();
            File selectedFile = fileChooser.showOpenDialog(stage); 
             file1 = selectedFile.getPath();
               
               
            ImageView image;
            try {
                image = new ImageView(pathtoimage(file1));
                photo1.setImage(image.getImage()); 
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ModifierController.class.getName()).log(Level.SEVERE, null, ex);
            }
                                 
            });
        
        photo2.setOnMouseClicked(action -> {
         
                Stage stage = new Stage();
            File selectedFile = fileChooser.showOpenDialog(stage); 
             file2 = selectedFile.getPath();
                
               
            ImageView image;
            try {
                image = new ImageView(pathtoimage(file2));
                photo2.setImage(image.getImage());  
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ModifierController.class.getName()).log(Level.SEVERE, null, ex);
            }
                     
            
           
            });
        
        photo3.setOnMouseClicked(action -> {
            
                Stage stage = new Stage();
            File selectedFile = fileChooser.showOpenDialog(stage); 
             file3 = selectedFile.getPath();
                
               
            ImageView image;
            try {
                image = new ImageView(pathtoimage(file3));
                photo3.setImage(image.getImage()); 
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ModifierController.class.getName()).log(Level.SEVERE, null, ex);
            }
                      

            });
        
        photo4.setOnMouseClicked(action -> {
         
                Stage stage = new Stage();
            File selectedFile = fileChooser.showOpenDialog(stage); 
             file4 = selectedFile.getPath();
                
               
            ImageView image;
            try {
                image = new ImageView(pathtoimage(file4));
                photo4.setImage(image.getImage()); 
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ModifierController.class.getName()).log(Level.SEVERE, null, ex);
            }
                      
            
            });
        
        photo5.setOnMouseClicked(action -> {
          
                Stage stage = new Stage();
            File selectedFile = fileChooser.showOpenDialog(stage); 
             file5 = selectedFile.getPath();
               ImageView image;
            try {
                image = new ImageView(pathtoimage(file5));
                photo5.setImage(image.getImage());  
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ModifierController.class.getName()).log(Level.SEVERE, null, ex);
            }
               
            
                     
            
            });
        confirmer.setOnAction(action ->{
        Destination D5 = new Destination();
        DestinationServices Ds = new DestinationServices();
        D5.setNom(nom.getText());
        D5.setGouvernorat(gouvernorat.getText());
        D5.setType(nom.getText());
        D5.setNom(nom.getText());
        D5.setDescription(description.getText());
        D5.setPhoto1(file1);
        D5.setPhoto2(file2);
        D5.setPhoto3(file3);
        D5.setPhoto4(file4);
        D5.setPhoto5(file5);
        
        D5.setId(DS.afficherDestination().get(InterfaceAFFICHAGEController.D2.getSelection()).id);
        DS.modifierDestination(D5);
        });
                         
    }   
    
 
    public Image pathtoimage(String path) throws FileNotFoundException{
        FileInputStream inputstream = new FileInputStream(path); 
        Image image = new Image(inputstream); 

      return image;
    }
    
}
