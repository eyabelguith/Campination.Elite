/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Campination.App.Entity;

/**
 *
 * @author Eya
 */
public class Sortiesportif extends Sortie {

    private int id_SS;
    private String nom;
    private String type_sport;
    private int cinCO;

    public Sortiesportif() {
    }

    public Sortiesportif(int id_SS,String nom, String type_sport, int id_coach, java.sql.Date date_depart, java.sql.Date date_retour, int cinCO, String nom_S) {
        super(date_depart, date_retour, cinCO, nom_S);
        this.id_SS = id_SS;
        this.nom = nom;
        this.type_sport = type_sport;
        this.cinCO = cinCO;

    }

 

    public int getId_SS() {
        return id_SS;
    }

    public void setId_SS(int id_SS) {
        this.id_SS = id_SS;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

  

    public String getType_sport() {
        return type_sport;
    }

    public void setType_sport(String type_sport) {
        this.type_sport = type_sport;
    }

    public int getCinCO() {
        return cinCO;
    }

    public void setCinCO(int cinCO) {
        this.cinCO = cinCO;
    }

    @Override
    public String toString() {
        return "Sortiesportif{" + "id_SS=" + id_SS + ", id_destinationS=" + nom + ", type_sport=" + type_sport + ", cinCO=" + cinCO + '}';
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
        final Sortiesportif other = (Sortiesportif) obj;
        if (this.id_SS != other.id_SS) {
            return false;
        }
        if (this.nom != other.nom) {
            return false;
        }
        if (this.cinCO != other.cinCO) {
            return false;
        }

        return true;
    }

    @Override
    public void setCinT(int cinT) {
        super.setCinT(cinT); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getCinT() {
        return super.getCinT(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setDate_retour(java.sql.Date date_retour) {
        super.setDate_retour(date_retour); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public java.sql.Date getDate_retour() {
        return super.getDate_retour(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setDate_depart(java.sql.Date date_depart) {
        super.setDate_depart(date_depart); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public java.sql.Date getDate_depart() {
        return super.getDate_depart(); //To change body of generated methods, choose Tools | Templates.
    }

}
