/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campination.gestionsortie.entities;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Eya
 */
public class Sortiesportif extends Sortie{
    private int id_SS;
    private int id_destinationS;
    private String type_sport;
    private int id_coach ;

    public Sortiesportif() {
    }

   
    public Sortiesportif(int id_SS, int id_destinationS, String type_sport, int id_coach, java.sql.Date date_depart, java.sql.Date date_retour, int id_transporteur) {
        super(date_depart, date_retour, id_transporteur);
        this.id_SS = id_SS;
        this.id_destinationS = id_destinationS;
        this.type_sport = type_sport;
        this.id_coach = id_coach;
    }

    public int getId_SS() {
        return id_SS;
    }

    public void setId_SS(int id_SS) {
        this.id_SS = id_SS;
    }

    public int getId_destinationS() {
        return id_destinationS;
    }

    public void setId_destinationS(int id_destinationS) {
        this.id_destinationS = id_destinationS;
    }

    public String getType_sport() {
        return type_sport;
    }

    public void setType_sport(String type_sport) {
        this.type_sport = type_sport;
    }

    public int getId_coach() {
        return id_coach;
    }

    public void setId_coach(int id_coach) {
        this.id_coach = id_coach;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setId_transporteur(int id_transporteur) {
        super.setId_transporteur(id_transporteur); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getId_transporteur() {
        return super.getId_transporteur(); //To change body of generated methods, choose Tools | Templates.
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
    
    
    
    
    
    
