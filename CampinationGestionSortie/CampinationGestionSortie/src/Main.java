
import campination.gestionsortie.entities.Sortiebalade;
import campination.gestionsortie.services.SortiebaladeServices;
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
       Sortiebalade s = new Sortiebalade();
       service.ajouterSortiebalade(s);
       //service.supprimersortie(p);
       //service.modifiersortie(p);
       //service.afficherSortiebalade();
    }
    
}
