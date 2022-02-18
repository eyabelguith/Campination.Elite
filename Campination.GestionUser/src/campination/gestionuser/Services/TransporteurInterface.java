/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campination.gestionuser.Services;

import campination.gestionuser.Entity.Transporteur;
import java.util.ArrayList;

/**
 *
 * @author infotel
 */
public interface TransporteurInterface {
    public int AjouterTranporteur(Transporteur t);
    public int ModifierTransporteur(Transporteur t);
    public int SuprimerTransporteur(Transporteur t);
    public ArrayList<Transporteur> AfficherTransporteur();
    
}
