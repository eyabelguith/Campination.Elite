/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionmagasin.entity;

import java.time.LocalDateTime;

/**
 *
 * 
 */
public class Reservation {
    private int idReservation;
    private int idUser_acheteur;
    private int idProduit;
    private LocalDateTime dateDeReservation;

    public Reservation() {
    }

    public Reservation(int idUser_acheteur, int idProduit, LocalDateTime dateDeReservation) {
        this.idUser_acheteur = idUser_acheteur;
        this.idProduit = idProduit;
        this.dateDeReservation = dateDeReservation;
    }

    public Reservation(int idReservation, int idUser_acheteur, int idProduit, LocalDateTime dateDeReservation) {
        this.idReservation = idReservation;
        this.idUser_acheteur = idUser_acheteur;
        this.idProduit = idProduit;
        this.dateDeReservation = dateDeReservation;
    }

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    

    public int getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    public int getIdUser_acheteur() {
        return idUser_acheteur;
    }

    public void setIdUser_acheteur(int idUser_acheteur) {
        this.idUser_acheteur = idUser_acheteur;
    }

    public LocalDateTime getDateDeReservation() {
        return dateDeReservation;
    }

    public void setDateDeReservation(LocalDateTime dateDeReservation) {
        this.dateDeReservation = dateDeReservation;
    }

    @Override
    public String toString() {
        return "Reservation{" + "idReservation=" + idReservation + ", idUser_acheteur=" + idUser_acheteur + ", idProduit=" + idProduit + ", dateDeReservation=" + dateDeReservation + '}';
    }

    
    
    
    
}
