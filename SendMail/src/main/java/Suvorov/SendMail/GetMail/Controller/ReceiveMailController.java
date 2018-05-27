package Suvorov.SendMail.GetMail.Controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import Suvorov.SendMail.GetMail.EmailReceiver;

@RestController

public class ReceiveMailController {
	

	
	
	@RequestMapping ("/get")
	/** Gets all mails from the e-mail with parameters from config_get.properties */
	public String Get (){
		
		File file = new File("src/main/resources/config_get.properties");
		Properties props = new Properties();
		try {
			props.load(new FileReader(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
       
        
		String protocol = props.getProperty("protocol");
        String host = props.getProperty("host");
        String port = props.getProperty("port");
 
 
        String username = props.getProperty("username");
        String password = props.getProperty("password");
        
        EmailReceiver receiver = new EmailReceiver();
        receiver.downloadEmails(protocol, host, port, username, password);
		return host;
	}
	
}
