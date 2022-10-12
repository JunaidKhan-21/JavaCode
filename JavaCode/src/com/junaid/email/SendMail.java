package com.junaid.email;

import java.util.Properties;  
import javax.mail.*;  
import javax.mail.internet.*;  
  
public class SendMail {

    public static void main(String[] args) {

        // Recipient's email ID needs to be mentioned.
        String to = "junaidmd4ever@gmail.com";

        // Sender's email ID needs to be mentioned
        String from = "javatestjunaid@gmail.com";
        String from_password = "bgwqkrabskkrbzqh";
        //bgwqkrabskkrbzqh

        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";
        
        String port = "465";

        //Subject for email
        String subject = "New Email";
        String body = "Hello this is a test email";
        
        
        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication(from, from_password);

            }

        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field

            message.setSubject(subject);

            // Now set the actual message
            message.setText(body);

            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }

}