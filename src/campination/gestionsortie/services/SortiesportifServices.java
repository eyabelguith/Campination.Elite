/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campination.gestionsortie.services;

import campination.gestionsortie.entities.Sortiesportif;
import campination.gestionsortie.utils.MyConnexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
           String sql ="INSERT INTO `sortiesportif`( `id_destinationS`, `date_depart`,`date_retour`, `id_transporteur`,`id_coach`, `type_sport`) VALUES ('"+ss.getId_destinationS()+"','"+ss.getDate_depart()+"','"+ss.getDate_retour()+"','"+ss.getId_transporteur()+"','"+ss.getId_coach()+"','"+ss.getType_sport()+"');";
        
            x = ste.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(SortiesportifServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  x;}

    @Override
    public int modifierSortiesportif(Sortiesportif ss) {
        int x = 0;
        try {
            String sql3 ="UPDATE `sortiesportif` SET `id_destinationB`='0' WHERE 1";
            x=ste.executeUpdate(sql3);
        } catch (SQLException ex){
            Logger.getLogger(SortiesportifServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return x; }

    @Override
    public int supprimerSortiesportif(Sortiesportif ss) {
     int x = 0;
      try {
            String sql2 = "Delete from sortiesportif where id_SS= ? ";
            PreparedStatement pst = connx.prepareStatement(sql2);
            pst.setInt(1,ss.getId_SS());
            x= pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SortiesportifServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return x;}

    @Override
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
                    res.getInt("id_coach"),
                     res.getDate("date_depart"),
                    res.getDate("date_retour"),
                   
                    
            res.getInt("id_transporteur"));
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
return Sortiessportif; }

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
                    rs.getInt(2), 
                    rs.getString(5),
                    rs.getInt(6),
                     rs.getDate(3),
                    rs.getDate(4),
            rs.getInt(7)
                ) );            
            }
        } catch (Exception e) {
        
      }    
        return list;}
}
