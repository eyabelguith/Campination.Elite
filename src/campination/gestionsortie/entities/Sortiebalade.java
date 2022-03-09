/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campination.gestionsortie.entities;

import java.util.Date;

/**
 *
 * @author Eya
 */
public class Sortiebalade extends Sortie {
    private int id_SB;
            private int id_destinationB;
          

    public Sortiebalade() {
    }

    public Sortiebalade(int id_SB, int id_destinationB, java.sql.Date date_depart, java.sql.Date date_retour, int cinT, String nom_S) {
        super(date_depart, date_retour, cinT,nom_S);
        this.id_SB = id_SB;
        this.id_destinationB = id_destinationB;
       
    }



    public int getId_SB() {
        return id_SB;
    }

    public void setId_SB(int id_SB) {
        this.id_SB = id_SB;
    }

    public int getId_destinationB() {
        return id_destinationB;
    }

    public void setId_destinationB(int id_destinationB) {
        this.id_destinationB = id_destinationB;
    }

    
      
    
    
    
    /*@Override
    public String toString() {
        
        return "Sortiebalade{" + "id_SB=" + id_SB + ", id_destinationB=" + id_destinationB +  '}';
    }*/
    

  

    @Override
    public String toString() {
        return "Sortiebalade{" + "id_SB=" + id_SB + ", id_destinationB=" + id_destinationB + '}';
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
        final Sortiebalade other = (Sortiebalade) obj;
        if (this.id_SB != other.id_SB) {
            return false;
        }
        
        return true;
    }

 
  

   

    @Override
    public void setCinT(int cinT) {
        super.setCinT(cinT); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getCinT() {
        return super.getCinT(); //To change body of generated methods, choose Tools | Templates.
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

   @Override
    public void setNom_S(String nom_S) {
        super.setNom_S(nom_S); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNom_S() {
        return super.getNom_S(); //To change body of generated methods, choose Tools | Templates.
    }  
    
    
}
