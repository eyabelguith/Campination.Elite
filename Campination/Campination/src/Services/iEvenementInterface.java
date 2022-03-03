/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

package services;
import entite.Evenement;
import java.util.ArrayList;
import javafx.collections.ObservableList;

/**
 *
 * @author IHEB
 */

public interface iEvenementInterface {
     public int ajouterEvenement(Evenement e);
     public int supprimerEvenement(Evenement e);
     public int modifierEvenement(Evenement e);
     public ArrayList<Evenement> afficherEvenement();
     public ObservableList<Evenement> getDataEvenement();
     public ArrayList<Evenement> rechercherEvenement(String V,String C);
    
}
