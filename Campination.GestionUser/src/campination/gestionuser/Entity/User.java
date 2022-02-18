/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campination.gestionuser.Entity;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author infotel
 */
public class User {
    protected int id;
    protected String nom;
    protected String prenom;
    protected String email;
    protected Date date_naissance;
    protected String login;
    protected String pwd;
    protected String gouvernorat;
    protected String sexe;
    protected int cin;
    protected int num_Tel;

    public User() {
    }

    public User( String nom, String prenom, String email, Date date_naissance, String login, String pwd, String gouvernorat, String sexe, int cin, int num_Tel) {
    
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
    }

   

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getNum_Tel() {
        return num_Tel;
    }

    public void setNum_Tel(int num_Tel) {
        this.num_Tel = num_Tel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public int hashCode() {
        int hash = 3;
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
        final User other = (User) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.cin != other.cin) {
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
        if (!Objects.equals(this.pwd, other.pwd)) {
            return false;
        }
        if (!Objects.equals(this.gouvernorat, other.gouvernorat)) {
            return false;
        }
        if (!Objects.equals(this.sexe, other.sexe)) {
            return false;
        }
        if (!Objects.equals(this.date_naissance, other.date_naissance)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", nom=" + nom +", num_Tel=" + num_Tel + ", prenom=" + prenom + ", email=" + email + ", date_naissance=" + date_naissance + ", pwd=" + pwd + ", gouvernorat=" + gouvernorat + ", sexe=" + sexe + ", cin=" + cin + '}';
    }
    
    
}
