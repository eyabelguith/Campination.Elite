/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campination.gestionuser.Entity;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author infotel
 */
public class Transporteur  {
    private int id_t;
    private String nom;
    private int num_tel;
    private String gouvernorat;
    private String moyenT;
    private String matricule;
    private int capacite;

    public Transporteur(String nom, int num_tel,String gouvernorat ,String moyenT, String matricule, int capacite) {
        this.nom = nom;
        this.num_tel = num_tel;
        this.gouvernorat= gouvernorat ;
        this.moyenT = moyenT;
        this.matricule = matricule;
        this.capacite = capacite;
    }

    public Transporteur() {
        
    }

    public int getId_t() {
        return id_t;
    }

    public void setId_t(int id_t) {
        this.id_t = id_t;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNum_tel() {
        return num_tel;
    }

    public void setNum_tel(int num_tel) {
        this.num_tel = num_tel;
    }

    public String getGouvernorat() {
        return gouvernorat ;
    }

    public void setGouvernorat(String gouvernorat ) {
        this.gouvernorat  = gouvernorat ;
    }

    public String getMoyenT() {
        return moyenT;
    }

    public void setMoyenT(String moyenT) {
        this.moyenT = moyenT;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Transporteur other = (Transporteur) obj;
        if (this.id_t != other.id_t) {
            return false;
        }
        if (this.num_tel != other.num_tel) {
            return false;
        }
        if (this.capacite != other.capacite) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.gouvernorat , other.gouvernorat )) {
            return false;
        }
        if (!Objects.equals(this.moyenT, other.moyenT)) {
            return false;
        }
        if (!Objects.equals(this.matricule, other.matricule)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Transporteur{" + "nom=" + nom + ", num_tel=" + num_tel + ", gouvernorat=" + gouvernorat + ", moyenT=" + moyenT + ", matricule=" + matricule + ", capacite=" + capacite + '}';
    }

    

    
   
    
}
