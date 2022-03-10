/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Campination.App.Services;

import Campination.App.Entity.Coach;
import java.util.ArrayList;
import javafx.collections.ObservableList;

/**
 *
 * @author infotel
 */
public interface CoachInterface {

    public int AjouterCoach(Coach co);

    public int ModifierCoach(Coach co);

    public int SupprimerCoach(Coach co);

    public ArrayList<Coach> AfficherCoach();

    public ObservableList<Coach> AfficherListeCoach();

    public ObservableList<Coach> RechercherCoach(String x, String y);

}
