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
 * @author infotel
 */
public class Camper  {
    private int id_Camper;
      private int  nb_SS;
        private int   nb_SB;
     private String nom;
    private String prenom;
    private String email;
    private Date date_naissance;
    private String login;
    private String pwd;
    private String gouvernorat;
    private String sexe;
    private int cin;
    private int num_Tel;
    private String skills;
    private String role;

    public Camper() {
    }

    public Camper(String nom, String prenom, String email, Date date_naissance,
            String login, String pwd, String gouvernorat, String sexe, int cin, int num_Tel, String skills, String role,int  nb_SS,int   nb_SB) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.date_naissance = date_naissance;
        this.login = login;
        this.pwd = pwd;
        this.gouvernorat = gouvernorat;
        this.sexe = sexe;
        this.cin = cin;
        this.num_Tel = num_Tel;
        this.skills = skills;
        this.role = role;
        this.nb_SB=nb_SB;
        this.nb_SS=nb_SS;
    }

    public int getNb_SS() {
        return nb_SS;
    }

    public void setNb_SS(int nb_SS) {
        this.nb_SS = nb_SS;
    }

    public int getNb_SB() {
        return nb_SB;
    }

    public void setNb_SB(int nb_SB) {
        this.nb_SB = nb_SB;
    }

    public int getId_Camper() {
        return id_Camper;
    }

    public void setId_Camper(int id_Camper) {
        this.id_Camper = id_Camper;
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

    public Date getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(Date date_naissance) {
        this.date_naissance = date_naissance;
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

    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public int getNum_Tel() {
        return num_Tel;
    }

    public void setNum_Tel(int num_Tel) {
        this.num_Tel = num_Tel;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
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
        final Camper other = (Camper) obj;
        if (this.id_Camper != other.id_Camper) {
            return false;
        }
        if (this.nb_SS != other.nb_SS) {
            return false;
        }
        if (this.nb_SB != other.nb_SB) {
            return false;
        }
        if (this.cin != other.cin) {
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
        if (!Objects.equals(this.skills, other.skills)) {
            return false;
        }
        if (!Objects.equals(this.role, other.role)) {
            return false;
        }
        if (!Objects.equals(this.date_naissance, other.date_naissance)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Camper{" + "nb_SS=" + nb_SS + ", nb_SB=" + nb_SB + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", date_naissance=" + date_naissance + ", login=" + login + ", pwd=" + pwd + ", gouvernorat=" + gouvernorat + ", sexe=" + sexe + ", cin=" + cin + ", num_Tel=" + num_Tel + ", skills=" + skills + ", role=" + role + '}';
    }

   

    
    

}