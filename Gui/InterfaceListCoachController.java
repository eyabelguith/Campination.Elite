/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Campination.App.Gui;

import Campination.App.Entity.Camper;
import Campination.App.Entity.Coach;
import Campination.App.Services.CamperServices;
import Campination.App.Services.CoachServices;
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
import javafx.scene.chart.PieChart.Data;
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
public class InterfaceListCoachController implements Initializable {

    private String x, y;
    ObservableList<Coach> List;
    ObservableList<Coach> ListM;
    /*private final Button btn = new Button("Action");
 private final TableView<Data> table = new TableView<>();*/
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
    private AnchorPane anchor;
    @FXML
    private AnchorPane anchor2;
    @FXML
    private TableColumn<Coach, String> txtNom;
    private TableColumn<Coach, String> txtPrenom;
    private TableColumn<Coach, String> txtCin;
    @FXML
    private TableColumn<Coach, String> txtEmail;
    @FXML
    private TableColumn<Coach, String> txtTypeS;
    private TableColumn<Coach, String> txtSexe;
    @FXML
    private TableColumn<Coach, String> txtNum;
    @FXML
    private TableColumn<Coach, String> txtGov;
    private TableColumn<Coach, String> txtLogin;
    private TableColumn<Coach, String> txtpwd;
    private TableColumn<Coach, String> txtRole;
    @FXML
    private TableView<Coach> TableCo;
    @FXML
    private ComboBox choixC;
    @FXML
    private TextField rech;
    @FXML
    private Button resh;
    ObservableList<String> Choix = FXCollections.observableArrayList("Type_sport", "Gouvernorat", "Nom");
    private TextField Unom;
    private TextField Uprenom;
    private TextField Ucin;
    private TextField Usexe;
    private TextField UnumT;
    private TextField Ugov;
    private TextField Upwd;
    private TextField Uemail;
    private TextField Ulogin;
    private TextField Utypes;
    private TextField Urole;
    private TextField txtcins;
    @FXML
    private Label numer;
    @FXML
    private Button logoutbtn1;
  


    /*  @FXML
    private TableColumn action;
     */
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtNom.setCellValueFactory(new PropertyValueFactory<Coach, String>("nom"));
        
      //  txtPrenom.setCellValueFactory(new PropertyValueFactory<Coach, String>("prenom"));
        //txtCin.setCellValueFactory(new PropertyValueFactory<Coach, String>("cin"));
        txtEmail.setCellValueFactory(new PropertyValueFactory<Coach, String>("email"));
        txtTypeS.setCellValueFactory(new PropertyValueFactory<Coach, String>("type_sport"));
       // txtSexe.setCellValueFactory(new PropertyValueFactory<Coach, String>("sexe"));
        txtNum.setCellValueFactory(new PropertyValueFactory<Coach, String>("num_Tel"));
        txtGov.setCellValueFactory(new PropertyValueFactory<Coach, String>("gouvernorat"));
       // txtLogin.setCellValueFactory(new PropertyValueFactory<Coach, String>("login"));
        //txtpwd.setCellValueFactory(new PropertyValueFactory<Coach, String>("pwd"));
        //txtRole.setCellValueFactory(new PropertyValueFactory<Coach, String>("role"));
         
               
        numer.setText(String.valueOf(AfficherCoachs().size()));
        choixC.setItems(Choix);
        TableCo.setItems(AfficherCoachs());

        CoachServices c = new CoachServices();
        // this.button = new Button();
        //  action.setOnAction(e -> System.out.println("Default action"));

        resh.setOnAction(action -> {
            x = rech.getText();
            y = (String) choixC.getValue();

            TableCo.setItems(rechercherC(x, y));

        });

    }

    public ObservableList<Coach> rechercherC(String y, String x) {
        CoachServices Ts = new CoachServices();
        ObservableList<Coach> Camp = FXCollections.observableArrayList(Ts.RechercherCoach(x, y));

        return Camp;
    }

    public ObservableList<Coach> AfficherCoachs() {
        CoachServices c = new CoachServices();
        ObservableList<Coach> coaches = FXCollections.observableArrayList(c.AfficherCoach());

        return coaches;
    }

    @FXML
    private void goAcceuil(ActionEvent event) {
          try {
            Parent root=FXMLLoader.load(getClass().getResource("acceuil.fxml"));
            Scene scene =new Scene(root);
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
    private void logout(ActionEvent event) {
          try {
            Parent root=FXMLLoader.load(getClass().getResource("login.fxml"));
            Scene scene =new Scene(root);
       Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void goProfil(ActionEvent event) {
          try {
            Parent root=FXMLLoader.load(getClass().getResource("InterfaceProfils.fxml"));
            Scene scene =new Scene(root);
       Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(InterfaceProfilsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void RechercherC(ActionEvent event) {
    }


   

    public void UpdateTable() {
        txtNom.setCellValueFactory(new PropertyValueFactory<Coach, String>("nom"));
       // txtPrenom.setCellValueFactory(new PropertyValueFactory<Coach, String>("prenom"));
      //  txtCin.setCellValueFactory(new PropertyValueFactory<Coach, String>("cin"));
        txtEmail.setCellValueFactory(new PropertyValueFactory<Coach, String>("email"));
        txtTypeS.setCellValueFactory(new PropertyValueFactory<Coach, String>("type_sport"));
        //txtSexe.setCellValueFactory(new PropertyValueFactory<Coach, String>("sexe"));
        txtNum.setCellValueFactory(new PropertyValueFactory<Coach, String>("num_Tel"));
        txtGov.setCellValueFactory(new PropertyValueFactory<Coach, String>("gouvernorat"));
        //txtLogin.setCellValueFactory(new PropertyValueFactory<Coach, String>("login"));
        //txtpwd.setCellValueFactory(new PropertyValueFactory<Coach, String>("pwd"));
        //txtRole.setCellValueFactory(new PropertyValueFactory<Coach, String>("role"));
       /* CoachServices c = new CoachServices();
        ListM = c.AfficherListeCoach();
        TableCo.setItems(ListM);*/
       TableCo.setItems(AfficherCoachs());

    }

  

    private void SupprimerCoach(ActionEvent event) {
        String t = txtcins.getText();
        CoachServices sp = new CoachServices();
        Coach co = new Coach();
        co.setCinCO(Integer.parseInt(t));
        sp.SupprimerCoach(co);
        UpdateTable();
    }

    @FXML
    private void goAjout(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("InterfaceAjoutCoach.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(InterfaceAjoutCoachController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void refresh(ActionEvent event) {
         txtNom.setCellValueFactory(new PropertyValueFactory<Coach, String>("nom"));
      //  txtPrenom.setCellValueFactory(new PropertyValueFactory<Coach, String>("prenom"));
        //txtCin.setCellValueFactory(new PropertyValueFactory<Coach, String>("cin"));
        txtEmail.setCellValueFactory(new PropertyValueFactory<Coach, String>("email"));
        txtTypeS.setCellValueFactory(new PropertyValueFactory<Coach, String>("type_sport"));
       // txtSexe.setCellValueFactory(new PropertyValueFactory<Coach, String>("sexe"));
        txtNum.setCellValueFactory(new PropertyValueFactory<Coach, String>("num_Tel"));
        txtGov.setCellValueFactory(new PropertyValueFactory<Coach, String>("gouvernorat"));
       // txtLogin.setCellValueFactory(new PropertyValueFactory<Coach, String>("login"));
        //txtpwd.setCellValueFactory(new PropertyValueFactory<Coach, String>("pwd"));
        //txtRole.setCellValueFactory(new PropertyValueFactory<Coach, String>("role"));
        numer.setText(String.valueOf(AfficherCoachs().size()));
        choixC.setItems(Choix);
        TableCo.setItems(AfficherCoachs());
    }




    @FXML
    private void press(MouseEvent event) {
                 TableCo.setOnMousePressed ((MouseEvent e) -> {
               Coach selectedForEdit = TableCo.getSelectionModel().getSelectedItem();
        if (e.isPrimaryButtonDown() && e.getClickCount() == 2) {
            Stage home=new Stage ();
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceInfoCoach.fxml"));
                Parent parent = loader.load();
                
                InterfaceInfoCoachController controller = (InterfaceInfoCoachController) loader.getController();
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
