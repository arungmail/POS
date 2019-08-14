package Pages;

import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
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

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import BasePackage.DriverClass;

public class JavaMail extends DriverClass{
	
	

public static void main(String[] args) {
	String urlName = driver.getCurrentUrl();
	 Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
	 String browserName = caps.getBrowserName();
	 String browserVersion = caps.getVersion();

    final String username = "arun.nichi@gmail.com";
    final String password = "Password_13";

    Properties props = new Properties();
    props.put("mail.smtp.auth", true);
    props.put("mail.smtp.starttls.enable", true);
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.port", "587");

    Session session = Session.getInstance(props,
            new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

    try {
    	Date date = new Date();
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("arun.nichi@gmail.com"));
        message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse("arun.pv@nichi.com"));
        message.setRecipients(Message.RecipientType.CC,
                InternetAddress.parse("ramanna.hemareddy@nichi.com"));
        message.setRecipients(Message.RecipientType.CC,
                InternetAddress.parse("mallikarjun@nichi.com"));
        message.setRecipients(Message.RecipientType.BCC,
                InternetAddress.parse("nithya.jois@nichi.com"));
        //Title of the Email
        //Get URL name and Append to Title 
        message.setSubject("DVR - Automation Test Report"+ " "+ "[ " + urlName + " ]" +" " +date.toGMTString() + " "+browserName+" "+browserVersion);
        message.setText("PFA");
        MimeBodyPart messageBodyPart = new MimeBodyPart();
        Multipart multipart = new MimeMultipart();
        messageBodyPart = new MimeBodyPart();
        String file = "D:\\Development\\DVRHARN\\dvrAutomation\\test-output\\emailable-report.html";
        String fileName = "DVR Automation Test Report";
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

