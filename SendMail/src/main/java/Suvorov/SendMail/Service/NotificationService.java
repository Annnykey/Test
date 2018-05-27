package Suvorov.SendMail.Service;


import Suvorov.SendMail.domain.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

	private JavaMailSender javaMailSender1;
	
	@Autowired
	public NotificationService (JavaMailSender javaMailSender) {
		this.javaMailSender1 = javaMailSender;
	}
	/** Service for e-mail sending. E-mail parameters are in email.properties file*/
	public void sendNotification (User user) {
		SimpleMailMessage mail = new SimpleMailMessage ();
		File file = new File ("src/main/resources/email.properties");
		Properties props = new Properties();
		try {
			props.load(new FileReader(file));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String From = props.getProperty("From");
		String Subject = props.getProperty("Subject");
		String Text = props.getProperty("Text");
		
		mail.setTo(user.getEmailAddress());
		mail.setFrom(From);
		mail.setSubject(Subject);
		mail.setText(Text);
		
		javaMailSender1.send(mail);
	}
}
