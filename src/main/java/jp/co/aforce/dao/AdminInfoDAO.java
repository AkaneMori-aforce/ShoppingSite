package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.aforce.bean.AdminInfo;

public class AdminInfoDAO extends DAO {
	
	//loginメソッド：データベースの検索を行う
	public AdminInfo login(String admin_id, String admin_password) throws Exception {
		AdminInfo admininfo = null;
		
		Connection con = getConnection();
		
		//IDとpasswordが一致する行を取得
		PreparedStatement st = con.prepareStatement(
			"select * from admin_info where admin_id = ? and admin_password = ? ");
		st.setString(1, admin_id);
		st.setString(2, admin_password);
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {
			admininfo = new AdminInfo();
			admininfo.setAdminId(rs.getString("admin_id"));
			admininfo.setAdminPassword(rs.getString("admin_password"));
			admininfo.setAdminName(rs.getString("admin_name"));
		}
		
		st.close();
		con.close();
		
		return admininfo;
		
	}
	
}
