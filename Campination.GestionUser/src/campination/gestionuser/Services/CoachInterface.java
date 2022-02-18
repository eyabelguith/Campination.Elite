/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campination.gestionuser.Services;

import campination.gestionuser.Entity.Coach;
import java.util.ArrayList;

/**
 *
 * @author infotel
 */
public interface CoachInterface {
    public int AjouterCoach(Coach co);
    public int ModifierCoach(Coach co);
    public int SupprimerCoach(Coach co);
    public ArrayList<Coach> AfficherCoach();
    
}
