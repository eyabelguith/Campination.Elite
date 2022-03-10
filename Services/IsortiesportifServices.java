/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Campination.App.Services;

import Campination.App.Entity.Sortiesportif;
import java.util.ArrayList;
import javafx.collections.ObservableList;

/**
 *
 * @author Eya
 */
public interface IsortiesportifServices {
   public int ajouterSortiesportif(Sortiesportif ss);
    public int modifierSortiesportif(Sortiesportif ss); 
    public int supprimerSortiesportif(Sortiesportif ss);
   // public ArrayList<Sortiesportif> afficherSortiesportif();
      public ObservableList <Sortiesportif > sbaffiche();
}
