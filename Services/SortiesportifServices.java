/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Campination.App.Services;

import Campination.App.Entity.Sortiesportif;
import Campination.App.Util.MyConnexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Eya
 */
public class SortiesportifServices implements IsortiesportifServices{
  Connection connx ;
     Statement ste;   
 public SortiesportifServices() {
        connx = MyConnexion.getInstanceConnex().getConnection();
        try {
            ste = connx.createStatement();
        } catch (SQLException ex) {
                    System.out.println(ex);
        }
   
    }
    @Override
    public int ajouterSortiesportif(Sortiesportif ss) {
        int x = 0;
        try {
           String sql ="INSERT INTO `sortiesportif`( `nom`, `date_depart`,`date_retour`, `cinT`,`cinCO`, `type_sport`,`nom_S`) VALUES ('"+ss.getNom_S()+"','"+ss.getDate_depart()+"','"+ss.getDate_retour()+"','"+ss.getCinT()+"','"+ss.getCinCO()+"','"+ss.getType_sport()+"','"+ss.getNom_S()+"');";
        
            x = ste.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(SortiesportifServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  x;}

    @Override
    public int modifierSortiesportif(Sortiesportif ss) {
       String sq13="UPDATE sortiesportif SET `id_SS`=?,`nom`=?,`date_depart`=?,`date_retour`=?,`cinT`=?,`cinCO`=?,`type_sport`=?,`nom_S`=? Where nom_S=?";
           
        try {
            PreparedStatement pst = connx.prepareStatement(sq13);
            pst.setString(1, String.valueOf(ss.getId_SS()));
            
             pst.setString(2, ss.getNom());
             
               pst.setString(3, String.valueOf(ss.getDate_depart()));
                pst.setString(4, String.valueOf(ss.getDate_retour()));
                
            pst.setString(5, String.valueOf(ss.getCinT()));
            pst.setString(6, String.valueOf(ss.getCinCO()));
            pst.setString(7, String.valueOf(ss.getType_sport()));
             pst.setString(8, String.valueOf(ss.getNom_S()));
          pst.setString(9, String.valueOf(ss.getNom_S()));
           
           
            pst.executeUpdate();
           
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(SortiebaladeServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0; }

    @Override
    public int supprimerSortiesportif(Sortiesportif ss) {
     int x = 0;
      try {
            String sql2 = "Delete from sortiesportif where nom_S= ? ";
            PreparedStatement pst = connx.prepareStatement(sql2);
            pst.setString(1,ss.getNom_S());
            x= pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SortiesportifServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return x;}

    /*@Override
    public ArrayList<Sortiesportif> afficherSortiesportif() {
    ArrayList<Sortiesportif> Sortiessportif = new ArrayList<>();
        try {
            String sql1="select * from sortiesportif";
            ResultSet res = ste.executeQuery(sql1);
            
            Sortiesportif ss;
        while (res.next()) {
            ss = new Sortiesportif ( 
                   res.getInt("id_SS"),
                    res.getInt("id_destinationS"), 
                    res.getString("type_sport"),
                    res.getInt("cinCO"),
                     res.getDate("date_depart"),
                    res.getDate("date_retour"),
                   
                    
            res.getInt("cinT"),
            res.getString("nom_S"));
    Sortiessportif.add(ss);
    //
    
    
}
        } catch (SQLException ex) {
            Logger.getLogger(SortiebaladeServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("jawha behi");
        for(Sortiesportif ss: Sortiessportif)
       {
       	 System.out.println (ss);
       }
return Sortiessportif; }*/

    @Override
    public ObservableList<Sortiesportif> sbaffiche() {
        ObservableList<Sortiesportif> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = connx.prepareStatement("select * from sortiesportif");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){   
                System.out.println("fghj");
                list.add(new Sortiesportif(
                       rs.getInt(1),
                    rs.getString(2), 
                    rs.getString(5),
                    rs.getInt(6),
                     rs.getDate(3),
                    rs.getDate(4),
            rs.getInt(7),
                         rs.getString(8)
                ) );            
            }
        } catch (Exception e) {
        
      }    
        return list;}
}
