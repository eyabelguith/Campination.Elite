/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.sql.Blob;

/**
 *
 * @author IHEB
 */
public class Evenement {
    private int id_e;
    private String titre;
    private String destination_e;
    private String type_e;
    private String description;
    private String ListCampers;
  
   

    public int getId_e() {
        return id_e;
    }

    public void setId_e(int id_e) {
        this.id_e = id_e;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDestination_e() {
        return destination_e;
    }

    public void setDestination_e(String destination_e) {
        this.destination_e = destination_e;
    }

    public String getType_e() {
        return type_e;
    }

    public void setType_e(String type_e) {
        this.type_e = type_e;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getListCampers() {
        return ListCampers;
    }

  
    public void setListCampers(String ListCampers) {
        this.ListCampers = ListCampers;
    }

    

    public Evenement(int id_e, String titre, String destination_e, String type_e, String description, String ListCampers) {
        this.id_e = id_e;
        this.titre = titre;
        this.destination_e = destination_e;
        this.type_e = type_e;
        this.description = description;
        this.ListCampers = ListCampers;
       
        
    }

   

    public Evenement() {
    }

    @Override
    public String toString() {
        return "Evenement{" + "id_e=" + id_e + ", titre=" + titre + ", destination_e=" + destination_e + ", type_e=" + type_e + ", description=" + description + ", ListCampers=" + ListCampers +  '}';
    }
    
    
    

 
    
}
