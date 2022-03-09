/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campination.gestionsortie.gui;

import campination.gestionsortie.entities.VIP;
import campination.gestionsortie.services.Mailing;
import campination.gestionsortie.services.VipServices;
import campination.gestionsortie.utils.mailv;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Eya
 */
public class HomeprofilVipController implements Initializable {

    @FXML
    private TextField TX;
    @FXML
    private TextField TXX;
    @FXML
    private TextField TXXX;
    @FXML
    private TextField TXXXX;
    @FXML
    private Button buttonM;
    @FXML
    private Button sendm;
    @FXML
    private Button button3;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void modifier(ActionEvent event) {
    String ps = TX.getText().toString();
        String nb = TXX.getText().toString();
        String pl = TXXX.getText().toString();
        String f = TXXXX.getText().toString();
       
        
               VipServices sp=new VipServices();
       VIP p = new VIP();
       
       
        p.setCin(Integer.parseInt(ps));
        p.setNb_SB(Integer.parseInt(nb));
       
        p.setNb_SS(Integer.parseInt(pl));
        p.setNb_pt(Integer.parseInt(f));
         p.setCin(Integer.parseInt(ps));
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
                  alert.setTitle("Information ");
                  alert.setHeaderText("Modifier vip");
                  alert.setContentText("vous etes sure ?");
               
                  if(alert.showAndWait().get()==ButtonType.OK){
                    sp.modifierVip(p);
                
                
                 
                  }
                  else{
                  alert.close();
                  }}
    public void send(VIP s)  {
        TX.setText(String.valueOf(s.getCin()));
        TXX.setText(String.valueOf(s.getNb_SB()));
        TXXX.setText(String.valueOf(s.getNb_SS()));
        TXXXX.setText(String.valueOf(s.getNb_pt()));
       
                }  

    @FXML
    private void sendm(ActionEvent event) {
    mailv m=new mailv();
    m.replyMail("eyatalbi03@gmail.com", "User", "you won", "you deppased 500 points as a vip , contact us to chose from the available items");}

    @FXML
    private void supprimer3(ActionEvent event) {
    String name=TX.getText().toString();
       VipServices sp=new VipServices();
       VIP p = new VIP();
       
        p.setCin(Integer.parseInt(name));
       
         
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                  alert.setTitle("Information ");
                  alert.setHeaderText("suppression du vip");
                  alert.setContentText("vous etes sure?");
                 
                  if(alert.showAndWait().get()==ButtonType.OK){
                       sp.supprimerVip(p);
                       
            
                  }
                  else{
                  alert.close();
                  }}
}
