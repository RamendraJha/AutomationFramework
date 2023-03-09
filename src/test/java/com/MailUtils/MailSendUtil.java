package com.MailUtils;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.BodyPart;
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


public class MailSendUtil {
	
	public static void sendMail(final String username, final String password, 
			String fromMail, String toMail,String mailBody) {
		
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "outlook.office365.com");
        props.put("mail.smtp.port", "587");

		// get Session
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		// compose message
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {

			MimeMessage msg = new MimeMessage(session);
			msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
			msg.addHeader("format", "flowed");
			msg.addHeader("Content-Transfer-Encoding", "8bit");

			msg.setFrom(new InternetAddress(fromMail));
			

			//msg.setReplyTo(InternetAddress.parse("to mail", false));

			msg.setSubject("Test Report by Automation", "UTF-8");

			msg.setSentDate(new Date());

			msg.setRecipients(Message.RecipientType.TO,
	                InternetAddress.parse(toMail));
			// Create the message body part
			BodyPart messageBodyPart = new MimeBodyPart();

			messageBodyPart.setText("Find report in mail");
			messageBodyPart.setContent(mailBody,"text/html");
			//msg.setContent(bodyTable, "utf-8");
			

			// Create a multipart message for attachment
			Multipart multipart = new MimeMultipart();

			// Set text message part
			multipart.addBodyPart(messageBodyPart);

			// Second part is image attachment
			/* 	messageBodyPart = new MimeBodyPart();
		 String filename = System.getProperty("user.dir")
					+ "/target/cucumber-JVM-reports/cucumber-html-reports/overview-features.html";

			DataSource source = new FileDataSource(filename);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(filename);
			// Trick is to add the content-id header here
			messageBodyPart.setHeader("Content-ID", "image_id");
		*/	
			// zip the cucumber html report--
			String path1=System.getProperty("user.dir")+"/target/cucumber-report-html/cucumber-html-reports";
			File f = new File(path1);

	        // Populates the array with names of files and directories
	    	String[] myFiles = f.list();
	    	String path=System.getProperty("user.dir")+"/target/cucumber-report-html/cucumber-html-reports/";
	    	for(int i=0;i<myFiles.length;i++) {
	    		
	    		myFiles[i]=path+myFiles[i];
	    	}
	    	
	    	
	    	
	    	String zipFile = System.getProperty("user.dir")+"/target/CucumberReport.zip";
	    	ZipTheFolder zipfolder= new ZipTheFolder();
try {
	zipfolder.zip(myFiles, zipFile);
} catch (Exception ex) {
    // some errors occurred
    ex.printStackTrace();
  }
			// Second Attachement
			

			MimeBodyPart messageBodyPart2 = new MimeBodyPart();
			String filename2 = System.getProperty("user.dir") + "/target/CucumberReport.zip";

			try {
				messageBodyPart2.attachFile(filename2, "application/zip", "base64");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			multipart.addBodyPart(messageBodyPart);
			multipart.addBodyPart(messageBodyPart2);

			// third part for displaying image in the email body
			messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent("<h1>Attached is the zip</h1>", "text/html");
			multipart.addBodyPart(messageBodyPart);

			// Set the multipart message to the email message
			msg.setContent(multipart);

			// Send message
			Transport.send(msg);
			System.out.println("Email Sent Successfully with image!!");
			
			FileReadWrite.deleteFile(FileReadWrite.scenarioDetails);
			
			
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}

}
