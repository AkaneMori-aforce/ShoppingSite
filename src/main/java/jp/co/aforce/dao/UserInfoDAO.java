package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.aforce.bean.UserInfo;

public class UserInfoDAO extends DAO {
	
	//loginメソッド：データベースの検索を行う
	public UserInfo login(String user_id, String password) throws Exception {
		UserInfo userinfo = null;
		
		Connection con = getConnection();
		
		//IDとpasswordが一致する行を取得
		PreparedStatement st = con.prepareStatement(
			"select * from user_info where user_id = ? and password = ? ");
		st.setString(1, user_id);
		st.setString(2, password);
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {
			userinfo = new UserInfo();
			userinfo.setUserId(rs.getString("user_id"));
			userinfo.setPassword(rs.getString("password"));
			userinfo.setLastName(rs.getString("last_name"));
			userinfo.setFirstName(rs.getString("first_name"));
			userinfo.setBirthYear(rs.getString("birth_year"));
			userinfo.setBirthMonth(rs.getString("birth_month"));
			userinfo.setBirthDay(rs.getString("birth_day"));
			userinfo.setPassword(rs.getString("password"));
			userinfo.setEmailAddress(rs.getString("email_address"));
			userinfo.setPhoneNumber(rs.getString("phone_number"));
		}
		
		st.close();
		con.close();
		
		return userinfo;
		
	}
	
}
