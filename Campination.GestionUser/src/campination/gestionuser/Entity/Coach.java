/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campination.gestionuser.Entity;

import java.sql.Date;

/**
 *
 * @author infotel
 */
public class Coach extends User{
    private int id_Coach;
    private String type_sport;

  

    public Coach(int id_Coach, String type_sport, String nom, String prenom, String email, Date date_naissance, String login, String pwd, String gouvernorat, String sexe, int cin, int num_Tel) {
        super( nom, prenom, email, date_naissance, login, pwd, gouvernorat, sexe, cin, num_Tel);
        this.id_Coach = id_Coach;
        this.type_sport = type_sport;
    }

    public Coach() {
    }

   
   

    public String getType_sport() {
        return type_sport;
    }

    public void setType_sport(String type_sport) {
        this.type_sport = type_sport;
    }

   
   
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
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

    public int getId_Coach() {
        return id_Coach;
    }

    public void setId_Coach(int id_Coach) {
        this.id_Coach = id_Coach;
    }

    @Override
    public void setNum_Tel(int num_Tel) {
        super.setNum_Tel(num_Tel); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getNum_Tel() {
        return super.getNum_Tel(); //To change body of generated methods, choose Tools | Templates.
    }

   @Override
    public String toString() {
        return "Coach{" + "id=" + id_Coach + ", nom=" + this.getNom() + ", num Tel=" + this.getNum_Tel()+
                ", prenom=" + this.getPrenom()+ ", email=" + this.getEmail() +
                ", date_naissance=" + this.getDate_naissance() + ", pwd=" + this.getPwd() + ","
                + " gouvernorat=" + this.getGouvernorat() + ", sexe=" + this.getSexe() + ", cin=" + this.getCin() + '}';
   
    }


    
}
