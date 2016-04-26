package sendEmailNotification;
import java.util.Properties;

import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class PracEmail {

public static void main(String[] args) {

	final String username = "wprepemailer";
	final String password = "Kaplan1!";
	String toAddress[] = {"abdur.rahman@kaplan.com","latha.ramaswamy@kaplan.com","swapna.muppidi@kaplan.com"};
	
	Properties props = new Properties();
	props.put("mail.smtp.auth", "true");
	props.put("mail.smtp.starttls.enable", "true");
	props.put("mail.smtp.host", "smtp-cypress.kaplaninc.com");
	props.put("mail.smtp.port", "25");

    Session session = Session.getInstance(props,
            new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

    try {

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(username));
        message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse("swapna.muppidi@kaplan.com"));
        message.setRecipients(Message.RecipientType.CC,
                InternetAddress.parse("abdur.rahman@kaplan.com"));
        //msg.setRecipients(Message.RecipientType.TO, addressTo); 
        message.setRecipients(Message.RecipientType.BCC,
                InternetAddress.parse("latha.ramaswamy@kaplan.com"));
        message.setSubject("Test Execution result");
        message.setText("FYI");

        MimeBodyPart messageBodyPart = new MimeBodyPart();

        Multipart multipart = new MimeMultipart();

        messageBodyPart = new MimeBodyPart();
        String file = "C:\\Users\\AbRahman\\Desktop\\Step1HYTitleVerification.xlsx";
        String fileName = "Step1HYTitleVerification.xlsx";
        DataSource source = new FileDataSource(file);
        messageBodyPart.setDataHandler(new DataHandler(source));
        messageBodyPart.setFileName(fileName);
        multipart.addBodyPart(messageBodyPart);

        message.setContent(multipart);

        System.out.println("Sending");

        Transport.send(message);

        System.out.println("Done");

    } catch (MessagingException e) {
        e.printStackTrace();
    }
  }
}

