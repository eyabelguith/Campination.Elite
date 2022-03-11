/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionmagasin.services;

import gestionmagasin.entity.Produit;
import gestionmagasin.entity.Reservation;
import gestionmagasin.utils.MyConnexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * 
 */
public class ReservationServices {
    Connection connx ;
     Statement ste;
        public ReservationServices() {
        connx = MyConnexion.getInstanceConnex().getConnection();
        try {
            ste = connx.createStatement();
        } catch (SQLException ex) {
                    System.out.println(ex);
        }
   
    }
   
    public int AjouterReservation(Reservation r) {
         int x = 0;
        try {
            String sql="INSERT INTO `reservation`( `idUser_acheteur`, `dateDeReservation`, `idProduit`) "
                    + "VALUES ('"+r.getIdUser_acheteur()+"','"+r.getDateDeReservation()+"','"+r.getIdProduit()+"')";
          
            x = ste.executeUpdate(sql);
            
        } catch (SQLException ex) {
            Logger.getLogger(ProduitServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  x;
    }
    public List<Reservation> AfficherReservation(int id){
        
        List<Reservation> lr=new ArrayList<>();
        try {
            
            String query="select * from reservation where idUser_acheteur="+id;
            ResultSet rs=ste.executeQuery(query);
            while(rs.next()){
                Reservation r =new Reservation();
                r.setIdReservation(rs.getInt("idReservation"));
                r.setDateDeReservation(rs.getTimestamp("dateDeReservation").toLocalDateTime());
                r.setIdUser_acheteur(rs.getInt("idUser_acheteur"));
                r.setIdProduit(rs.getInt("idProduit"));
                lr.add(r);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProduitServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lr;
    
    }
}
