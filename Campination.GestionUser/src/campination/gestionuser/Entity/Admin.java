/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campination.gestionuser.Entity;

import java.util.Objects;

/**
 *
 * @author infotel
 */
public class Admin {
    private int id_Admin;
    private String nom;
    private String pwd;
    private String login;

    public Admin(int id_Admin,String nom, String login, String pwd) {
        this.nom = nom;
        this.pwd = pwd;
        this.login = login;
        this.id_Admin=id_Admin;
    }

    public Admin() {
    }

    @Override
    public String toString() {
        return "Admin{" + "nom=" + nom + ", pwd=" + pwd + ", login=" + login + '}';
    }

    public int getId_Admin() {
        return id_Admin;
    }

    public void setId_Admin(int id_Admin) {
        this.id_Admin = id_Admin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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
        final Admin other = (Admin) obj;
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.pwd, other.pwd)) {
            return false;
        }
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        return true;
    }
    
}
