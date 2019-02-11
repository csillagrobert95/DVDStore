package com.admin.dvdstore.sendemail;

import javax.mail.*;

import javax.mail.internet.*;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

/**
 * Created by Robi on 11/23/2018.
 */

public class SendDVDEmail {
    private String username = "email@gmail.com";
    private String password = "password";

    public void sendMail(EmailMessage emailmessage) throws AddressException, MessagingException, IOException {

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(username, false));

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailmessage.getToAddress()));
        msg.setSubject(emailmessage.getSubject());
        msg.setContent(emailmessage.getBody(), "text/html");
        msg.setSentDate(new Date());

        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(emailmessage.getBody(), "text/html");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);

        msg.setContent(multipart);
        // sends the e-mail
        Transport.send(msg);

    }
}
