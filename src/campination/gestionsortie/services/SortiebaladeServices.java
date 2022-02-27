/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campination.gestionsortie.services;

import campination.gestionsortie.entities.Sortiebalade;
import campination.gestionsortie.utils.MyConnexion;
import static com.mysql.cj.protocol.a.MysqlTextValueDecoder.getDate;
import static com.sun.corba.se.impl.orbutil.CorbaResourceUtil.getText;
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
 * @author Eya
 */
public class SortiebaladeServices implements IsortiebaladeServices {
 Connection connx ;
     Statement ste;
     
     
    public SortiebaladeServices() {
        connx = MyConnexion.getInstanceConnex().getConnection();
        try {
            ste = connx.createStatement();
        } catch (SQLException ex) {
                    System.out.println(ex);
        }
   
    }
    @Override
    public int ajouterSortiebalade(Sortiebalade sb) {
       int x = 0;
        try { 
           String sql ="INSERT INTO `sortiebalade`( `id_destinationB`, `date_depart`,`date_retour`, `id_transporteur`) VALUES ('6','2022/03/28','2022/03/30','29');";
       
        System.out.println("ok");
            x = ste.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(SortiebaladeServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  x;}

    @Override
    public int modifierSortiebalade(Sortiebalade sb) {
      
     int x = 0;
        try {
            String sql3 ="UPDATE `sortiebalade` SET `id_destinationB`='0' WHERE 1";
            x=ste.executeUpdate(sql3);
        } catch (SQLException ex){
            Logger.getLogger(SortiebaladeServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return x;
      }

    @Override
    public int supprimerSortiebalade(Sortiebalade sb) {
        int x = 0;
      try {
            String sql2 = "Delete from sortiebalade where id_SB= ? ";
            PreparedStatement pst = connx.prepareStatement(sql2);
            pst.setInt(1,5);
            x= pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SortiebaladeServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return x; }

    @Override
    public ArrayList<Sortiebalade> afficherSortiebalade() {
   ArrayList<Sortiebalade> sortiesbalade = new ArrayList<>();
        try {
            String sql1="select * from sortiebalade";
            ResultSet res = ste.executeQuery(sql1);
            
            Sortiebalade sb;
        while (res.next()) {
            sb = new Sortiebalade ( 
                    res.getInt("id_SB"),
                    res.getInt("id_destinationB"),
                    res.getDate("date_depart"),
                    res.getDate("date_retour"),
                    
            res.getInt("id_transporteur"));
    sortiesbalade.add(sb);
    //
    
    
}
        } catch (SQLException ex) {
            Logger.getLogger(SortiebaladeServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("jawha behi");
        for(Sortiebalade sb: sortiesbalade)
       {
       	 System.out.println (sb);
       }
return sortiesbalade; }}
    
    
    
    
    
    /*private void rechercheSortie (){
        String sql4="select * from sortieB where date_debut=?";
        try {
    ste = connx.prepareStatement(sql4);
        ste.setDate(1,getDate ); 
        rs = ste.executeQuery;
        }catch (SQLException ex){
        System.out.println(ex); 
                }
    
    
    
    
    
    
}*/

   
