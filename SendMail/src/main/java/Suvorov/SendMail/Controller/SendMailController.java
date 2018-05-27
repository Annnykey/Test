package Suvorov.SendMail.Controller;




import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Suvorov.SendMail.Service.NotificationService;
import Suvorov.SendMail.domain.User;


@RestController
public class SendMailController {
	
private Logger logger = LoggerFactory.getLogger(SendMailController.class);
	
	@Autowired
	private NotificationService HotificationService;
	
	

	
	
	@RequestMapping ("/signup-success")
	/** Sends e-mail to the recipient, which parameters are described in config_send. E-mail content in email.properties*/
	public String signupSuccess () {
		File file = new File ("src/main/resources/config_send.properties");
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
		
		User user1 = new User();
		user1.setFirstName(props.getProperty("FirstName"));
		user1.setLastName(props.getProperty("LastName"));
		user1.setEmailAddress(props.getProperty("EmailAddress"));
		
		
		
		try {
			HotificationService.sendNotification(user1);
		}catch (MailException e) {
			logger.info("Error is " + e.getMessage());
		}
		return "Notification was sent";
	}
}
