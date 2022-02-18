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
public class Camper extends User {
    private int id_Camper;
    private String skills;

    public Camper(int id_Camper, String nom, String prenom, String email, Date date_naissance, String login, String pwd, String gouvernorat, String sexe, int cin, int num_Tel,String skills) {
        super(nom, prenom, email, date_naissance, login, pwd, gouvernorat, sexe, cin, num_Tel);
        this.id_Camper=id_Camper;
        this.skills=skills;
    }
  
    public Camper(){}

   


    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public String toString() {
        return "Camper{" + "id=" + id_Camper + ", nom=" + this.getNom() + 
                ", prenom=" + this.getPrenom()+ ", num_Tel=" + this.getNum_Tel() + ", email=" + this.getEmail() +
                ", date_naissance=" + this.getDate_naissance() + ", pwd=" + this.getPwd() + ","
                + " gouvernorat=" + this.getGouvernorat() + ", sexe=" + this.getSexe() + ", cin=" + this.getCin() + '}';
   
    }

    @Override
    public void setCin(int cin) {
        super.setCin(cin); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getCin() {
        return super.getCin(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setSexe(String sexe) {
        super.setSexe(sexe); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSexe() {
        return super.getSexe(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setGouvernorat(String gouvernorat) {
        super.setGouvernorat(gouvernorat); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getGouvernorat() {
        return super.getGouvernorat(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setPwd(String pwd) {
        super.setPwd(pwd); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getPwd() {
        return super.getPwd(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setDate_naissance(Date date_naissance) {
        super.setDate_naissance(date_naissance); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Date getDate_naissance() {
        return super.getDate_naissance(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setEmail(String email) {
        super.setEmail(email); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEmail() {
        return super.getEmail(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setPrenom(String prenom) {
        super.setPrenom(prenom); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getPrenom() {
        return super.getPrenom(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setNom(String nom) {
        super.setNom(nom); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNom() {
        return super.getNom(); //To change body of generated methods, choose Tools | Templates.
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
        if (!Objects.equals(this.skills, other.skills)) {
            return false;
        }
        return true;
    }
    
}
