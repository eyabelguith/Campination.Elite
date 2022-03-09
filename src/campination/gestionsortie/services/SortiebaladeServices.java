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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
           //String sql ="INSERT INTO `sortiebalade`( `id_destinationB`, `date_depart`,`date_retour`, `id_transporteur`) VALUES ('6','2022/03/28','2022/03/30','29');";
       String sql ="INSERT INTO `sortiebalade`(`id_destinationB`, `date_depart`, `date_retour`, `cinT`,`nom_S` ) VALUES ('"+sb.getId_destinationB()+"','"+sb.getDate_depart()+"','"+sb.getDate_retour()+"','"+sb.getCinT()+"','"+sb.getNom_S()+"');";
        System.out.println("ok");
         //java.sql.Date sqlDate=new java.sql.Date(sb.getDate_depart().getTime());
         // java.sql.Date sqlDate2=new java.sql.Date(sb.getDate_retour().getTime());
            x = ste.executeUpdate(sql);
        } catch (SQLException ex) {
           ex.printStackTrace();
            Logger.getLogger(SortiebaladeServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  x;}

    
    
    
    
    
    
    
    
    @Override
    public int modifierSortiebalade(Sortiebalade sb) {
     String sq13="UPDATE sortiebalade SET `id_SB`=?,`id_destinationB`=?,`date_depart`=?,`date_retour`=?,`cinT`=?,`nom_S`=? Where nom_S=?";
           
        try {
            PreparedStatement pst = connx.prepareStatement(sq13);
            pst.setString(1, String.valueOf(sb.getId_SB()));
            
             pst.setString(2, String.valueOf(sb.getId_destinationB()));
             
               pst.setString(3, String.valueOf(sb.getDate_depart()));
                pst.setString(4, String.valueOf(sb.getDate_retour()));
            pst.setString(5, String.valueOf(sb.getCinT()));
             pst.setString(6, String.valueOf(sb.getNom_S()));
          pst.setString(7, String.valueOf(sb.getNom_S()));
           
           
            pst.executeUpdate();
           
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(SortiebaladeServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
      }

    @Override
    public int supprimerSortiebalade(Sortiebalade sb) {
        int x = 0;
      try {
            String sql2 = "Delete from sortiebalade where nom_S= ? ";
            PreparedStatement pst = connx.prepareStatement(sql2);
            pst.setString(1,sb.getNom_S());
            x= pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SortiebaladeServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return x; }

    /*@Override
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
return sortiesbalade; }*/

    @Override
    public ObservableList<Sortiebalade> sbaffiche() {
      ObservableList<Sortiebalade> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = connx.prepareStatement("select * from sortiebalade");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){   
                list.add(new Sortiebalade(rs.getInt(1),rs.getInt(2),rs.getDate(3),rs.getDate(4),rs.getInt(5),rs.getString(6)
                ) );            
            }
        } catch (Exception e) {
        } for(Sortiebalade D: list)
       {

       	 System.out.println (D);
        
         
      }    
        return list;}

    
    
    
    
    
    
    @Override
    public ArrayList<Sortiebalade> rechercherSB(String C,String V) {
       ArrayList<Sortiebalade> Sortiebalade = new ArrayList<>();
     try {
         String sql1="select * from sortiebalade where  " + C + " =\""  + V+ "\""  ;
            
         
            System.out.println(sql1);
            
            ResultSet rs = ste.executeQuery(sql1);
            Sortiebalade D;
            
        while (rs.next()) {
           D = new Sortiebalade( rs.getInt(1),rs.getInt(2),rs.getDate(3),rs.getDate(4),rs.getInt(5),rs.getString(6));
       
           Sortiebalade.add(D);
            
        
        }
        } catch (SQLException ex) {
            Logger.getLogger(SortiebaladeServices.class.getName()).log(Level.SEVERE, null, ex);
        }
     
     
     return Sortiebalade;
    }}



    
    
    
    
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

   
