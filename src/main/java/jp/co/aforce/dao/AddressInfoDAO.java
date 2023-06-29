package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jp.co.aforce.bean.AddressInfo;

public class AddressInfoDAO extends DAO {
	public List<AddressInfo> address(String user_id) throws Exception {
		List<AddressInfo> list = new ArrayList<>();
		
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement(
			"select * from user_address where user_id = ? ");
		st.setString(1, user_id);
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {
			AddressInfo u = new AddressInfo();
			u.setAddressId(rs.getString("address_id"));
			u.setPostCode(rs.getString("post_code"));
			u.setState(rs.getString("state"));
			u.setCity(rs.getString("city"));
			u.setAddressLine(rs.getString("address_line"));
			u.setReceiverLastName(rs.getString("receiver_last_name"));
			u.setReceiverFirstName(rs.getString("receiver_first_name"));
			list.add(u);
		}
		
		st.close();
		con.close();
		
		return list;
		
	}
	
	public AddressInfo receive_address(String address_id) throws Exception {
		AddressInfo addressinfo = null;
		
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement(
			"select * from user_address where address_id = ? ");
		st.setString(1, address_id);
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {
			addressinfo = new AddressInfo();
			addressinfo.setAddressId(rs.getString("address_id"));
			addressinfo.setPostCode(rs.getString("post_code"));
			addressinfo.setState(rs.getString("state"));
			addressinfo.setCity(rs.getString("city"));
			addressinfo.setAddressLine(rs.getString("address_line"));
			addressinfo.setReceiverLastName(rs.getString("receiver_last_name"));
			addressinfo.setReceiverFirstName(rs.getString("receiver_first_name"));
		}
		
		st.close();
		con.close();
		
		return addressinfo;
		
	}
	
	//registメソッド：住所の登録
	public int regist(AddressInfo info) throws Exception {
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement(
				"insert into user_address ("
				+ "user_id, "
				+ "post_code, state, "
				+ "city, address_line, "
				+ "receiver_last_name, receiver_first_name) "
				+ "values(?, ?, ?, ?, ?, ?, ?)");
		st.setString(1, info.getUserId());
		st.setString(2, info.getPostCode());
		st.setString(3, info.getState());
		st.setString(4, info.getCity());
		st.setString(5, info.getAddressLine());
		st.setString(6, info.getReceiverLastName());
		st.setString(7, info.getReceiverFirstName());
		int line = st.executeUpdate();
		
		st.close();
		con.close();
		
		return line;
		
	}
	
	//deleteメソッド：住所削除
	public int delete(String address_id) throws Exception {
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement(
				"delete from user_address where address_id = ?");
		st.setString(1, address_id);
		int line = st.executeUpdate();
		
		st.close();
		con.close();
		
		return line;
		
	}
	
}
