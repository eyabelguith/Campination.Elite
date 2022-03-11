/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionmagasin.gui;

import gestionmagasin.entity.Produit;
import gestionmagasin.services.MyListener;
import gestionmagasin.services.ProduitServices;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * 
 */
public class AjoutProduitController implements Initializable {

    @FXML
    private GridPane grid;
    @FXML
    private TextField tfnom;
    @FXML
    private TextField tfdescription;
    @FXML
    private ComboBox<String> combocat;
    @FXML
    private RadioButton rbdispo;
    @FXML
    private ToggleGroup gp1;
    @FXML
    private RadioButton rbndispo;
    @FXML
    private TextField tfprix;
    @FXML
    private TextField tfimage;
    @FXML
    private TextField tfrecherche;
    @FXML
    private Label idgetter;
    ProduitServices ps=new ProduitServices();
    @FXML
    private AnchorPane anchorePane;
    ObservableList<String> options=FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        options.add("pc");
        options.add("cat1");
        options.add("cat2");
        options.add("cat3");
        options.add("cat4");
        combocat.setItems(options);
        List<Produit> produits = ps.AfficherPrduit();
        refresh(produits);
        
    }  
    MyListener myListener;
    public void selectedProduit(Produit p){
        idgetter.setText(String.valueOf(p.getIdProduit()));
         tfdescription.setText(p.getDescription());
         tfimage.setText(p.getImage());
         tfnom.setText(p.getNomProduit());
         tfprix.setText(String.valueOf(p.getPrix()));
         combocat.setValue(p.getCategorie());
         if(p.getEtat().equals("Disponible")){
             rbdispo.setSelected(true);
         }
         else{
             rbndispo.setSelected(true);
         }
        
    }

    public void refresh(List<Produit> produits){
    
          

         grid.getChildren().clear();
          
         
         if(produits.size() > 0){
          selectedProduit(produits.get(0));
          myListener = new MyListener() {
              @Override
              public void onClickListener(Produit p) {
                  selectedProduit(p);
              }
             
              
         };
                  }
        int column = 0;
        int row = 1;
        
        try {
            for (int i = 0; i < produits.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/gestionmagasin/gui/afficheProduit.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                AfficheProduitController itemController = fxmlLoader.getController();
                itemController.setData(produits.get(i),myListener);

                if (column == 1) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        recherche_avance();
    }

    @FXML
    private void upload(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        Stage stage = (Stage)anchorePane.getScene().getWindow();
        File file = fileChooser.showOpenDialog(stage);
        if(file != null){
            tfimage.setText(file.getName());
        }
    }

    @FXML
    private void ajouter(ActionEvent event) {
        String erreurs="";
        if(combocat.getValue()==null){
            erreurs+="Categorie vide";
        }
        if(tfdescription.getText().trim().isEmpty()){
            erreurs+="Description vide";
        }
        if(tfnom.getText().trim().isEmpty()){
            erreurs+="Nom vide";
        }
        if(tfprix.getText().trim().isEmpty()){
            erreurs+="Prix vide";
        }
        if(erreurs.length()>0){
            Alert alert =new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Errors");
            alert.setContentText(erreurs);
            alert.showAndWait();
        }
        else{
            Produit p=new Produit();
            p.setCategorie(combocat.getValue());
            p.setDatePublication(LocalDateTime.now());
            p.setDescription(tfdescription.getText());
            if(rbdispo.isSelected()){
                p.setEtat("Disponible");
            }
            else if(rbndispo.isSelected()){
                p.setEtat("Non Disponible");
            }
            else{

            }
            p.setIdUser(1);
            p.setImage(tfimage.getText());
            p.setNomProduit(tfnom.getText());
            p.setPrix(Float.parseFloat(tfprix.getText()));
            ps.AjouterProduit(p);
            List<Produit> produits = ps.AfficherPrduit();
            refresh(produits);
        }
        
        
    }

    @FXML
    private void modifier(ActionEvent event) {
        String erreurs="";
        if(combocat.getValue()==null){
            erreurs+="Categorie vide";
        }
        if(tfdescription.getText().trim().isEmpty()){
            erreurs+="Description vide";
        }
        if(tfnom.getText().trim().isEmpty()){
            erreurs+="Nom vide";
        }
        if(tfprix.getText().trim().isEmpty()){
            erreurs+="Prix vide";
        }
        if(erreurs.length()>0){
            Alert alert =new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Errors");
            alert.setContentText(erreurs);
            alert.showAndWait();
        }
        else{
            Produit p=new Produit();
            p.setCategorie(combocat.getValue());
            p.setDatePublication(LocalDateTime.now());
            p.setDescription(tfdescription.getText());
            if(rbdispo.isSelected()){
                p.setEtat("Disponible");
            }
            else if(rbndispo.isSelected()){
                p.setEtat("Non Disponible");
            }
            else{

            }
            p.setIdUser(1);
            p.setImage(tfimage.getText());
            p.setNomProduit(tfnom.getText());
            p.setPrix(Float.parseFloat(tfprix.getText()));
            p.setDateVente(LocalDateTime.of(1, Month.MARCH, 1, 1, 1));
            ps.modifierProduit(Integer.parseInt(idgetter.getText()), p);
            List<Produit> produits = ps.AfficherPrduit();
            refresh(produits);
        }
        
    }

    @FXML
    private void supprimer(ActionEvent event) {
        ps.SupprimerProduit(Integer.parseInt(idgetter.getText()));
        ProduitServices ps=new ProduitServices();
        List<Produit> produits = ps.AfficherPrduit();
        refresh(produits);
    }
    public void recherche_avance(){
        
        ObservableList<Produit> list=FXCollections.observableArrayList(ps.AfficherPrduit());
        FilteredList<Produit> filtereddata=new FilteredList<>(list,b->true);
        int column1 = 0;
        int row1 = 1;
        try {
            for (int i = 0; i < list.size(); i++) {
               FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/gestionmagasin/gui/afficheProduit.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                AfficheProduitController itemController = fxmlLoader.getController();
                itemController.setData(list.get(i),myListener);

                if (column1 == 1) {
                    column1 = 0;
                    row1++;
                }

                grid.add(anchorPane, column1++, row1); //(child,column,row)
                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        tfrecherche.textProperty().addListener((observable,oldvalue,newValue) -> {
            filtereddata.setPredicate(produit->{
                if(newValue==null||newValue.isEmpty()){
                    return true;
                }
                String lowercasefilter=newValue.toLowerCase();
                if(produit.getCategorie().toLowerCase().indexOf(lowercasefilter)!=-1){
                    return true;
                }
                else if(produit.getNomProduit().toLowerCase().indexOf(lowercasefilter)!=-1){
                    return true;
                }
                
                
                else if(produit.getDescription().toLowerCase().indexOf(lowercasefilter)!=-1){
                    return true;
                }
                
                
                else if(String.valueOf(produit.getPrix()).toString().toLowerCase().indexOf(lowercasefilter)!=-1){
                    return true;
                }
                
                
                else{
                    return false;
                }
                
            });
            grid.getChildren().clear();
          
          //affiche.setText(bb.afficher().toString());
         
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < filtereddata.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/gestionmagasin/gui/afficheProduit.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                AfficheProduitController itemController = fxmlLoader.getController();
                itemController.setData(filtereddata.get(i),myListener);

                if (column == 1) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        });
        
        
        
        
    
    }

    @FXML
    private void reserverproduit(ActionEvent event) {
        try {
            Stage stageclose=(Stage) ((Node)event.getSource()).getScene().getWindow();
            
            stageclose.close();
            Parent root=FXMLLoader.load(getClass().getResource("/gestionmagasin/gui/Reserverproduit.fxml"));
            Stage stage =new Stage();
            
            Scene scene = new Scene(root);
            
            stage.setTitle("Produit");
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AjoutProduitController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void stat(ActionEvent event) {
        try {
            Stage stageclose=(Stage) ((Node)event.getSource()).getScene().getWindow();
            
            stageclose.close();
            Parent root=FXMLLoader.load(getClass().getResource("/gestionmagasin/gui/FXMLstat.fxml"));
            Stage stage =new Stage();
            
            Scene scene = new Scene(root);
            
            stage.setTitle("Statistique");
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AjoutProduitController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
