/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campination.gestionsortie.services;
import campination.gestionsortie.entities.Admin;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author Eya
 */
public interface iadmin {
public int AjouterAdmin(Admin a);
    public int ModifierAdmin(Admin a);
    public int SupprimerAdmin(Admin a);
    public ArrayList<Admin> AfficherAdmin();
    public int login(Admin a);    
}
