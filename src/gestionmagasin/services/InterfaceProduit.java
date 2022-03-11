/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionmagasin.services;

import gestionmagasin.entity.Produit;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * 
 */
public interface InterfaceProduit {
    public int AjouterProduit(Produit p);
    public int modifierProduit(int id,Produit p);
    public int SupprimerProduit(int id);
    public List<Produit> AfficherPrduit();
}
