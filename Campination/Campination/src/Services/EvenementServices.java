/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import entite.Evenement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import entite.Evenement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.MyConnexion;
/**
 *
 * @author IHEB
 */
public class EvenementServices implements iEvenementInterface {
    Connection connx ;
     Statement ste;
    public EvenementServices() {
        connx = MyConnexion.getInstanceConnex().getConnection();
        try {
            ste = connx.createStatement();
        } catch (SQLException ex) {
                    System.out.println(ex);
        }
   
    }
  @Override   
    public int ajouterEvenement(Evenement e) {
        int x = 0;
        try {
           String sql ="INSERT INTO `evenement`( `titre`, `destination_e`, `type_e`, `description`, `personne_interessee`) VALUES ('"+e.getTitre()+"', '"+e.getDestination_e()+"', '"+e.getType_e()+"', '"+e.getDescription()+"', '"+e.getListCampers()+"');";
          
            x = ste.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(EvenementServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  x;
    }
         @Override
    public int supprimerEvenement(Evenement e) {
        String sql ="Delete from `evenement` where titre= ? ";
         try {
           
            PreparedStatement pst = connx.prepareStatement(sql);
            pst.setString(1,e.getTitre());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EvenementServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }


    @Override
    public int modifierEvenement(Evenement e) {
       
       
        String sq13="UPDATE evenement SET `id_e`=?,`titre`=?,`destination_e`=?,`type_e`=?,`description`=?,"
                + "`personne_interessee`=? Where id_e=?";
            
        try {
            PreparedStatement pst = connx.prepareStatement(sq13);
            pst.setString(1, String.valueOf(e.getId_e()));
            pst.setString(2,e.getTitre());
            pst.setString(3, e.getDestination_e());
            pst.setString(4, e.getTitre());
            pst.setString(5, e.getDescription());
            pst.setString(6, e.getListCampers());
            pst.setString(7, String.valueOf(e.getId_e()));
            
            
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(EvenementServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public ArrayList<Evenement> afficherEvenement() {
        ArrayList<Evenement> Evenement = new ArrayList<>();
        try {
            String sql1="SELECT * FROM `evenement`";
            ResultSet res = ste.executeQuery(sql1);
            
            Evenement e;
        while (res.next()) {
            
            e = new Evenement(  res.getInt("id_e"),res.getString("titre"),res.getString("destination_e")
                    ,res.getString("type_e"),res.getString("description"),res.getString("personne_interessee"));
    Evenement.add(e);
    //
    
    
}
        } catch (SQLException ex) {
            Logger.getLogger(EvenementServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("tekhdem");
        for(Evenement e: Evenement)
       {
       	 System.out.println (e);
       }
return Evenement;
    }
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    @Override
    public ObservableList<Evenement> getDataEvenement() {
      
        ObservableList<Evenement> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = connx.prepareStatement("select * from evenement");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){   
                list.add(new Evenement(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6))  );            
            }
        } catch (Exception e) {
        }
        return list;
    }
    @Override
    public ArrayList<Evenement> rechercherEvenement(String V,String C) {
     ArrayList<Evenement> Evenement = new ArrayList<>();
     try {
         String sql1="select * from evenement where " + C + " =\""+V+"\"" ;
            
         //   String sql1="select * from evenement where titre = \""+V+"\"" ;
            System.out.println(sql1);
            
            ResultSet res = ste.executeQuery(sql1);
            Evenement e;
            
        while (res.next()) {
           e = new Evenement(  res.getInt(1),res.getString(2),res.getString(3)
                    ,res.getString(4),res.getString(5),res.getString(6));
        // F = new Destination(res.getString("nom"),res.getString("gouvernorat"),res.getString("type"),res.getString("description"));
 
           Evenement.add(e);
            
        
        }
        } catch (SQLException ex) {
            Logger.getLogger(EvenementServices.class.getName()).log(Level.SEVERE, null, ex);
        }
     for(Evenement e: Evenement)
       {

       	 System.out.println (e);
         
      }
     
     return Evenement;
    }
}
