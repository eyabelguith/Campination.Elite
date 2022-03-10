/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Campination.App.Gui;

import Campination.App.Entity.Admin;
import Campination.App.Entity.Camper;
import Campination.App.Entity.Transporteur;
import Campination.App.Services.AdminServices;
import Campination.App.Services.CamperServices;
import Campination.App.Services.TransporteurServices;
import java.io.IOException;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Eya
 */
public class InterfaceListTransporteurController implements Initializable {

    ObservableList<Transporteur> List;
    public String x, y;
    @FXML
    private TableColumn<Transporteur, String> colNom;

    @FXML
    private TableColumn<Transporteur, String> colG;
    @FXML
    private TableColumn<Transporteur, String> colT;
    @FXML
    private TableColumn<Transporteur, String> colC;

    @FXML
    private TableView<Transporteur> TableT;
    @FXML
    private ComboBox choixR;
    ObservableList<String> Choix = FXCollections.observableArrayList("Nom", "Capacite", "Transport");
    @FXML
    private Button res;
    @FXML
    private TableColumn<Transporteur, String> dispo;
    @FXML
    private AnchorPane anchor2;
    @FXML
    private Button logoutbtn1;
    @FXML
    private Label nmbr;
    @FXML
    private AnchorPane navItem;
    @FXML
    private AnchorPane anchor;
    @FXML
    private Button users;
    @FXML
    private Button dest;
    @FXML
    private Button mag;
    @FXML
    private Button eventt;
    @FXML
    private Button sortie;
    @FXML
    private Button transp;
    @FXML
    private Button vip;
    @FXML
    private AnchorPane anchor1;
    private TextField txtsup;
    @FXML
    private ImageView viewAll;
    @FXML
    private TextField txtrech;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colNom.setCellValueFactory(new PropertyValueFactory<Transporteur, String>("nom"));
        //   colCin.setCellValueFactory(new PropertyValueFactory<Transporteur, String>("cin"));
        // colNum.setCellValueFactory(new PropertyValueFactory<Transporteur, String>("num_tel"));
        colG.setCellValueFactory(new PropertyValueFactory<Transporteur, String>("gouvernorat"));
        colT.setCellValueFactory(new PropertyValueFactory<Transporteur, String>("moyenT"));
        colC.setCellValueFactory(new PropertyValueFactory<Transporteur, String>("capacite"));
        //   colM.setCellValueFactory(new PropertyValueFactory<Transporteur, String>("matricule"));
        //  colRole.setCellValueFactory(new PropertyValueFactory<Transporteur, String>("role"));
        dispo.setCellValueFactory(new PropertyValueFactory<Transporteur, String>("disponibilite"));
        choixR.setItems(Choix);

        nmbr.setText(String.valueOf(AfficherTrans().size()));
        //System.out.println();

        TableT.setItems(AfficherTrans());
        res.setOnAction(action -> {
            x = txtrech.getText();
            y = (String) choixR.getValue();

            TableT.setItems(rechercher(y, x));

        });
    }

    public ObservableList<Transporteur> AfficherTrans() {
        TransporteurServices dest = new TransporteurServices();
        ObservableList<Transporteur> Transporteur = FXCollections.observableArrayList(dest.AfficherTransporteurDispo());

        return Transporteur;
    }

    public ObservableList<Transporteur> AfficherAll() {
        TransporteurServices dest = new TransporteurServices();
        ObservableList<Transporteur> Transporteur = FXCollections.observableArrayList(dest.AfficherTransporteur());

        return Transporteur;
    }

    public ObservableList<Transporteur> rechercher(String x, String y) {
        TransporteurServices Ts = new TransporteurServices();
        ObservableList<Transporteur> Transporteur = FXCollections.observableArrayList(Ts.RechercherTransporteur(x, y));
        dispo.setStyle("-fx-text-fill: green; -fx-font-size: 16px;");
        //colRole.setStyle("-fx-text-fill:  #291cdf; -fx-font-size: 16px;");

        return Transporteur;
    }

    @FXML
    private void rechercher(ActionEvent event) {
    }

    @FXML
    private void logout(ActionEvent event) {
        logoutbtn1.setOnAction(e -> {

            try {
                Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    @FXML
    private void goAcceuil(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("acceuil.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AcceuilController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void godest(ActionEvent event) {
    }

    @FXML
    private void goMag(ActionEvent event) {
    }

    @FXML
    private void goevent(ActionEvent event) {
    }

    @FXML
    private void gosortie(ActionEvent event) {
    }

    @FXML
    private void goTransp(ActionEvent event) {
    }

    @FXML
    private void goVip(ActionEvent event) {
    }

    @FXML
    private void GoAjout(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("InterfaceAjoutTransporteur.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(InterfaceAjoutTransporteurController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void SupprimerTrans(ActionEvent event) {
        String t = txtsup.getText();
        TransporteurServices ts = new TransporteurServices();
        Transporteur tp = new Transporteur();
        tp.setCinT(Integer.parseInt(t));
        ts.SuprimerTransporteur(tp);
        UpdateTable();
    }

    public void UpdateTable() {
        colNom.setCellValueFactory(new PropertyValueFactory<Transporteur, String>("nom"));

        colG.setCellValueFactory(new PropertyValueFactory<Transporteur, String>("gouvernorat"));
        colT.setCellValueFactory(new PropertyValueFactory<Transporteur, String>("moyenT"));
        colC.setCellValueFactory(new PropertyValueFactory<Transporteur, String>("capacite"));

        dispo.setCellValueFactory(new PropertyValueFactory<Transporteur, String>("disponibilite"));

        TableT.setItems(AfficherTrans());
        //   nmbr.setText(String.valueOf(AfficherTrans().size()));
    }

    @FXML
    private void ViewAll(ActionEvent event) {
        colNom.setCellValueFactory(new PropertyValueFactory<Transporteur, String>("nom"));

        colG.setCellValueFactory(new PropertyValueFactory<Transporteur, String>("gouvernorat"));
        colT.setCellValueFactory(new PropertyValueFactory<Transporteur, String>("moyenT"));
        colC.setCellValueFactory(new PropertyValueFactory<Transporteur, String>("capacite"));

        //     colRole.setCellValueFactory(new PropertyValueFactory<Transporteur, String>("role"));
        dispo.setCellValueFactory(new PropertyValueFactory<Transporteur, String>("disponibilite"));
        choixR.setItems(Choix);

        nmbr.setText(String.valueOf(AfficherAll().size()));
        //System.out.println();

        TableT.setItems(AfficherAll());
        res.setOnAction(action -> {
            x = txtrech.getText();
            y = (String) choixR.getValue();

            TableT.setItems(rechercher(y, x));

        });
    }

    @FXML
    private void refresh(ActionEvent event) {
        colNom.setCellValueFactory(new PropertyValueFactory<Transporteur, String>("nom"));
        //   colCin.setCellValueFactory(new PropertyValueFactory<Transporteur, String>("cin"));
        // colNum.setCellValueFactory(new PropertyValueFactory<Transporteur, String>("num_tel"));
        colG.setCellValueFactory(new PropertyValueFactory<Transporteur, String>("gouvernorat"));
        colT.setCellValueFactory(new PropertyValueFactory<Transporteur, String>("moyenT"));
        colC.setCellValueFactory(new PropertyValueFactory<Transporteur, String>("capacite"));
        //   colM.setCellValueFactory(new PropertyValueFactory<Transporteur, String>("matricule"));
        //  colRole.setCellValueFactory(new PropertyValueFactory<Transporteur, String>("role"));
        dispo.setCellValueFactory(new PropertyValueFactory<Transporteur, String>("disponibilite"));

        TableT.setItems(AfficherTrans());
        nmbr.setText(String.valueOf(AfficherTrans().size()));
    }

    @FXML
    private void pressedT(MouseEvent event) {
        TableT.setOnMousePressed((MouseEvent e) -> {
            Transporteur selectedForEdit = TableT.getSelectionModel().getSelectedItem();
            if (e.isPrimaryButtonDown() && e.getClickCount() == 2) {
                Stage home = new Stage();
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceInfoTransporteur.fxml"));
                    Parent parent = loader.load();

                    InterfaceInfoTransporteurController controller = (InterfaceInfoTransporteurController) loader.getController();
                    controller.inflateUI(selectedForEdit);

                    Stage stage = new Stage();

                    stage.setScene(new Scene(parent));
                    stage.show();

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
