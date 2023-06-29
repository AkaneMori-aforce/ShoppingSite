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
@WebServlet("/jp.co.aforce.servlet/search")
public class Search extends HttpServlet {
			
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			request.setCharacterEncoding("UTF-8");
			
			String product_keyword = request.getParameter("product_keyword");
			if(product_keyword == null) {
				product_keyword = "";
			}
			String category = request.getParameter("category");
			String sort = request.getParameter("sort");
			
			String new_sort = "new_sort";
			String row_sort = "row_sort";
			String high_sort = "high_sort";
			
			ProductInfoDAO dao = new ProductInfoDAO();
			if(new_sort.equals(sort)) {
				List<ProductInfo> list = dao.new_sort_search(product_keyword, category);
				if(list != null) {
					request.setAttribute("list", list);
					request.getRequestDispatcher("/views/search.jsp").forward(request, response);
				}else {
					request.setAttribute("failure", "検索結果がありません");
					request.getRequestDispatcher("/views/search.jsp").forward(request, response);
				}
			}else if(row_sort.equals(sort)) {
				List<ProductInfo> list = dao.row_sort_search(product_keyword, category);
				if(list != null) {
					request.setAttribute("list", list);
					request.getRequestDispatcher("/views/search.jsp").forward(request, response);
				}else {
					request.setAttribute("failure", "検索結果がありません");
					request.getRequestDispatcher("/views/search.jsp").forward(request, response);
				}
			}else if(high_sort.equals(sort)){
				List<ProductInfo> list = dao.high_sort_search(product_keyword, category);
				if(list != null) {
					request.setAttribute("list", list);
					request.getRequestDispatcher("/views/search.jsp").forward(request, response);
				}else {
					request.setAttribute("failure", "検索結果がありません");
					request.getRequestDispatcher("/views/search.jsp").forward(request, response);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}

}
