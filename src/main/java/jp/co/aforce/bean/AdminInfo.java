package jp.co.aforce.bean;

public class AdminInfo implements java.io.Serializable {
	
	private String admin_id;
	private String admin_password;
	private String admin_name;
	
	//get
	public String getAdminId() {
		return admin_id;
	}
	
	public String getAdminPassword() {
		return admin_password;
	}

	public String getAdminName() {
		return admin_name;
	}
	
	//set
	public void setAdminId(String admin_id) {
		this.admin_id = admin_id;
	}
	
	public void setAdminPassword(String admin_password) {
		this.admin_password = admin_password;
	}
	
	public void setAdminName(String admin_name) {
		this.admin_name = admin_name;
	}
	
}
