/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import javafx.scene.layout.*;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import gui.InterfaceAFFICHAGEController;
import static gui.InterfaceAFFICHAGEController.selectedItems;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.imageio.ImageIO;
import services.DestinationServices;
/**
 * FXML Controller class
 *
 * @author chams
 */
public class ProfilController implements Initializable {
    @FXML public TextField welcome;
    @FXML public Label titre;
    @FXML public Label gouvernorat;
    @FXML public Text description;
    @FXML public AnchorPane container;
    @FXML public ImageView back;
    @FXML public Button prev;
    @FXML public Button next;
    @FXML public Button delet;
    @FXML public Button updat;
     
    
    String path1 = selectedItems.get(0).photo1;
    String path2 = selectedItems.get(0).photo2;
    String path3 = selectedItems.get(0).photo3;
    String path4 = selectedItems.get(0).photo4;
    String path5 = selectedItems.get(0).photo5;
    
    String BLOBS[]= new String[]{path1,path2,path3,path4,path5};
    public static int num=0;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        titre.setText(selectedItems.get(0).nom);
        gouvernorat.setText(selectedItems.get(0).gouvernorat);
        description.setText(selectedItems.get(0).description);
        description.setWrappingWidth(80);
        for (int i =0; i<BLOBS.length;i++){
            System.out.println(BLOBS[i]);
        }

        
        try {
            container.setBackground(imagetobackground(pathtoimage(BLOBS[num])));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ProfilController.class.getName()).log(Level.SEVERE, null, ex);
        }
       

            delet.setOnAction(action -> {
           services.DestinationServices service = new DestinationServices();
           service.supprimerDestination(selectedItems.get(0));
            });
            
             updat.setOnAction(action -> {
           
                    try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("gui/modifier.fxml"));           
            Scene scene =new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            Stage current = (Stage) updat.getScene().getWindow();
            //current.close();
                    } catch (IOException ex) {
                       Logger.getLogger(InterfaceAFFICHAGEController.class.getName()).log(Level.SEVERE, null, ex);
                     }
             });
           
        
            next.setOnAction(action -> {
                System.out.print("num="+num);
                 
           
                if (num<4){
                    num++;
                    try { 
                        switchimgUp();
                    } catch (SQLException ex) {
                        Logger.getLogger(ProfilController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(ProfilController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                 
                }
                
                System.out.print("num="+num);
            
            });
            
            


       
    }   
    public void switchimgUp() throws SQLException, IOException{

           
            container.setBackground(imagetobackground(pathtoimage(BLOBS[num])));
    }

   
         
    public Image pathtoimage(String path) throws FileNotFoundException{
    FileInputStream inputstream = new FileInputStream(path); 
    Image image = new Image(inputstream); 
    return image;
    }
         
      
    
    public Background imagetobackground(Image img){
     
        BackgroundImage bImg = new BackgroundImage(img,
                                                   BackgroundRepeat.NO_REPEAT,
                                                   BackgroundRepeat.NO_REPEAT,
                                                   BackgroundPosition.DEFAULT,
                                                   BackgroundSize.DEFAULT);
        Background bGround = new Background(bImg);
     return bGround;   
    }
    
}
