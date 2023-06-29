package jp.co.aforce.bean;

public class UserInfo implements java.io.Serializable {
	
	private String user_id;
	private String last_name;
	private String first_name;
	private String birth_year;
	private String birth_month;
	private String birth_day;
	private String password;
	private String email_address;
	private String phone_number;
	
	//get
	public String getUserId() {
		return user_id;
	}
	
	public String getLastName() {
		return last_name;
	}

	public String getFirstName() {
		return first_name;
	}
	
	public String getBirthYear() {
		return birth_year;
	}
	
	public String getBirthMonth() {
		return birth_month;
	}
	
	public String getBirthDay() {
		return birth_day;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getEmailAddress() {
		return email_address;
	}
	
	public String getPhoneNumber() {
		return phone_number;
	}

	//set
	public void setUserId(String user_id) {
		this.user_id = user_id;
	}
	
	public void setLastName(String last_name) {
		this.last_name = last_name;
	}
	
	public void setFirstName(String first_name) {
		this.first_name = first_name;
	}
	
	public void setBirthYear(String birth_year) {
		this.birth_year = birth_year;
	}
	
	public void setBirthMonth(String birth_month) {
		this.birth_month = birth_month;
	}
	
	public void setBirthDay(String birth_day) {
		this.birth_day = birth_day;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmailAddress(String email_address) {
		this.email_address = email_address;
	}
	
	public void setPhoneNumber(String phone_number) {
		this.phone_number = phone_number;
	}
	
}
