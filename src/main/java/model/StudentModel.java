package model;
//Ness
import java.time.LocalDate;

public class StudentModel {
	private String firstname;
	private String lastname;
	private LocalDate date;
	private String gender;
	private String email;
	private String subject;
	private String phoneNumberStr;
	private String username;
	private String password;
	
	public StudentModel(String firstname, String lastname, LocalDate date, String gender, String email, 
			String phoneNumberStr, String subject, String username, String password) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.date = date;
		this.gender = gender;
		this.email = email;
		this.subject = subject;
		this.phoneNumberStr = phoneNumberStr;
		this.username = username;
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getPhoneNumberStr() {
		return phoneNumberStr;
	}

	public void setPhoneNumberStr(String phoneNumberStr) {
		this.phoneNumberStr = phoneNumberStr;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
    
}
