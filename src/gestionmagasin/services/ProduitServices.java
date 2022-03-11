/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionmagasin.services;

import gestionmagasin.entity.Produit;
import gestionmagasin.utils.MyConnexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * 
 */
public class ProduitServices implements InterfaceProduit{
Connection connx ;
     Statement ste;
        public ProduitServices() {
        connx = MyConnexion.getInstanceConnex().getConnection();
        try {
            ste = connx.createStatement();
        } catch (SQLException ex) {
                    System.out.println(ex);
        }
   
    }
    @Override
    public int AjouterProduit(Produit p) {
         int x = 0;
        try {
            String sql="INSERT INTO `produit`( `nomProduit`, `prix`, `categorie`, `etat`,"
                    + " `description`, `datePublication`, `image`, `idUser`) VALUES "
                    + "('"+p.getNomProduit()+"','"+p.getPrix()+"',"
                    + "'"+p.getCategorie()+"','"+p.getEtat()+"','"+p.getDescription()+"',"
                    + "'"+p.getDatePublication()+"','"+p.getImage()+"','"+p.getIdUser()+"')";
          
            x = ste.executeUpdate(sql);
            
        } catch (SQLException ex) {
            Logger.getLogger(ProduitServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  x;
    }

    @Override
    public int modifierProduit(int id,Produit p) {
        int x = 0;
        try {
            String sql="UPDATE `produit` SET `nomProduit`='"+p.getNomProduit()+"',"
                    + "`prix`='"+p.getPrix()+"',"
                    + "`categorie`='"+p.getCategorie()+"',"
                    + "`etat`='"+p.getEtat()+"',"
                    + "`description`='"+p.getDescription()+"',"
                    + "`datePublication`='"+p.getDatePublication()+"',"
                    + "`dateVente`='"+p.getDateVente()+"',"
                    + "`image`='"+p.getImage()+"',`idUser`='"+p.getIdUser()+"' WHERE idProduit="+id;
          
            x = ste.executeUpdate(sql);
            
        } catch (SQLException ex) {
            Logger.getLogger(ProduitServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  x;
    }

    @Override
    public int SupprimerProduit(int id) {
        int x = 0;
        try {
            String sql="DELETE FROM `produit` WHERE idProduit="+id;
          
            x = ste.executeUpdate(sql);
            
        } catch (SQLException ex) {
            Logger.getLogger(ProduitServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  x;
    }

    @Override
    public List<Produit> AfficherPrduit() {
        List<Produit> lp=new ArrayList<>();
        try {
            
            String query="select * from produit";
            ResultSet rs=ste.executeQuery(query);
            while(rs.next()){
                Produit p =new Produit();
                p.setCategorie(rs.getString("categorie"));
                p.setDatePublication(rs.getTimestamp("datePublication").toLocalDateTime());
//                p.setDateVente(rs.getTimestamp("dateVente").toLocalDateTime());
                p.setDescription(rs.getString("description"));
                p.setEtat(rs.getString("etat"));
                p.setIdProduit(rs.getInt("idProduit"));
                p.setImage(rs.getString("image"));
                p.setNomProduit(rs.getString("nomProduit"));
                p.setPrix(rs.getFloat("prix"));
                p.setIdUser(rs.getInt("idUser"));
                lp.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProduitServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lp;
    }
    public Produit AfficherPrduitParId(int id) {
        Produit p =new Produit();
        try {
            
            String query="select * from produit where idProduit="+id;
            ResultSet rs=ste.executeQuery(query);
            while(rs.next()){
                
                p.setCategorie(rs.getString("categorie"));
                p.setDatePublication(rs.getTimestamp("datePublication").toLocalDateTime());
//                p.setDateVente(rs.getTimestamp("dateVente").toLocalDateTime());
                p.setDescription(rs.getString("description"));
                p.setEtat(rs.getString("etat"));
                p.setIdProduit(rs.getInt("idProduit"));
                p.setImage(rs.getString("image"));
                p.setNomProduit(rs.getString("nomProduit"));
                p.setPrix(rs.getFloat("prix"));
                p.setIdUser(rs.getInt("idUser"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProduitServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }
    public List<Produit> triparNom(){
        List<Produit> resultat=AfficherPrduit().stream().sorted(Comparator.comparing(Produit::getNomProduit)).collect(Collectors.toList());
        return resultat;
    }
    
}
