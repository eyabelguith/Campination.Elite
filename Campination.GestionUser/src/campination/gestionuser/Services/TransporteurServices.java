/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campination.gestionuser.Services;

import campination.gestionuser.Entity.Camper;
import campination.gestionuser.Entity.Transporteur;
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
            String sql ="INSERT INTO `transporteur` ( `num_tel`, `nom`, `gouvernorat`, `moyenT`, `capacite`, `matricule`) VALUES ( '22306124', 'Ahmed', 'Tunis', 'Bus', '50', '213JFT1123');";
           
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
                    res.getInt("num_tel"),
                    res.getString("gouvernorat"),
                    res.getString("moyenT"),
                    res.getString("matricule"),
                    res.getInt("capacite"));
    
                  
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
    }
    

