/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campination.gestionuser.Services;

import campination.gestionuser.Entity.Camper;
import campination.gestionuser.Entity.Coach;
import campination.gestionuser.util.MyConnexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/** *
 * @author infotel
 */
public class CoachServices implements CoachInterface {
Connection connx ;
     Statement ste;
        public CoachServices() {
        connx = MyConnexion.getInstanceConnex().getConnection();
        try {
            ste = connx.createStatement();
        } catch (SQLException ex) {
                    System.out.println(ex);
        }
   
    }
    @Override
    public int AjouterCoach(Coach co) {
        int x = 0;
        try {
           String sql ="INSERT INTO `coach` (`id_Coach`, `nom`, `prenom`, `num_Tel`, `email`, `date_naissance`, `login`, `pwd`, `gouvernorat`, `type_sport`, `cin`, `sexe`) VALUES ('5', 'eya', 'talbi', '54616802', 'eya.ta@', '1999/01/26', 'eyata', 'ttt', 'tunis', 'yoga', '11664267', 'f');";
          
            x = ste.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(CoachServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  x;
    }

    @Override
    public int ModifierCoach(Coach co) {
        
                    int x = 0;
        try {
            String sql3 ="UPDATE `coach` SET `email` = 'farouk@gm' WHERE `coach`.`id_Coach` = 1; ";
            x=ste.executeUpdate(sql3);
        } catch (SQLException ex){
            Logger.getLogger(CamperServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return x;
        
    }
    
    
    

    @Override
    public int SupprimerCoach(Coach co) {
               try {
            String sql2 = "Delete from coach where id_Coach= ? ";
            PreparedStatement pst = connx.prepareStatement(sql2);
            pst.setInt(1,1);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CoachServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public ArrayList<Coach> AfficherCoach() {
       ArrayList<Coach> coachs = new ArrayList<>();
        try {
            String sql4="select * from coach";
            ResultSet res = ste.executeQuery(sql4);
            
            Coach ca;
        while (res.next()) {
            ca = new Coach(
                    res.getInt("id_Coach"),
                    res.getString("type_sport"),
                    res.getString("nom"),
                    res.getString("prenom"),
                    res.getString("email"),
                    res.getDate("date_naissance"),
                    res.getString("login"),
                    res.getString("pwd"),
                    res.getString("gouvernorat"),
                    res.getString("sexe"),
                    res.getInt("cin"),
                    res.getInt("num_Tel"));
                  
    coachs.add(ca);

        }
         } catch (SQLException ex) {
            Logger.getLogger(CamperServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(Coach p: coachs)
       {
       	 System.out.println (p);
       }
    return coachs;
    }
    
    
}
