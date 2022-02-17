/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campination.gestionsortie.services;

import campination.gestionsortie.entities.Sortiebalade;
import java.util.ArrayList;

/**
 *
 * @author Eya
 */
public interface IsortiebaladeServices {
    public int ajouterSortiebalade(Sortiebalade sp);
    public int modifierSortiebalade(Sortiebalade sp); 
    public int supprimerSortiebalade(Sortiebalade sp);
    public ArrayList<Sortiebalade> afficherSortiebalade();   
}

