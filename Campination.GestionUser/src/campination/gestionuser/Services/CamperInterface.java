/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campination.gestionuser.Services;

import campination.gestionuser.Entity.Camper;
import java.util.ArrayList;

/**
 *
 * @author infotel
 */
public interface CamperInterface {
public int AjouterCamper(Camper c);
public int ModifierCamper(Camper c);
public int SuprimerCamper(Camper c);
public ArrayList<Camper> AfficherCamper();

    
}
