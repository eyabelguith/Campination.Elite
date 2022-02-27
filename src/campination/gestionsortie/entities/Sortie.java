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
     private int  id_transporteur;

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

    public int getId_transporteur() {
        return id_transporteur;
    }

    public void setId_transporteur(int id_transporteur) {
        this.id_transporteur = id_transporteur;
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
        if (this.id_transporteur != other.id_transporteur) {
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
        return "sortie{" + "date_depart=" + date_depart + ", date_retour=" + date_retour + ", id_transporteur=" + id_transporteur + '}';
    }

    public Sortie(Date date_depart, Date date_retour, int id_transporteur) {
        this.date_depart = date_depart;
        this.date_retour = date_retour;
        this.id_transporteur = id_transporteur;
    }
}
