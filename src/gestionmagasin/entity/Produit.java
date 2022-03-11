/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionmagasin.entity;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

/**
 *
 *
 */
public class Produit {
    private int idProduit;
    private String nomProduit;
    private float prix;
    private String categorie;
    private String etat;
    private String description;
    private LocalDateTime datePublication;
    private LocalDateTime dateVente;
    private String image;
    private int idUser;

    public Produit() {
    }

    public Produit(String nomProduit, float prix, String categorie, String etat, String description, LocalDateTime datePublication, String image, int idUser) {
        this.nomProduit = nomProduit;
        this.prix = prix;
        this.categorie = categorie;
        this.etat = etat;
        this.description = description;
        this.datePublication = datePublication;
        this.image = image;
        this.idUser = idUser;
    }

    public Produit(String nomProduit, float prix, String categorie, String etat, String description, LocalDateTime datePublication, LocalDateTime dateVente, String image, int idUser) {
        this.nomProduit = nomProduit;
        this.prix = prix;
        this.categorie = categorie;
        this.etat = etat;
        this.description = description;
        this.datePublication = datePublication;
        this.dateVente = dateVente;
        this.image = image;
        this.idUser = idUser;
    }

    public Produit(int idProduit, String nomProduit, float prix, String categorie, String etat, String description, LocalDateTime datePublication, LocalDateTime dateVente, String image, int idUser) {
        this.idProduit = idProduit;
        this.nomProduit = nomProduit;
        this.prix = prix;
        this.categorie = categorie;
        this.etat = etat;
        this.description = description;
        this.datePublication = datePublication;
        this.dateVente = dateVente;
        this.image = image;
        this.idUser = idUser;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(LocalDateTime datePublication) {
        this.datePublication = datePublication;
    }

    public LocalDateTime getDateVente() {
        return dateVente;
    }

    public void setDateVente(LocalDateTime dateVente) {
        this.dateVente = dateVente;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Produit{" + "idProduit=" + idProduit + ", nomProduit=" + nomProduit + ", prix=" + prix + ", categorie=" + categorie + ", etat=" + etat + ", description=" + description + ", datePublication=" + datePublication + ", dateVente=" + dateVente + ", image=" + image + '}';
    }

    
    

  


    
    
    
    
    
}
