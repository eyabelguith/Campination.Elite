/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campination.gestionuser.Services;

import campination.gestionuser.Entity.Camper;
import campination.gestionuser.util.MyConnexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author infotel
 */
public class CamperServices implements CamperInterface{
Connection connx ;
     Statement ste;

    public CamperServices() {
          connx = MyConnexion.getInstanceConnex().getConnection();
        try {
            ste = connx.createStatement();
        } catch (SQLException ex) {
                    System.out.println(ex);
        }
    }

    @Override
    public int AjouterCamper(Camper c) {
       int x = 0;
        try {
           String sql ="INSERT INTO `camper` (`nom`,`prenom`,`num_Tel`,`email`,`date_naissance`,`login`,`pwd`,`gouvernorat`,`sexe`,`cin`,`skills`) VALUES ('Talbi','Eya','54616802','eya.ta@','1999/01/26','eyaTalbi','yoyo','Tunis','F','11664267','dev');";
          
            x = ste.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(CamperServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  x;
            }

    @Override
    public int ModifierCamper(Camper c) { int x = 0;
        try {
            String sql3 ="UPDATE `camper` SET `Skills` = 'nothing to do' WHERE `camper`.`id_Camper` = 4";
            x=ste.executeUpdate(sql3);
        } catch (SQLException ex){
            Logger.getLogger(CamperServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return x;
    }

    @Override
    public int SuprimerCamper(Camper c) {
         try {
            String sql2 = "Delete from Camper where id_Camper= ? ";
            PreparedStatement pst = connx.prepareStatement(sql2);
            pst.setInt(1,3);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CamperServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    @Override
    public ArrayList<Camper> AfficherCamper() {
ArrayList<Camper> Campers = new ArrayList<>();
        try {
            String sql4="select * from camper";
            ResultSet res = ste.executeQuery(sql4);
            
            Camper ca;
        while (res.next()) {
            ca = new Camper(
                    res.getInt("id_Camper"),
                    res.getString("nom"),
                    res.getString("prenom"),
                    res.getString("email"),
                    res.getDate("date_naissance"),
                    res.getString("login"),
                    res.getString("pwd"),
                    res.getString("gouvernorat"),
                    res.getString("sexe"),
                    res.getInt("cin"),
                    res.getInt("num_Tel"),
                    res.getString("skills"));
                  
    Campers.add(ca);

        }
         } catch (SQLException ex) {
            Logger.getLogger(CamperServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(Camper p: Campers)
       {
       	 System.out.println (p);
       }
return Campers;
    }
    
    

}
