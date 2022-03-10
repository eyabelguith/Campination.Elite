/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Campination.App.Entity;

/**
 *
 * @author Eya
 */
public class VIP {
    private int id_vip;
       private int cin ;
        private int  nb_SS; 
        private int   nb_SB; //mel camper 
        private int   nb_pt; 
            
 public VIP(){}

    public VIP( int cin, int nb_SS, int nb_SB, int nb_pt) {
     
        this.cin = cin;
        this.nb_SS = nb_SS;
        this.nb_SB = nb_SB;
        this.nb_pt = nb_pt;
    }

    public int getId_vip() {
        return id_vip;
    }

    public void setId_vip(int id_vip) {
        this.id_vip = id_vip;
    }

    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
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

    public int getNb_pt() {
        return nb_pt;
    }

    public void setNb_pt(int nb_pt) {
        this.nb_pt = nb_pt;
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
        final VIP other = (VIP) obj;
        if (this.id_vip != other.id_vip) {
            return false;
        }
        if (this.cin != other.cin) {
            return false;
        }
        if (this.nb_SS != other.nb_SS) {
            return false;
        }
        if (this.nb_SB != other.nb_SB) {
            return false;
        }
        if (this.nb_pt != other.nb_pt) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "VIP{" + ", cin=" + cin + ", nb_SS=" + nb_SS + ", nb_SB=" + nb_SB + ", nb_pt=" + nb_pt + '}';
    }

   




}

