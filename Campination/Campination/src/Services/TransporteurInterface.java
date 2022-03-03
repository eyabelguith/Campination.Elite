/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import entite.Transporteur;
import java.util.ArrayList;
import javafx.collections.ObservableList;

/**
 *
 * @author infotel
 */
public interface TransporteurInterface {
    public int AjouterTranporteur(Transporteur t);
    public int ModifierTransporteur(Transporteur t);
    public int SuprimerTransporteur(Transporteur t);
    public ArrayList<Transporteur> AfficherTransporteur();
      public ObservableList<Transporteur> ListTransporteur();
      public void TransporteurNumber();
      public ArrayList<Transporteur> RechercherTransporteur(String x,String y);
    
}
