/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campination.gestionuser;

import campination.gestionuser.Entity.Admin;
import campination.gestionuser.Entity.Camper;
import campination.gestionuser.Entity.Coach;
import campination.gestionuser.Entity.Transporteur;
import campination.gestionuser.Services.AdminServices;
import campination.gestionuser.Services.CamperServices;
import campination.gestionuser.Services.CoachServices;
import campination.gestionuser.Services.TransporteurServices;
import campination.gestionuser.util.MyConnexion;

/**
 *
 * @author infotel
 */
public class CampinationGestionUser {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         MyConnexion.getInstanceConnex();
         Admin a=new Admin();
         AdminServices As=new AdminServices();
     //  As.AfficherAdmin();
         //As.AjouterAdmin(a);
         //As.ModifierAdmin(a);
        // As.SupprimerAdmin(a);
       
         CamperServices service = new CamperServices();
       Camper C = new Camper();
       //service.AjouterCamper(C);
       //service.SuprimerCamper(C);
       //service.ModifierCamper(C);
      // service.AfficherCamper();
      
      CoachServices c=new CoachServices();
      Coach co=new Coach();
     //c.AjouterCoach(co);
      //c.AfficherCoach();
     // c.ModifierCoach(co);
     
     Transporteur t=new Transporteur();
     TransporteurServices Ts=new TransporteurServices();
    //Ts.AjouterTranporteur(t);
    // Ts.ModifierTransporteur(t);
   //  Ts.SuprimerTransporteur(t);
   Ts.AfficherTransporteur();
    }
    
}
