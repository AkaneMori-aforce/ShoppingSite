package jp.co.aforce.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.bean.ProductInfo;
import jp.co.aforce.dao.ProductInfoDAO;

/**
 * Servlet implementation class Search
 */
@WebServlet("/jp.co.aforce.servlet/admin-list")
public class AdminList extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			ProductInfoDAO dao = new ProductInfoDAO();
			List<ProductInfo> list = dao.all_list();
			request.setAttribute("list", list);
			request.getRequestDispatcher("/views/product-list.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			ProductInfoDAO dao = new ProductInfoDAO();
			List<ProductInfo> list = dao.all_list();
			request.setAttribute("list", list);
			request.getRequestDispatcher("/views/product-list.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
