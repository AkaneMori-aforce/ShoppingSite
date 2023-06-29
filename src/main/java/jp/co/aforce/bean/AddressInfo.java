package jp.co.aforce.bean;

public class AddressInfo implements java.io.Serializable {
	
	private String address_id;
	private String user_id;
	private String post_code;
	private String state;
	private String city;
	private String address_line;
	private String receiver_last_name;
	private String receiver_first_name;
	
	//get
	public String getAddressId() {
		return address_id;
	}
	
	public String getUserId() {
		return user_id;
	}
	
	public String getPostCode() {
		return post_code;
	}

	public String getState() {
		return state;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getAddressLine() {
		return address_line;
	}
	
	public String getReceiverLastName() {
		return receiver_last_name;
	}
	
	public String getReceiverFirstName() {
		return receiver_first_name;
	}
	
	//set
	public void setAddressId(String address_id) {
		this.address_id = address_id;
	}
	
	public void setUserId(String user_id) {
		this.user_id = user_id;
	}
	
	public void setPostCode(String post_code) {
		this.post_code = post_code;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public void setAddressLine(String address_line) {
		this.address_line = address_line;
	}
	
	public void setReceiverLastName(String receiver_last_name) {
		this.receiver_last_name = receiver_last_name;
	}

	public void setReceiverFirstName(String receiver_first_name) {
		this.receiver_first_name = receiver_first_name;
	}
	
}
