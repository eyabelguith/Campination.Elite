/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Campination.App.Entity;

import java.sql.Date;

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
    private String participants;
    private Date datedebut;
    private Date datefin;

    public Evenement() {
    }

    public Evenement(String titre, String destination_e, String type_e, String description, String participants, Date datedebut, Date datefin) {

        this.titre = titre;
        this.destination_e = destination_e;
        this.type_e = type_e;
        this.description = description;
        this.participants = participants;
        this.datedebut = datedebut;
        this.datefin = datefin;

    }

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

    public String getParticipants() {
        return participants;
    }

    public void setParticipants(String ListCampers) {
        this.participants = ListCampers;
    }

    public Date getDateDebut() {
        return datedebut;
    }

    public void setDateDebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    public Date getDatefin() {
        return datefin;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    @Override
    public String toString() {
        return "Evenement{" + ", titre=" + titre + ", destination_e=" + destination_e + ", type_e=" + type_e + ", description=" + description + ", Participants=" + participants + ", datedebut=" + datedebut + ", datefin=" + datefin + '}';
    }

}
