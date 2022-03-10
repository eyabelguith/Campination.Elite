/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Campination.App.Services;
import Campination.App.Entity.VIP;
import java.util.ArrayList;
import javafx.collections.ObservableList;

/**
 *
 * @author Eya
 */
public interface Ivip {
     public int ajouterSVip(VIP v);
    public int modifierVip(VIP v); 
    public int supprimerVip(VIP v);
    public ArrayList<VIP> afficherVip(); 
  // public int calculepoints ();
      public ObservableList <VIP > vaffiche();
}
