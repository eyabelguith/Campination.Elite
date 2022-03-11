/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionmagasin.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * 
 */
public class MyConnexion {
     String url ="jdbc:mysql://localhost:3306/bd last v";
     String login ="root";
     String pwd ="";
    static Connection myConnex;
    static MyConnexion myInstanceConnex;
    private MyConnexion() {
    try {
            myConnex = DriverManager.getConnection(url, login, pwd);
            System.out.println("connexion ok");
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
  public static MyConnexion getInstanceConnex(){
      if(myInstanceConnex == null)
          myInstanceConnex = new MyConnexion();
      
        return myInstanceConnex ;  
  }
    
  
  public  Connection getConnection(){
      return myConnex;
  }
}
