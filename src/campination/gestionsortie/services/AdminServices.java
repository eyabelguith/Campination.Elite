/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campination.gestionsortie.services;
import campination.gestionsortie.entities.Admin;
import campination.gestionsortie.utils.MyConnexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
/**
 *
 * @author Eya
 */
public class AdminServices {
 Connection connx ;
     Statement ste;
     PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    public AdminServices() {
          connx = MyConnexion.getInstanceConnex().getConnection();
        try {
            ste = connx.createStatement();
        } catch (SQLException ex) {
                    System.out.println(ex);
        }
    }
     
    public int AjouterAdmin(Admin a) {
         int x = 0;
        try {
            String sql ="INSERT INTO `admin` (`nom`, `login`, `pwd`, `role`) VALUES ('Ala', 'ala.chamsi@esprit.tn', 'ala', 'Admin');";
           
            x = ste.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(AdminServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  x;
    }

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

    public int SupprimerAdmin(Admin a) {
        try {
            String sql2 = "Delete from admin where id_Admin= ? ";
            PreparedStatement pst = connx.prepareStatement(sql2);
            pst.setInt(1,2);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AdminServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;

    }

    public ArrayList<Admin> AfficherAdmin() {
         ArrayList<Admin> Admins = new ArrayList<>();
        try {
            String sql1="select * from admin";
            ResultSet res = ste.executeQuery(sql1);
            
            Admin a;
        while (res.next()) {
            a = new Admin( res.getInt("id_Admin"),
                    res.getString("nom"),
                    res.getString("login"),
                    res.getString("pwd"),
                    res.getString("role"));
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

    public int login(Admin a) {
    String sql6 = "SELECT * FROM admin WHERE login = ? and pwd = ?";
        
        try{
            preparedStatement = connx.prepareStatement(sql6);
            preparedStatement.setString(1, a.getLogin());
            preparedStatement.setString(2,a.getPwd());
            resultSet = preparedStatement.executeQuery();
            if(!resultSet.next()){
                infoBox("Please enter correct login and Password", null, "Failed");
            }else{
                infoBox("Login Successfull",null,"Success" );
                
               
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
       return 0 ; 
    }
      public static void infoBox(String infoMessage, String headerText, String title){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText(infoMessage);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.showAndWait();
         

    }

       
    
    
   
}
