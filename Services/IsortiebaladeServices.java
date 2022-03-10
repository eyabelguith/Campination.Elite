/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Campination.App.Services;

import Campination.App.Entity.Sortiebalade;
import java.util.ArrayList;
import javafx.collections.ObservableList;

/**
 *
 * @author Eya
 */
public interface IsortiebaladeServices {
    public int ajouterSortiebalade(Sortiebalade sb);
    public int modifierSortiebalade(Sortiebalade sb); 
    public int supprimerSortiebalade(Sortiebalade sb);
   // public ArrayList<Sortiebalade> afficherSortiebalade();
    public ObservableList <Sortiebalade > sbaffiche();
public  ArrayList<Sortiebalade>rechercherSB(String  C ,String V);}

