package Suvorov.SendMail.domain;
/** 
 * Class contains parameters of recipient <b>firstName</b>, <b>LastName</b>, <b>EmailAddress</b>.
 * @autor Anna Suvorova
 * @version 1.3
*/
public class User {
	private String firstName;
	private String lastName;
	private String emailAddress;

	public User () {
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	}

