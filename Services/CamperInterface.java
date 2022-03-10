/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Campination.App.Services;

import Campination.App.Entity.Camper;
import java.util.ArrayList;
import javafx.collections.ObservableList;

/**
 *
 * @author infotel
 */
public interface CamperInterface {

    public int AjouterCamper(Camper c);

    public int ModifierCamper(Camper c);

    public int SuprimerCamper(Camper c);

    public ArrayList<Camper> AfficherCamper();

    public ArrayList<Camper> RechercherCamper(String x, String y);

    public ObservableList<Camper> ListCampers();

    public int campersNumber(int x);
}
