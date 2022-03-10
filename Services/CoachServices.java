/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Campination.App.Services;

import Campination.App.Entity.Coach;

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
import javafx.scene.control.Alert;

/**
 * *
 * @author infotel
 */
public class CoachServices implements CoachInterface {

    Connection connx;
    Statement ste;

    public CoachServices() {
        connx = MyConnexion.getInstanceConnex().getConnection();
        try {
            ste = connx.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    @Override
    public int AjouterCoach(Coach co) {
        int x = 0;
        try {
            String sql = "INSERT INTO `coach` ( `nom`, `prenom`, `num_Tel`, `email`, `login`, `pwd`, `gouvernorat`, `type_sport`, `cin`, `sexe`, `role`) VALUES ('" + co.getNom() + "', '" + co.getPrenom() + "', '" + co.getNum_Tel() + "',  '" + co.getEmail() + "', '" + co.getLogin() + "', '" + co.getPwd() + "', '" + co.getGouvernorat() + "', '" + co.getType_sport() + "',  '" + co.getCinCO() + "', '" + co.getSexe() + "', '" + co.getRole() + "';";

            x = ste.executeUpdate(sql);

        } catch (SQLException ex) {
            Logger.getLogger(CoachServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return x;
    }

    @Override
    public int ModifierCoach(Coach co) {

        int x = 0;
        String sql3 = "UPDATE `coach` SET `nom`=?,`prenom`=?,`num_Tel`=?,`email`=?,`login`=?,`pwd`=?,`gouvernorat`=?,`cinCO`=?,`sexe`=?,`type_sport`=?,`role`=? WHERE cin=? ";

        try {
            PreparedStatement pst = connx.prepareStatement(sql3);
            pst.setString(1, co.getNom());
            pst.setString(2, co.getPrenom());
            pst.setString(3, String.valueOf(co.getNum_Tel()));
            pst.setString(4, co.getEmail());
            pst.setString(5, co.getLogin());
            pst.setString(6, co.getPwd());
            pst.setString(7, co.getGouvernorat());
            pst.setString(8, String.valueOf(co.getCinCO()));
            pst.setString(9, co.getSexe());
            pst.setString(10, co.getType_sport());
            pst.setString(11, co.getRole());

            pst.setString(13, String.valueOf(co.getCinCO()));

            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(CoachServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;

    }

    @Override
    public int SupprimerCoach(Coach co) {
        try {
            String sql2 = "Delete from coach where cin= ? ";
            PreparedStatement pst = connx.prepareStatement(sql2);
            pst.setInt(1, co.getCinCO());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CoachServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public ArrayList<Coach> AfficherCoach() {
        ArrayList<Coach> coachs = new ArrayList<>();
        try {
            String sql4 = "select * from coach";
            ResultSet res = ste.executeQuery(sql4);

            Coach ca;
            while (res.next()) {
                ca = new Coach(
                        res.getString("nom"),
                        res.getString("prenom"),
                        res.getString("email"),
                        res.getString("login"),
                        res.getString("pwd"),
                        res.getString("gouvernorat"),
                        res.getString("sexe"),
                        res.getInt("cinCO"),
                        res.getInt("num_Tel"),
                        res.getString("type_sport"),
                        res.getString("role"));

                coachs.add(ca);

            }
        } catch (SQLException ex) {
            Logger.getLogger(CamperServices.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (Coach p : coachs) {
            System.out.println(p);
        }
        return coachs;
    }

    public static void infoBox(String infoMessage, String headerText, String title) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText(infoMessage);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.showAndWait();

    }

    @Override
    public ObservableList<Coach> AfficherListeCoach() {
        ObservableList<Coach> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = connx.prepareStatement("select * from coach");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Coach(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                         rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getString(10),
                        rs.getString(11)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public ObservableList<Coach> RechercherCoach(String x, String y) {
        ObservableList<Coach> co = FXCollections.observableArrayList();
        try {
            String sqlR = "select * from coach where " + x + " =\"" + y + "\"";
            System.out.println(sqlR);

            ResultSet res = ste.executeQuery(sqlR);
            Coach c;

            while (res.next()) {
                c = new Coach(
                        res.getString("nom"),
                        res.getString("prenom"),
                        res.getString("email"),
                        res.getString("login"),
                        res.getString("pwd"),
                        res.getString("gouvernorat"),
                        res.getString("sexe"),
                        res.getInt("cinCo"),
                        res.getInt("num_Tel"),
                        res.getString("type_sport"),
                        res.getString("role"));

                co.add(c);

            }
        } catch (SQLException ex) {
            Logger.getLogger(CoachServices.class.getName()).log(Level.SEVERE, null, ex);
        }

        return co;
    }
}
