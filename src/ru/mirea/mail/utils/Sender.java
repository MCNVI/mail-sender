package ru.mirea.mail.utils;

import com.sun.mail.smtp.SMTPMessage;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Sender {

    Properties props = new Properties();
//    String username = "mailSender0720@gmail.com";
    String password = "mail0720!";

    public Sender() throws IOException {
        File properties = new File("smtp.properties");
        props.load(new FileInputStream(properties));
    }

    public void send(String to, String message) throws MessagingException {
        System.out.println(to);
        System.out.println(message);

        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(props.getProperty("mail.username"), password);
            }
        };

        System.out.println(props);
        Session session = Session.getInstance(props, auth);
        SMTPMessage msg = new SMTPMessage(session);
        msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        msg.setText(message);

        Transport.send(msg);
    }


}
