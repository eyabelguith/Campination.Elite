/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campination.gestionsortie.utils;

import campination.gestionsortie.services.Mailing;

/**
 *
 * @author Eya
 */
public class mailv {
 public void replyMail(String mail ,String Username , String subject, String Description) {
        String from = "eyatalbi03@gmail.com";
        String pass = "213JFT4521";
        String[] to = {"" + mail}; // list of recipient email addresses
        //subject = "test";
        String body = Description;
        Mailing serv = new Mailing();
        serv.sendFromGMail(from,pass,to,subject,body);
    }   
}
