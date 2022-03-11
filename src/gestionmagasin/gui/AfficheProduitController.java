/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionmagasin.gui;

import gestionmagasin.entity.Produit;
import gestionmagasin.services.MyListener;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * 
 */
public class AfficheProduitController implements Initializable {

    @FXML
    private AnchorPane anchorePane;
    @FXML
    private ImageView imageview;
    @FXML
    private Label lnom;
    @FXML
    private Label ldescription;
    @FXML
    private Label letat;
    @FXML
    private Label lcat;
    @FXML
    private Label lprix;
    private MyListener myListener;
    private Produit p;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void setData(Produit p,MyListener myListener){
        this.p=p;
         this.myListener=myListener;
        lcat.setText(p.getCategorie());
        ldescription.setText(p.getDescription());
        letat.setText(p.getEtat());
        lnom.setText(p.getNomProduit());
        lprix.setText(String.valueOf(p.getPrix()));
        File f = new File("C:\\Users\\ASUS\\Desktop\\magasin\\GestionMagasin\\src\\gestionmagasin\\gui\\images\\" + p.getImage());
         Image img1 = new Image(f.toURI().toString());
         imageview.setImage(img1);
        
    }

    @FXML
    private void selectedproduit(MouseEvent event) {
        myListener.onClickListener(p);
    }
    
}
