/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Campination.App.Entity;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author IHEB
 */
public class Participants {

    private int cin_camper;
    private int reference_e;
    private String nom_camper;
    private Date date_e;
    private String nom_event;

    public Participants() {
    }

    public Participants(int cin_camper, int reference_e, String nom_camper, Date date_e, String nom_event) {
        this.cin_camper = cin_camper;
        this.reference_e = reference_e;
        this.nom_camper = nom_camper;
        this.date_e = date_e;
        this.nom_event = nom_event;
    }

    public int getCin_camper() {
        return cin_camper;
    }

    public void setCin_camper(int cin_camper) {
        this.cin_camper = cin_camper;
    }

    public int getReference_e() {
        return reference_e;
    }

    public void setReference_e(int reference_e) {
        this.reference_e = reference_e;
    }

    public String getNom_camper() {
        return nom_camper;
    }

    public void setNom_camper(String nom_camper) {
        this.nom_camper = nom_camper;
    }

    public Date getDate_e() {
        return date_e;
    }

    public void setDate_e(Date date_e) {
        this.date_e = date_e;
    }

    public String getNom_event() {
        return nom_event;
    }

    public void setNom_event(String nom_event) {
        this.nom_event = nom_event;
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
        final Participants other = (Participants) obj;
        if (this.cin_camper != other.cin_camper) {
            return false;
        }
        if (this.reference_e != other.reference_e) {
            return false;
        }
        if (!Objects.equals(this.nom_camper, other.nom_camper)) {
            return false;
        }
        if (!Objects.equals(this.nom_event, other.nom_event)) {
            return false;
        }
        if (!Objects.equals(this.date_e, other.date_e)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Participants{" + "cin_camper=" + cin_camper + ", reference_e=" + reference_e + ", nom_camper=" + nom_camper + ", date_e=" + date_e + ", nom_event=" + nom_event + '}';
    }

}
