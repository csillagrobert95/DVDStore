package com.admin.dvdstore.sendemail;

import com.admin.dvdstore.dvd.DVDEntry;

import javax.mail.MessagingException;
import java.io.IOException;

/**
 * Created by Robi on 11/27/2018.
 */
public class DVDMailer {
    public void notifySubscribers(DVDEntry dvdEntry){
        StringBuffer sb = new StringBuffer();
        sb.append("<h3>New DVD:</h3>");
        sb.append("<p>Title: " + dvdEntry.getTitle() + "</p>");
        sb.append("<p>Year: " + dvdEntry.getYear() + "</p>");
        sb.append("<p>Price: " + dvdEntry.getPrice() + "</p>");

        EmailMessage emailToSend = new EmailMessage();
        emailToSend.setSubject("New DVD added: " + dvdEntry.getTitle());
        emailToSend.setToAddress("Destination@gmail.com");
        emailToSend.setBody(sb.toString());
        SendDVDEmail sendDVDEmail = new SendDVDEmail();
        try {
            sendDVDEmail.sendMail(emailToSend);
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
