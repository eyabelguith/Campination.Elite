/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;


import entite.Transporteur;
import utils.MyConnexion;
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
 * @author infotel
 */
public class TransporteurServices implements TransporteurInterface {
   Connection connx;
    Statement ste;
    
    public TransporteurServices(){
          connx = MyConnexion.getInstanceConnex().getConnection();
        try {
            ste = connx.createStatement();
        } catch (SQLException ex) {
                    System.out.println(ex);
        }
    }
   
    @Override
    public int AjouterTranporteur(Transporteur t) {
        int x = 0;
        try {
            String sql ="INSERT INTO `transporteur` (  `nom`,  `cin`, `num_tel`, `gouvernorat`,  `moyenT`, `capacite`, `matricule`, `role`) VALUES ( '"+t.getNom()+"', '"+t.getCin()+"',  '"+t.getNum_tel()+"' ,'"+t.getGouvernorat()+"',  '"+t.getMoyenT()+"', '"+t.getCapacite()+"', '"+t.getMatricule()+"',  '"+t.getRole()+"');";
           
            x = ste.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(TransporteurServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  x;
    }

    @Override
    public int ModifierTransporteur(Transporteur t) {
   int x = 0;
        try {
            String sql3 ="UPDATE `transporteur` SET `capacite` = '45' WHERE `transporteur`.`id_t` = 1;";
            x=ste.executeUpdate(sql3);
        } catch (SQLException ex){
            Logger.getLogger(TransporteurServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return x;
    }

    @Override
    public int SuprimerTransporteur(Transporteur t) {
            try {
            String sql2 = "DELETE FROM `transporteur` WHERE `transporteur`.`id_t` = ?;";
            PreparedStatement pst = connx.prepareStatement(sql2);
            pst.setInt(1,1);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TransporteurServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public ArrayList<Transporteur> AfficherTransporteur() {
     ArrayList<Transporteur> transp = new ArrayList<>();
        try {
            String sql4="select * from transporteur";
            ResultSet res = ste.executeQuery(sql4);
            
            Transporteur t;
        while (res.next()) {
            t = new Transporteur(
                  
                    res.getString("nom"),
                     res.getInt("cin"),
                      res.getInt("num_tel"),
                   res.getString("gouvernorat"),
                  
                    res.getString("moyenT"),
                    res.getString("matricule"),
                    res.getInt("capacite"),
                    res.getString("role"));
    
                  
    transp.add(t);

        }
         } catch (SQLException ex) {
            Logger.getLogger(TransporteurServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(Transporteur tp: transp)
       {
       	 System.out.println (tp);
       }
return transp;
    }

    @Override
    public ObservableList<Transporteur> ListTransporteur() {
     ObservableList<Transporteur> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = connx.prepareStatement("select * from transporteur");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){   
                list.add(new Transporteur(
                        rs.getString(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5)
                        ,rs.getString(6),
                        rs.getInt(7),
                        rs.getString(8))   );            
            }
        } catch (Exception e) {
        }
        return list;
    }

    public int TransporteurNumber(int x) {
            String sql="SELECT count(*) FROM `transporteur`";
     
       try {
          ste=connx.prepareStatement(sql);
          ResultSet resultSet = ste.executeQuery(sql);
          if(resultSet.next()){
              x=resultSet.getInt(x);
          }
            
        } catch (SQLException e){
e.printStackTrace();
        }
return x;
    }

    @Override
    public void TransporteurNumber() {
         String sqla="SELECT count(*) FROM `transporteur`";
     try{
          ste =connx.prepareStatement(sqla);
       ResultSet rs=ste.executeQuery(sqla);
       while(rs.next())
       {
           
    int count =rs.getInt(1);
    
     }    
    }catch(SQLException ex){
       ex.printStackTrace();
    }
    }

    @Override
    public ArrayList<Transporteur> RechercherTransporteur(String x, String y) {
       ArrayList<Transporteur> Trans=new ArrayList<>();
       try {
            String sqlR="select * from transporteur where " + x + " =\""+y+"\"" ;
            System.out.println(sqlR);
    
            ResultSet res = ste.executeQuery(sqlR);
            Transporteur t;
            
        while (res.next()) {
            t = new Transporteur( 
                 res.getString("nom"),
                     res.getInt("cin"),
                      res.getInt("num_tel"),
                   res.getString("gouvernorat"),
                  
                    res.getString("moyenT"),
                    res.getString("matricule"),
                    res.getInt("capacite"),
                    res.getString("role"));
     
           Trans.add(t);
            
        
        }
        } catch (SQLException ex) {
            Logger.getLogger(TransporteurServices.class.getName()).log(Level.SEVERE, null, ex);
        }
     for(Transporteur D: Trans)
       {

       	 System.out.println (D);
         
      }
     
     return Trans;
 
    }
}



 
  
