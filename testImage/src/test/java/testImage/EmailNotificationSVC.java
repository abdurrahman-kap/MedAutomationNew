package testImage;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import testImage.EmailAttachment;
import testImage.EmailNotification;

/**
 * @author - Harpreet Singh Bhalla
 * last updated on - 09/30/2015
 * 
 */
public class EmailNotificationSVC 
{
	/**
	 * @param notification
	 * @throws Exception
	 */
	public static void sendEmailNotifcation(EmailNotification notification) throws Exception {
	
		Session	session = getSession(); // TODO: Get session info from properties
		
		validateRequiredFileds(notification);
		
		MimeMessage message = createMessage(session, notification);
		
		Transport trans = session.getTransport();
		
		trans.connect();
		
		trans.sendMessage(message, message.getAllRecipients());
		
		trans.close();
	}
	
	private static void validateRequiredFileds(EmailNotification notification) throws IllegalArgumentException {
		
		// TODO: Validate format
		
		List<String> fields = new ArrayList<String>();
		// To
		if (notification.getToAddresses() == null || notification.getToAddresses().size() < 1) {
			fields.add("Recipient (To)");
		}
		// From
		if (notification.getFromAddress() == null || notification.getFromAddress().isEmpty()) {
			fields.add("From Address");
		}
		// Subject
		if (notification.getSubject() == null || notification.getSubject().isEmpty()) {
			fields.add("Subject");
		}
		// Body
		if (notification.getBody() == null || notification.getBody().isEmpty()) {
			fields.add("Body");
		}
		
		if (fields.size() > 0) {
			throw new IllegalArgumentException("Missing required field(s): "+fields.toString());
		} else {
			return;
		}
	}
	
	private static MimeMessage createMessage(Session session, EmailNotification notification) throws Exception {
		
		MimeMessage message = new MimeMessage(session); 
		
		// TO
		Address[] addresses = new Address[notification.getToAddresses().size()];
		Address address;
		int index = 0;
		for (String toAddress : notification.getToAddresses()) {
			address = new InternetAddress(toAddress);
			addresses[index++] = address;
		}
		message.setRecipients(Message.RecipientType.TO, addresses);
		
		// CC
		if (notification.getCcAddresses() != null && notification.getCcAddresses().size() > 0) {
			addresses = new Address[notification.getCcAddresses().size()];
			index = 0;
			for (String ccAddress : notification.getCcAddresses()) {
				address = new InternetAddress(ccAddress);
				addresses[index++] = address;
			}
			message.setRecipients(Message.RecipientType.CC, addresses);
		}
		
		// BCC
		if (notification.getBccAddresses() != null && notification.getBccAddresses().size() > 0) {
			addresses = new Address[notification.getBccAddresses().size()];
			index = 0;
			for (String bccAddress : notification.getBccAddresses()) {
				address = new InternetAddress(bccAddress);
				addresses[index++] = address;
			}
			message.setRecipients(Message.RecipientType.BCC, addresses);
		}
		
		// FROM
		message.setFrom(new InternetAddress(notification.getFromAddress()));
		
		// Subject
		message.setSubject(notification.getSubject());
		
		// Body
		Multipart mp = new MimeMultipart();
		// creates body part for the message
		MimeBodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setContent(notification.getBody(), notification.getBodyType().getMimeType());
		mp.addBodyPart(messageBodyPart);
		
		// Attachment(s)
		if (notification.getAttachments() != null && notification.getAttachments().size() > 0) 
		{
			MimeBodyPart attachBodyPart;
			for (EmailAttachment attachment : notification.getAttachments()) 
			{
				// creates body part for the attachment
					attachBodyPart = new MimeBodyPart();
					String filePath = attachment.getFileName();
					String FileName = filePath.substring(filePath.lastIndexOf("\\")+1);
					DataSource fileDataSource = new FileDataSource(attachment.getFileName());
					attachBodyPart.setDataHandler(new DataHandler(fileDataSource));
					attachBodyPart.setFileName(FileName);
					mp.addBodyPart(attachBodyPart);
			}
		}
		
		// Add Body/Attachment(s) to message
		
		message.setContent(mp);		
		
		// Priority
		
		if (notification.getPriority() != null) {
			message.setHeader("X-Priority", notification.getPriority().getValue());
		}
		
		return message;
	}
	
	private static Session getSession() throws Exception {
		  Properties props = new Properties();
		  props.setProperty("mail.host", "mail1.homedepot.com");
		  props.setProperty("mail.transport.protocol", "smtp");
		  
		  Session session = Session.getDefaultInstance(props, null);
		  
		  return session;
	}
}

	


