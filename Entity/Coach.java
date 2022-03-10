/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Campination.App.Entity;

import java.sql.Date;
import java.util.Objects;
import javafx.scene.image.ImageView;

/**
 *
 * @author infotel
 */
public class Coach {
    private int id_Coach;
     private String nom;
    private String prenom;
    private String email;

    private String login;
    private String pwd;
    private String gouvernorat;
    private String sexe;
    private int cinCO;
    private int num_Tel;
    private String type_sport;
    private String role;

    public Coach() {
    }

    public Coach(String nom, String prenom, String email, String login, String pwd, String gouvernorat, String sexe, int cinCO, int num_Tel, String type_sport, String role) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
 
        this.login = login;
        this.pwd = pwd;
        this.gouvernorat = gouvernorat;
        this.sexe = sexe;
        this.cinCO = cinCO;
        this.num_Tel = num_Tel;
        this.type_sport = type_sport;
        this.role = role;
    }

 

    public int getId_Coach() {
        return id_Coach;
    }

    public void setId_Coach(int id_Coach) {
        this.id_Coach = id_Coach;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

 

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getGouvernorat() {
        return gouvernorat;
    }

    public void setGouvernorat(String gouvernorat) {
        this.gouvernorat = gouvernorat;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public int getCinCO() {
        return cinCO;
    }

    public void setCinCO(int cinCO) {
        this.cinCO = cinCO;
    }

    public int getNum_Tel() {
        return num_Tel;
    }

    public void setNum_Tel(int num_Tel) {
        this.num_Tel = num_Tel;
    }

    public String getType_sport() {
        return type_sport;
    }

    public void setType_sport(String type_sport) {
        this.type_sport = type_sport;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
        final Coach other = (Coach) obj;
        if (this.id_Coach != other.id_Coach) {
            return false;
        }
        if (this.cinCO != other.cinCO) {
            return false;
        }
        if (this.num_Tel != other.num_Tel) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.prenom, other.prenom)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        if (!Objects.equals(this.pwd, other.pwd)) {
            return false;
        }
        if (!Objects.equals(this.gouvernorat, other.gouvernorat)) {
            return false;
        }
        if (!Objects.equals(this.sexe, other.sexe)) {
            return false;
        }
        if (!Objects.equals(this.type_sport, other.type_sport)) {
            return false;
        }
        if (!Objects.equals(this.role, other.role)) {
            return false;
        }
     
        return true;
    }

    @Override
    public String toString() {
        return "Coach{" + "nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", login=" + login + ", pwd=" + pwd + ", gouvernorat=" + gouvernorat + ", sexe=" + sexe + ", cin=" + cinCO + ", num_Tel=" + num_Tel + ", type_sport=" + type_sport + ", role=" + role + '}';
    }



  

    
}
