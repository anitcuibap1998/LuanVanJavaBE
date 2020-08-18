package an.util;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class JavaEmailSender {

	private String emailAddressTo = new String();
	private String msgSubject = new String();
	private String msgText = new String();

	final String USER_NAME = "tantaiphan150@gmail.com"; // User name of the Goole(gmail) account
	final String PASSSWORD = "anstu123"; // Password of the Goole(gmail) account
	final String FROM_ADDRESS = "tantaiphan150@gmail.com"; // From addresss

	public JavaEmailSender() {
	}

	public static boolean sendMailUtil(String emailAddressTo, String msgSubject, String msgText) {
		JavaEmailSender email = new JavaEmailSender();
		return email.createAndSendEmail(emailAddressTo, msgSubject,msgText);
	}

	private boolean createAndSendEmail(String emailAddressTo, String msgSubject, String msgText) {
		this.emailAddressTo = emailAddressTo;
		this.msgSubject = msgSubject;
		this.msgText = msgText;
		return sendEmailMessage();
	}

	private boolean sendEmailMessage() {

		// Create email sending properties
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(USER_NAME, PASSSWORD);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(FROM_ADDRESS)); // Set from address of the email
			message.setContent(msgText, "text/html"); // set content type of the email
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailAddressTo)); // Set email																									// recipient
			message.setSubject(msgSubject); // Set email message subject
			Transport.send(message); // Send email message

			System.out.println("sent email successfully!");
			return true;

		} catch (MessagingException e) {
//			throw new RuntimeException(e);
			return false;
		}
	}

	private void setEmailAddressTo(String emailAddressTo) {
		this.emailAddressTo = emailAddressTo;
	}

	private void setSubject(String subject) {
		this.msgSubject = subject;
	}

	private void setMessageText(String msgText) {
		this.msgText = msgText;
	}

}