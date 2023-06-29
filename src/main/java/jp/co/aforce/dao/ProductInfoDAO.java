package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jp.co.aforce.bean.ProductInfo;

public class ProductInfoDAO extends DAO {
	
	//find_allメソッド：商品一覧表示（新着順デフォ）
	public List<ProductInfo> find_all() throws Exception {
		List<ProductInfo> list = new ArrayList<>();
		
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement(
				"select * from product_info "
				+ "order by product_id desc;");
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {
			ProductInfo p = new ProductInfo();
			p.setProductId(rs.getString("product_id"));
			p.setProductName(rs.getString("product_name"));
			p.setCategory(rs.getString("category"));
			p.setPrice(rs.getString("price"));
			p.setStock(rs.getInt("stock"));
			p.setDescription(rs.getString("description"));
			p.setImgName(rs.getString("img_name"));
			list.add(p);
		}
		
		st.close();
		con.close();
		
		return list;
	}
		
	//new_sort_searchメソッド：商品検索（新着順）
	public List<ProductInfo> new_sort_search(String product_keyword, String category) throws Exception {
		List<ProductInfo> list = new ArrayList<>();
		
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement(
				"select * from product_info "
				+ "where product_name like ? "
				+ "and category like ? "
				+ "order by product_id desc;");
		st.setString(1, "%"+product_keyword+"%");
		st.setString(2, "%"+category+"%");
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {
			ProductInfo p = new ProductInfo();
			p.setProductId(rs.getString("product_id"));
			p.setProductName(rs.getString("product_name"));
			p.setCategory(rs.getString("category"));
			p.setPrice(rs.getString("price"));
			p.setStock(rs.getInt("stock"));
			p.setDescription(rs.getString("description"));
			p.setImgName(rs.getString("img_name"));
			list.add(p);
		}
		
		st.close();
		con.close();
		
		return list;
		
	}
	
	//row_sort_searchメソッド：商品検索（安い順）
		public List<ProductInfo> row_sort_search(String product_keyword, String category) throws Exception {
			List<ProductInfo> list = new ArrayList<>();
			
			Connection con = getConnection();
			
			PreparedStatement st = con.prepareStatement(
					"select * from product_info "
					+ "where product_name like ? "
					+ "and category like ? "
					+ "order by price asc;");
			st.setString(1, "%"+product_keyword+"%");
			st.setString(2, "%"+category+"%");
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				ProductInfo p = new ProductInfo();
				p.setProductId(rs.getString("product_id"));
				p.setProductName(rs.getString("product_name"));
				p.setCategory(rs.getString("category"));
				p.setPrice(rs.getString("price"));
				p.setStock(rs.getInt("stock"));
				p.setDescription(rs.getString("description"));
				p.setImgName(rs.getString("img_name"));
				list.add(p);
			}
			
			st.close();
			con.close();
			
			return list;
			
		}
		
		//high_sort_searchメソッド：商品検索（高い順）
		public List<ProductInfo> high_sort_search(String product_keyword, String category) throws Exception {
			List<ProductInfo> list = new ArrayList<>();
			
			Connection con = getConnection();
			
			PreparedStatement st = con.prepareStatement(
					"select * from product_info "
					+ "where product_name like ? "
					+ "and category like ? "
					+ "order by price desc;");
			st.setString(1, "%"+product_keyword+"%");
			st.setString(2, "%"+category+"%");
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				ProductInfo p = new ProductInfo();
				p.setProductId(rs.getString("product_id"));
				p.setProductName(rs.getString("product_name"));
				p.setCategory(rs.getString("category"));
				p.setPrice(rs.getString("price"));
				p.setStock(rs.getInt("stock"));
				p.setDescription(rs.getString("description"));
				p.setImgName(rs.getString("img_name"));
				list.add(p);
			}
			
			st.close();
			con.close();
			
			return list;
			
		}
		
		//searchメソッド：特定の商品情報取得
		public ProductInfo search(String product_id) throws Exception {
			ProductInfo info = null;
			
			Connection con = getConnection();
			
			PreparedStatement st = con.prepareStatement(
					"select * from product_info "
					+ "where product_id = ?;");
			st.setString(1, product_id);
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				info = new ProductInfo();
				info.setProductId(rs.getString("product_id"));
				info.setProductName(rs.getString("product_name"));
				info.setCategory(rs.getString("category"));
				info.setPrice(rs.getString("price"));
				info.setStock(rs.getInt("stock"));
				info.setDescription(rs.getString("description"));
				info.setImgName(rs.getString("img_name"));
			}
			
			st.close();
			con.close();
			
			return info;
		}
		
///////////////////////////////////////////////////////////////////////////////////admin
		
		//all_listメソッド：商品一覧表示（id順）
		public List<ProductInfo> all_list() throws Exception {
			List<ProductInfo> list = new ArrayList<>();
			
			Connection con = getConnection();
			
			PreparedStatement st = con.prepareStatement(
					"select * from product_info "
					+ "order by product_id asc;");
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				ProductInfo p = new ProductInfo();
				p.setProductId(rs.getString("product_id"));
				p.setProductName(rs.getString("product_name"));
				p.setCategory(rs.getString("category"));
				p.setPrice(rs.getString("price"));
				p.setStock(rs.getInt("stock"));
				p.setDescription(rs.getString("description"));
				p.setImgName(rs.getString("img_name"));
				list.add(p);
			}
			
			st.close();
			con.close();
			
			return list;
		}
		
		//registメソッド：商品の登録
		public int regist(ProductInfo info) throws Exception {
			Connection con = getConnection();
			
			PreparedStatement st = con.prepareStatement(
					"insert into product_info ("
					+ "product_name, category, "
					+ "price, stock, "
					+ "description, img_name) "
					+ "values(?, ?, ?, ?, ?, ?)");
			st.setString(1, info.getProductName());
			st.setString(2, info.getCategory());
			st.setString(3, info.getPrice());
			st.setInt(4, info.getStock());
			st.setString(5, info.getDescription());
			st.setString(6, info.getImgName());
			int line = st.executeUpdate();
			
			st.close();
			con.close();
			
			return line;
			
		}
		
		//updateメソッド：商品情報更新
		public int update(ProductInfo info) throws Exception {
			Connection con = getConnection();
			
			PreparedStatement st = con.prepareStatement(
					"update product_info set "
					+ "product_name = ?, category = ?, price = ?, "
					+ "stock = ?, description = ?, img_name = ? "
					+ "where product_id = ?;");
			st.setString(1, info.getProductName());
			st.setString(2, info.getCategory());
			st.setString(3, info.getPrice());
			st.setInt(4, info.getStock());
			st.setString(5, info.getDescription());
			st.setString(6, info.getImgName());
			st.setString(7, info.getProductId());
			int line = st.executeUpdate();
			
			st.close();
			con.close();
			
			return line;
		}
		
		//deleteメソッド：商品削除
		public int delete(String product_id) throws Exception {
			Connection con = getConnection();
			
			PreparedStatement st = con.prepareStatement(
					"delete from product_info where product_id = ?");
			st.setString(1, product_id);
			int line = st.executeUpdate();
			
			st.close();
			con.close();
			
			return line;
			
		}
		
}
