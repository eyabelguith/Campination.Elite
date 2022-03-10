/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Campination.App.Services;

import Campination.App.Entity.Admin;

import java.util.ArrayList;

/**
 *
 * @author infotel
 */
public interface AdminInterface {

    public int AjouterAdmin(Admin a);

    public int ModifierAdmin(Admin a);

    public int SupprimerAdmin(Admin a);

    public ArrayList<Admin> AfficherAdmin();

    public int login(Admin a);

    public String getNomAdmin(String nom);

}
