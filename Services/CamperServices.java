/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Campination.App.Services;

import Campination.App.Entity.Camper;
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
public class CamperServices implements CamperInterface {

    Connection connx;
    Statement ste;
    ResultSet resultSet = null;

    public CamperServices() {
        connx = MyConnexion.getInstanceConnex().getConnection();
        try {
            ste = connx.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public int AjouterCamper(Camper c) {
        int x = 0;
        try {
            String sql = "INSERT INTO `camper` (`nom`,`prenom`,`num_Tel`,`email`,`date_naissance`,`login`,`pwd`,`gouvernorat`,`sexe`,`cin`,`skills`,`role`,,`nb_SS`,`nb_SB`) VALUES ('" + c.getNom() + "'"
                    + ", '" + c.getPrenom() + "', '" + c.getEmail() + "', '" + c.getSexe() + "', '" + c.getLogin() + "', '" + c.getPwd() + "', '" + c.getGouvernorat() + "', '" + c.getSkills() + "', '" + c.getRole() + "', '" + c.getNb_SS()+ "', '" + c.getNb_SB() + "');";

            x = ste.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(CamperServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return x;
    }

    @Override
    public int ModifierCamper(Camper c) {
        int x = 0;

        String sql3 = "UPDATE `camper` SET `nom`=? ,`prenom`=?,`num_Tel`=?,`email`=?,`date_naissance`=?,`pwd`=?,`login`=?,`gouvernorat`=?,`cin`=?,`Skills`=?,`role`=?,`nb_SS`=?,`nb_SB`=? Where cin=?";
        try {
            PreparedStatement pst = connx.prepareStatement(sql3);
            pst.setString(1, c.getNom());
            pst.setString(2, c.getPrenom());
            pst.setString(3, String.valueOf(c.getNum_Tel()));
            pst.setString(4, c.getEmail());
            pst.setString(5, String.valueOf(c.getDate_naissance()));
            pst.setString(6, c.getPwd());
            pst.setString(7, c.getLogin());
            pst.setString(8, c.getGouvernorat());

            pst.setString(9, String.valueOf(c.getCin()));
            pst.setString(10, c.getSkills());
            pst.setString(11, c.getRole());
                pst.setString(12, String.valueOf(c.getNb_SS()));
                    pst.setString(13, String.valueOf(c.getNb_SB()));
            pst.setString(14, String.valueOf(c.getCin()));

            pst.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(CamperServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;

    }

    @Override
    public int SuprimerCamper(Camper c) {
        try {
            String sql2 = "Delete from camper where cin= ? ";
            PreparedStatement pst = connx.prepareStatement(sql2);
            pst.setInt(1, c.getCin());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CamperServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public ArrayList<Camper> AfficherCamper() {
        ArrayList<Camper> Campers = new ArrayList<>();
        try {
            String sql4 = "select * from camper";
            ResultSet res = ste.executeQuery(sql4);

            Camper ca;
            while (res.next()) {
                ca = new Camper(
                        res.getString("nom"),
                        res.getString("prenom"),
                        res.getString("email"),
                        res.getDate("date_naissance"),
                        res.getString("login"),
                        res.getString("pwd"),
                        res.getString("gouvernorat"),
                        res.getString("sexe"),
                        res.getInt("cin"),
                        res.getInt("num_Tel"),
                        res.getString("skills"),
                        res.getString("role"),
           
                        res.getInt("nb_SS"),
                
                        res.getInt("nb_SB"));

                Campers.add(ca);

            }
        } catch (SQLException ex) {
            Logger.getLogger(CamperServices.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Campers;
    }

    public int campersNumber(int x) {

        String sql = "SELECT count(*) FROM `camper`";

        try {
            ste = connx.prepareStatement(sql);
            ResultSet resultSet = ste.executeQuery(sql);
            if (resultSet.next()) {
                x = resultSet.getInt(x);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return x;
    }

    @Override
    public ArrayList<Camper> RechercherCamper(String x, String y) {
        ArrayList<Camper> camp = new ArrayList<>();
        try {
            String sqlR = "select * from camper where " + x + " =\"" + y + "\"";
            System.out.println(sqlR);

            ResultSet res = ste.executeQuery(sqlR);
            Camper c;

            while (res.next()) {
                c = new Camper(
                        res.getString("nom"),
                        res.getString("prenom"),
                        res.getString("email"),
                        res.getDate("date_naissance"),
                        res.getString("login"),
                        res.getString("pwd"),
                        res.getString("gouvernorat"),
                        res.getString("sexe"),
                        res.getInt("cin"),
                        res.getInt("num_Tel"),
                        res.getString("skills"),
                        res.getString("role"),
                res.getInt("nb_SS"),
                res.getInt("nb_SB"));

                camp.add(c);

            }
        } catch (SQLException ex) {
            Logger.getLogger(CamperServices.class.getName()).log(Level.SEVERE, null, ex);
        }

        return camp;

    }

    @Override
    public ObservableList<Camper> ListCampers() {
        ObservableList<Camper> Campers = FXCollections.observableArrayList();
        try {
            String sql4 = "select * from camper";
            ResultSet res = ste.executeQuery(sql4);

            Camper ca;
            while (res.next()) {
                ca = new Camper(
                        res.getString("nom"),
                        res.getString("prenom"),
                        res.getString("email"),
                        res.getDate("date_naissance"),
                        res.getString("login"),
                        res.getString("pwd"),
                        res.getString("gouvernorat"),
                        res.getString("sexe"),
                        res.getInt("cin"),
                        res.getInt("num_Tel"),
                        res.getString("skills"),
                        res.getString("role"),
                        res.getInt("nb_SS"),
                        res.getInt("nb_SB"));

                Campers.add(ca);

            }
        } catch (SQLException ex) {
            Logger.getLogger(CamperServices.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Campers;

    }

}
