/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Asma
 */
public class SendEmail {

    private String to;
    private String from;
    

    public void SendEmail(String to, String from,int c) {
        this.to = to;  
        this.from = from;
        String host = "mail.javatpoint.com";
        String host2 = "localhost";  
          
        Properties properties = System.getProperties();
        //properties.setProperty("mail.smtp.host", host);
       properties.setProperty("mail.host", "smtp.gmail.com");
        properties.setProperty("mail.username", from);//your gmail
        properties.setProperty("mail.password", "213JFT0135");//your password
        properties.setProperty("mail.defaultEncoding", "UTF-8");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.required", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.setProperty("mail.smtp.socketFactory.fallback", "false");
        properties.setProperty("mail.smtp.port", "465");
        properties.setProperty("mail.smtp.socketFactory.port", "465");
        //Session session = Session.getDefaultInstance(properties);
        Session session = Session.getDefaultInstance(properties,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(
                                "asma.hejaiej@esprit.tn", "213JFT0135");
                    }
                });
          
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Code");
            message.setText("Your code is : "+c);

              
            Transport.send(message);
            System.out.println("message sent successfully....");

        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
    public void SendEmailTrainer(String to, String from,String pass) {
        this.to = to;  
        this.from = from;
        String host = "mail.javatpoint.com";
        String host2 = "localhost";  
          
        Properties properties = System.getProperties();
        //properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.host", "smtp.gmail.com");
        properties.setProperty("mail.username", from);//your gmail
        properties.setProperty("mail.password", "213JFT0135");//your password
        properties.setProperty("mail.defaultEncoding", "UTF-8");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.required", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.setProperty("mail.smtp.socketFactory.fallback", "false");
        properties.setProperty("mail.smtp.port", "465");
        properties.setProperty("mail.smtp.socketFactory.port", "465");
        //Session session = Session.getDefaultInstance(properties);
        Session session = Session.getDefaultInstance(properties,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(
                                "asma.hejaiej@esprit.tn", "213JFT0135");
                    }
                });
          
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Account");
            message.setText("Your password is : "+pass);

              
            Transport.send(message);
            System.out.println("message sent successfully....");

        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
