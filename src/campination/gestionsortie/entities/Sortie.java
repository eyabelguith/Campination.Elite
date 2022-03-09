/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campination.gestionsortie.entities;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author Eya
 */
public class Sortie {
     private Date date_depart;
     private Date  date_retour ;
     private int  cinT;
     private String nom_S;

    public Sortie() {
    }

    public Date getDate_depart() {
        return date_depart;
    }

    public void setDate_depart(Date date_depart) {
        this.date_depart = date_depart;
    }

    public Date getDate_retour() {
        return date_retour;
    }

    public void setDate_retour(Date date_retour) {
        this.date_retour = date_retour;
    }

    public int getCinT() {
        return cinT;
    }

    public void setCinT(int cinT) {
        this.cinT = cinT;
    }

    public String getNom_S() {
        return nom_S;
    }

    public void setNom_S(String nom_S) {
        this.nom_S = nom_S;
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
        final Sortie other = (Sortie) obj;
        if (this.cinT != other.cinT) {
            return false;
        }
        if (!Objects.equals(this.nom_S, other.nom_S)) {
            return false;
        }
        if (!Objects.equals(this.date_depart, other.date_depart)) {
            return false;
        }
        if (!Objects.equals(this.date_retour, other.date_retour)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Sortie{" + "date_depart=" + date_depart + ", date_retour=" + date_retour + ", cinT=" + cinT + ", nom_S=" + nom_S + '}';
    }

   

   

    

    public Sortie(Date date_depart, Date date_retour, int cinT, String nom_S) {
        this.date_depart = date_depart;
        this.date_retour = date_retour;
        this.cinT = cinT;
        this.nom_S= nom_S;
    }
}
