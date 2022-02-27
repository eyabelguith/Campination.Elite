/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campination.gestionsortie.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Eya
 */
public class SortiebaladeController implements Initializable {

    @FXML
    private Label LafficheSB;
    @FXML
    private AnchorPane menuS;
    @FXML
    private ComboBox<?> CBOXdestination;
    @FXML
    private ComboBox<?> CBOXtransporteur;
    @FXML
    private ComboBox<?> CBOXcoach;
    @FXML
    private ComboBox<?> CBOXtypeS;
    @FXML
    private DatePicker Bdatedepart;
    @FXML
    private DatePicker BdateR;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void afficherSB(ActionEvent event) {
    }

    @FXML
    private void modifierSB(ActionEvent event) {
    }

    @FXML
    private void AjouterSB(ActionEvent event) {
    }

    @FXML
    private void chercherSB(ActionEvent event) {
    }

    @FXML
    private void trierSB(ActionEvent event) {
    }
    
}
