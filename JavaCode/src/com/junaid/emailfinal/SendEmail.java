package com.junaid.emailfinal;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendEmail {

	String fromaddress = "javatestjunaid@gmail.com";
	String frompassword = "bgwqkrabskkrbzqh";
	String toaddress = null;
	char flag = 'N';
	Scanner s1;
	String host = "smtp.gmail.com";
	String port = "465";
	Properties properties;
	Session session;
	String body = null;
	String subject = null;

	public void userinput() {

		s1 = new Scanner(System.in);
		System.out.println("Enter TO Address  :");
		//toaddress = s1.nextLine();
		toaddress= "junaidmd4ever@gmail.com";
//		s1.close();
		do {
			System.out.println("Do you want to add an attachment(Y/N) : ");
			String attachmentflag = s1.next();

			flag = attachmentflag.charAt(0);
			if (flag != 'Y' && flag != 'N' && flag != 'y' && flag != 'n') {
				System.out.println("wrong input!! valid values are Y or N  : " + flag);
			}
		} while (flag != 'Y' && flag != 'N' && flag != 'y' && flag != 'n');
	}

	public void setup() {
		properties = System.getProperties();
		// Setup mail server
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", port);
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");

		System.out.println("Sender Email : " + fromaddress);

	}

	public void emailDraft() {
		session = Session.getInstance(properties, new javax.mail.Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication(fromaddress, frompassword);

			}

		});

		try {

			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(fromaddress));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(toaddress));

			System.out.println("Enter the subject for email : ");
			subject = s1.next();
//			s1.close();
			//			subject = "hello";
			message.setSubject(subject);
			//			System.out.println( "Flag :" +flag);
			if (flag == 'Y') {
				Multipart multipart = new MimeMultipart();

				MimeBodyPart attachmentPart = new MimeBodyPart();

				MimeBodyPart textPart = new MimeBodyPart();

				try {

					File f = new File("C:\\Users\\junai\\OneDrive\\Documents\\Javacode\\hello.txt");

					attachmentPart.attachFile(f);
					System.out.println("Enter the body for the email  :");
					//body = s1.nextLine();
					body= "HI there";
					textPart.setText(body);
					multipart.addBodyPart(textPart);
					multipart.addBodyPart(attachmentPart);

				} catch (IOException e) {

					e.printStackTrace();

				}

				message.setContent(multipart);

			}
			else
			{
				System.out.println("Enter the body for the email  :");
				do {
					//					body = s1.next();
					body = s1.nextLine();
					System.out.println("body of email:" + body);

					if(body != null && body !="" && body!=" ")
					{
						message.setText(body);
						System.out.println("sending...");
						Transport.send(message);
						System.out.println("Sent message successfully....");
					}
				}while(body != null && body !="" && body!=" ");
			}

		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}

	public static void main(String[] args) {

		SendEmail se = new SendEmail();
		se.userinput();
		se.setup();
		se.emailDraft();
		se.s1.close();

	}

}
