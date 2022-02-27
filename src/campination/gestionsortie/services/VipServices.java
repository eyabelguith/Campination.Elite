/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campination.gestionsortie.services;

import campination.gestionsortie.entities.VIP;
import campination.gestionsortie.utils.MyConnexion;
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
public class VipServices implements Ivip{

  
   Connection connx ;
     Statement ste;   
 public VipServices() {
        connx = MyConnexion.getInstanceConnex().getConnection();
        try {
            ste = connx.createStatement();
        } catch (SQLException ex) {
                    System.out.println(ex);
        }
   
    }

    @Override
    public int ajouterSVip(VIP v) {
      int x = 0;
        try {
           String sql ="INSERT INTO `vip`(  `cin,`nb_SS`,`nb_SB`) select  `cin` , `nb_SS` , `nb_SB` from `camper`  WHERE id_camper=?";
        
            x = ste.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(VipServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  x;}

    @Override
    public int modifierVip(VIP v) { int x = 0;
        try {
            String sql3 ="UPDATE `vip` SET `id_destinationB`='0' WHERE 1";
            x=ste.executeUpdate(sql3);
        } catch (SQLException ex){
            Logger.getLogger(VipServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return x;   }

    @Override
    public int supprimerVip(VIP v) { int x = 0;
      try {
            String sql2 = "Delete from vip where id_SB= ? ";
            PreparedStatement pst = connx.prepareStatement(sql2);
            pst.setInt(1,5);
            x= pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(VipServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return x; }

    @Override
    public ArrayList<VIP> afficherVip() {
         ArrayList<VIP> VIPs = new ArrayList<>();
        try {
            String sql1="select * from vip";
            ResultSet res = ste.executeQuery(sql1);
            
            VIP vs;
        while (res.next()) {
            vs = new VIP ( 
                   res.getInt("id_vip"),
                    res.getInt("cin"), 
                    res.getInt("nb_SS"),
                    res.getInt("nb_SB"),
                     res.getInt("nb_pt"));
    VIPs.add(vs);
    //
    
    
}
        } catch (SQLException ex) {
            Logger.getLogger(VipServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("jawha behi");
        for(VIP vs: VIPs)
       {
       	 System.out.println (vs);
       }
return VIPs; }

     

   /* @Override
    public int calculepoints() {
int x = 0;
        try {
            String sql5 ="insert into `vip` (nb_pt) values (select nb_SS + nb_SB from camper WHERE id_Camper=?)";
            x=ste.executeUpdate(sql5);
        } catch (SQLException ex){
            
            Logger.getLogger(VipServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return x;   
        
      
             
                  }
    private static final Logger LOG = Logger.getLogger(VipServices.class.getName());
*/
    
}
    
    
    
    
    

