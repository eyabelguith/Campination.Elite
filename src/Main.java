  
import campination.gestionsortie.entities.Sortiebalade;
import campination.gestionsortie.entities.Sortiesportif;
import campination.gestionsortie.entities.VIP;
import campination.gestionsortie.services.SortiebaladeServices;
import campination.gestionsortie.services.SortiesportifServices;
import campination.gestionsortie.services.VipServices;
import campination.gestionsortie.utils.MyConnexion;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author eya
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MyConnexion.getInstanceConnex();
       SortiebaladeServices service = new SortiebaladeServices();
       VipServices serv = new VipServices();
       Sortiebalade s = new Sortiebalade();
       VIP v = new VIP();
       service.ajouterSortiebalade(s);
       //service.supprimerSortiebalade(s);
       //service.modifiersortie(p);
       //service.afficherSortiebalade();
//serv.ajouterSVip(v);
  //serv.modifierVip(v);
   // serv.supprimerVip(v);
   // service.public ObservableList <Sortiesportif > sbaffiche();
    }
    
}
