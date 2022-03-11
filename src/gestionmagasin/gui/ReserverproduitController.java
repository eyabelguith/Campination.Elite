/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionmagasin.gui;

import gestionmagasin.entity.Produit;
import gestionmagasin.entity.Reservation;
import gestionmagasin.services.MyListener;
import gestionmagasin.services.ProduitServices;
import gestionmagasin.services.ReservationServices;
import gestionmagasin.utils.Mailapi;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * FXML Controller class
 *
 * 
 */
public class ReserverproduitController implements Initializable {

    @FXML
    private AnchorPane anchorePane;
    @FXML
    private GridPane grid;
    @FXML
    private TextField tfrecherche;
    @FXML
    private Label idgetter;
    @FXML
    private ComboBox<String> combotri;
    ProduitServices ps=new ProduitServices();
    ReservationServices rs=new ReservationServices();
    ObservableList<String> options=FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        refresh(ps.AfficherPrduit());
        options.add("A-Z");
        options.add("Date");
        combotri.setItems(options);
    }    

    @FXML
    private void tri(ActionEvent event) {
        grid.getChildren().clear();
        if(combotri.getValue().equals("A-Z")){
            grid.getChildren().clear();
            refresh(ps.triparNom());
            
        }
        else{
            refresh(ps.AfficherPrduit().stream().sorted(Comparator.comparing(Produit::getDatePublication)).collect(Collectors.toList()));
        }
    }
MyListener myListener;
    public void selectedProduit(Produit p){
        idgetter.setText(String.valueOf(p.getIdProduit()));
         
        
    }
    @FXML
    private void reserver(ActionEvent event) {
        
        Produit p=ps.AfficherPrduitParId(Integer.parseInt(idgetter.getText()));
        
        if(p.getEtat().equals("Disponible")){
            rs.AjouterReservation(new Reservation(1,Integer.parseInt(idgetter.getText()),LocalDateTime.now()));
            p.setEtat("Non Disponible");
            p.setDateVente(LocalDateTime.now());
            ps.modifierProduit(Integer.parseInt(idgetter.getText()), p);
            Mailapi.send("testapimail63@gmail.com", "TESTapimail2022", "hela.ouni@esprit.tn", "Produit reserver", "Vous avez reservez le produit "+p.getNomProduit());
            refresh(ps.AfficherPrduit());
        }
        else{
            Alert alert =new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Errors");
            alert.setContentText("Produit non disponible");
            alert.showAndWait();
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
        recherche_avance(produits);
    }
     public void recherche_avance(List<Produit> produits){
        
        ObservableList<Produit> list=FXCollections.observableArrayList(produits);
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
    private void mesProduits(ActionEvent event) {
        try {
            Stage stageclose=(Stage) ((Node)event.getSource()).getScene().getWindow();
            
            stageclose.close();
            Parent root=FXMLLoader.load(getClass().getResource("/gestionmagasin/gui/AjoutProduit.fxml"));
            Stage stage =new Stage();
            
            Scene scene = new Scene(root);
            
            stage.setTitle("Produit");
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ReserverproduitController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void pdf(ActionEvent event) {
         ReservationServices rs = new ReservationServices();
        ObservableList<Reservation> list = FXCollections.observableArrayList(rs.AfficherReservation(1));
        
        try{
            
            OutputStream file = new FileOutputStream(new File("C:\\Users\\ASUS\\Desktop\\magasin\\GestionMagasin\\Reservation.pdf"));
            Document document = new Document();
            PdfWriter.getInstance(document, file);
            document.open();
            
            Font font = new Font(Font.FontFamily.HELVETICA, 24, Font.BOLD);
            Paragraph pdfTitle = new Paragraph("Liste des Reservations", font);
            pdfTitle.setAlignment(Element.ALIGN_CENTER);
            
            document.add(pdfTitle);
            document.add(new Chunk("\n"));
            PdfPTable table = new PdfPTable(3);
            table.setHeaderRows(1);
            table.addCell("Id Reservation");
            table.addCell("Date");
            table.addCell("Nom du Produit");
            
            list.forEach((item) -> {
                table.addCell(String.valueOf(item.getIdReservation()));
                table.addCell(String.valueOf(item.getDateDeReservation()));
                table.addCell(String.valueOf(ps.AfficherPrduitParId(item.getIdProduit()).getNomProduit()));
                
                
                
              
            });

            document.add(table);
              Alert alert = new Alert(Alert.AlertType.INFORMATION);
              alert.setTitle("Success");
            alert.setContentText("Success!");
            alert.show();
            document.close();

            file.close();
        } catch (Exception ex) {
          Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Cannot export data!");
            alert.show();
        }
    }

}
