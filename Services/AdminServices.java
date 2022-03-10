/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Campination.App.Services;

import Campination.App.Entity.Admin;

import Campination.App.Util.MyConnexion;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

/**
 *
 * @author infotel
 */
public class AdminServices implements AdminInterface {
     Connection connx ;
     Statement ste;
     PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
       private Parent fxml;

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
            String sql ="INSERT INTO `admin` (`nom`, `login`, `pwd`, `role`) VALUES ('Ala', 'ala.chamsi@esprit.tn', 'ala', 'Admin');";
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
            String sql3 ="UPDATE `admin` SET `login` =? WHERE `admin`.`Id_Admin` = 1;";
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
            pst.setInt(1,2);
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
            a = new Admin( 
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

    @Override
    public int login(Admin a) {
        int x=0;
    String sql6 = "SELECT * FROM admin WHERE login = ? and pwd = ?";
        
          try{
            preparedStatement = connx.prepareStatement(sql6);
            preparedStatement.setString(1, a.getLogin());
            preparedStatement.setString(2, a.getPwd());
            resultSet = preparedStatement.executeQuery();
            if(!resultSet.next()){
                infoBox("Please enter correct login and Password", null, "Failed");
            }else{
                infoBox("Login Successfull",null,"Success" );
                    x=1;
                     Stage home=new Stage ();
        
              
               
            }
        }
        catch(Exception e){
            e.printStackTrace();
        } 
        
       return x ; 
    }
      public static void infoBox(String infoMessage, String headerText, String title){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText(infoMessage);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.showAndWait();
         

    }

    @Override
    public String getNomAdmin(String nom) {
         ArrayList<Admin> Admins = new ArrayList<>();
       try {
            String sql="SELECT nom FROM `admin`";
            ResultSet res = ste.executeQuery(sql);
      
            Admin a;
        while (res.next()) {
          
                    res.getString("nom");
                 
    
}
        } catch (SQLException ex) {
            Logger.getLogger(AdminServices.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        for(Admin ad: Admins)
       {
       	 System.out.println (ad.getNom());
       }
return nom;
    }
            
        }
    

       
    
    


    
    

