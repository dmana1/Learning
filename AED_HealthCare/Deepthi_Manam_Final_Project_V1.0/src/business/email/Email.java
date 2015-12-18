/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.email;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Deepthi
 */
public class Email {
    

private static final String SMTP_HOST_NAME = "smtp.gmail.com";
private static final String SMTP_PORT = "465";
private static final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";

public void sendSSLMessage(String recipients, String subject,
String message, String from) throws MessagingException {
boolean debug = true;

Properties props = new Properties();
props.put("mail.smtp.host", SMTP_HOST_NAME);
props.put("mail.smtp.auth", "true");
props.put("mail.debug", "true");
props.put("mail.smtp.port", SMTP_PORT);
props.put("mail.smtp.socketFactory.port", SMTP_PORT);
props.put("mail.smtp.socketFactory.class", SSL_FACTORY);
props.put("mail.smtp.socketFactory.fallback", "false");

Session session = Session.getDefaultInstance(props,
new javax.mail.Authenticator() {

protected PasswordAuthentication getPasswordAuthentication() {
return new PasswordAuthentication("AEDHealthCare@gmail.com", "AEDHealthCare1");
}
});

session.setDebug(debug);

Message msg = new MimeMessage(session);
InternetAddress addressFrom = new InternetAddress(from);
msg.setFrom(addressFrom);

InternetAddress address = new InternetAddress(recipients);

InternetAddress[] addressTo = new InternetAddress[1];
addressTo[0]=address;

msg.setRecipients(Message.RecipientType.TO, addressTo);

msg.setSubject(subject);
msg.setContent(message, "text/plain");
Transport.send(msg);
}
}
