/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Campination.App.Services;

import Campination.App.Entity.Transporteur;
import Campination.App.Util.MyConnexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author infotel
 */
public class TransporteurServices implements TransporteurInterface {

    Connection connx;
    Statement ste;

    public TransporteurServices() {
        connx = MyConnexion.getInstanceConnex().getConnection();
        try {
            ste = connx.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public int AjouterTranporteur(Transporteur t) {
        int x = 0;
        try {
            String sql = "INSERT INTO `transporteur` (  `nom`,  `cinT`, `num_tel`, `gouvernorat`,  `moyenT`, `capacite`, `matricule`, `role`, `disponibilite`) VALUES ( '" + t.getNom() + "', '" + t.getCinT() + "',  '" + t.getNum_tel() + "' ,'" + t.getGouvernorat() + "',  '" + t.getMoyenT() + "', '" + t.getCapacite() + "', '" + t.getMatricule() + "',  '" + t.getRole() + "',  '" + t.getDisponibilite() + "');";

            x = ste.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(TransporteurServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return x;
    }

    @Override
    public int ModifierTransporteur(Transporteur t) {
        int x = 0;

        String sql3 = "UPDATE `transporteur` SET `num_tel`=?,`nom`=?,`gouvernorat`=?,`moyenT`=?,`capacite`=?,`matricule`=?,`role`=?,`cin`=?,`disponibilite`=? WHERE cin=?";
        try {
            PreparedStatement pst = connx.prepareStatement(sql3);
            pst.setString(1, String.valueOf(t.getNum_tel()));
            pst.setString(2, t.getNom());

            pst.setString(3, t.getGouvernorat());
            pst.setString(4, t.getMoyenT());
            pst.setString(5, String.valueOf(t.getCapacite()));
            pst.setString(6, t.getMatricule());
            pst.setString(7, t.getRole());

            pst.setString(8, String.valueOf(t.getCinT()));
            pst.setString(9, t.getDisponibilite());

            pst.setString(10, String.valueOf(t.getCinT()));

            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(TransporteurServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return x;
    }

    @Override
    public int SuprimerTransporteur(Transporteur t) {
        try {
            String sql2 = "DELETE FROM transporteur WHERE cin=?";
            PreparedStatement pst = connx.prepareStatement(sql2);
            pst.setInt(1, t.getCinT());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TransporteurServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public ArrayList<Transporteur> AfficherTransporteur() {
        ArrayList<Transporteur> transp = new ArrayList<>();
        try {
            String sql4 = "select * from transporteur";
            ResultSet res = ste.executeQuery(sql4);

            Transporteur t;
            while (res.next()) {
                t = new Transporteur(
                        res.getString("nom"),
                        res.getInt("cinT"),
                        res.getInt("num_tel"),
                        res.getString("gouvernorat"),
                        res.getString("moyenT"),
                        res.getString("matricule"),
                        res.getInt("capacite"),
                        res.getString("role"),
                        res.getString("disponibilite"));

                transp.add(t);

            }
        } catch (SQLException ex) {
            Logger.getLogger(TransporteurServices.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (Transporteur tp : transp) {
            System.out.println(tp);
        }
        return transp;
    }

    @Override
    public ObservableList<Transporteur> ListTransporteur() {
        ObservableList<Transporteur> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = connx.prepareStatement("select * from transporteur");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Transporteur(
                        rs.getString(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getString(9)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public int TransporteurNumber() {
        String sqla = "SELECT count(*) FROM `transporteur`";
        try {
            ste = connx.prepareStatement(sqla);
            ResultSet rs = ste.executeQuery(sqla);
            while (rs.next()) {

                int count = rs.getInt(1);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public ArrayList<Transporteur> RechercherTransporteur(String x, String y) {
        ArrayList<Transporteur> Trans = new ArrayList<>();
        try {
            String sqlR = "select * from transporteur where " + x + " =\"" + y + "\"";
            System.out.println(sqlR);

            ResultSet res = ste.executeQuery(sqlR);
            Transporteur t;

            while (res.next()) {
                t = new Transporteur(
                        res.getString("nom"),
                        res.getInt("cinT"),
                        res.getInt("num_tel"),
                        res.getString("gouvernorat"),
                        res.getString("moyenT"),
                        res.getString("matricule"),
                        res.getInt("capacite"),
                        res.getString("role"),
                        res.getString("disponibilite"));

                Trans.add(t);

            }
        } catch (SQLException ex) {
            Logger.getLogger(TransporteurServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Transporteur D : Trans) {

            System.out.println(D);

        }

        return Trans;

    }

    @Override
    public ArrayList<Transporteur> RechercherTransporteurDispo(String y) {
        ArrayList<Transporteur> Trans = new ArrayList<>();
        try {
            String Sql = "SELECT * FROM `transporteur` WHERE disponibilite=\"oui\"";
            System.out.println(Sql);

            ResultSet res = ste.executeQuery(Sql);
            Transporteur t;

            while (res.next()) {
                t = new Transporteur(
                        res.getString("nom"),
                        res.getInt("cinT"),
                        res.getInt("num_tel"),
                        res.getString("gouvernorat"),
                        res.getString("moyenT"),
                        res.getString("matricule"),
                        res.getInt("capacite"),
                        res.getString("role"),
                        res.getString("disponibilite"));

                Trans.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TransporteurServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Transporteur D : Trans) {

            System.out.println(D);

        }

        return Trans;
    }

    @Override
    public ArrayList<Transporteur> AfficherTransporteurDispo() {
        ArrayList<Transporteur> transp = new ArrayList<>();
        try {
            String sql4 = "SELECT * FROM `transporteur` WHERE disponibilite=\"oui\"";
            ResultSet res = ste.executeQuery(sql4);

            Transporteur t;
            while (res.next()) {
                t = new Transporteur(
                        res.getString("nom"),
                        res.getInt("cinT"),
                        res.getInt("num_tel"),
                        res.getString("gouvernorat"),
                        res.getString("moyenT"),
                        res.getString("matricule"),
                        res.getInt("capacite"),
                        res.getString("role"),
                        res.getString("disponibilite"));

                transp.add(t);

            }
        } catch (SQLException ex) {
            Logger.getLogger(TransporteurServices.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (Transporteur tp : transp) {
            System.out.println(tp);
        }
        return transp;
    }
}
