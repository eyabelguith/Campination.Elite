/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campination.gestionuser.Services;

import campination.gestionuser.Entity.Admin;
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
public class AdminServices implements AdminInterface {
     Connection connx ;
     Statement ste;

    public AdminServices() {
          connx = MyConnexion.getInstanceConnex().getConnection();
        try {
            ste = connx.createStatement();
        } catch (SQLException ex) {
                    System.out.println(ex);
        }
    }
     
    @Override
    public int AjouterAdmin(Admin a) {
         int x = 0;
        try {
            String sql ="INSERT INTO `admin` (`nom`, `login`, `pwd`) VALUES ('Iheb', 'iheb.othmen@esprit.tn', 'ihebb');";
           
            x = ste.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(AdminServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  x;
    }

    @Override
    public int ModifierAdmin(Admin a) {
      int x = 0;
        try {
            String sql3 ="UPDATE `admin` SET `login` = 'eya.bel@' WHERE `admin`.`Id_Admin` = 3;";
            x=ste.executeUpdate(sql3);
        } catch (SQLException ex){
            Logger.getLogger(AdminServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return x;
    }

    @Override
    public int SupprimerAdmin(Admin a) {
        try {
            String sql2 = "Delete from admin where id_Admin= ? ";
            PreparedStatement pst = connx.prepareStatement(sql2);
            pst.setInt(1,3);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AdminServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;

    }

    @Override
    public ArrayList<Admin> AfficherAdmin() {
         ArrayList<Admin> Admins = new ArrayList<>();
        try {
            String sql1="select * from admin";
            ResultSet res = ste.executeQuery(sql1);
            
            Admin a;
        while (res.next()) {
            a = new Admin( res.getInt("id_Admin"),res.getString("nom"),res.getString("login"),res.getString("pwd"));
    Admins.add(a);
    
}
        } catch (SQLException ex) {
            Logger.getLogger(AdminServices.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        for(Admin ad: Admins)
       {
       	 System.out.println (ad);
       }
return Admins;
    }
    
    }
    

