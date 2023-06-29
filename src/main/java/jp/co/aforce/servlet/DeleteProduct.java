package jp.co.aforce.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.dao.ProductInfoDAO;

/**
 * Servlet implementation class DeleteProduct
 */
@WebServlet("/jp.co.aforce.servlet/delete-product")
public class DeleteProduct extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			
			String product_id = request.getParameter("id");
			
			ProductInfoDAO dao = new ProductInfoDAO();
			int line = dao.delete(product_id);
			
			if(line == 1) {
				request.setAttribute("success", "商品情報を削除しました。");
				request.getRequestDispatcher("/views/delete-product-result.jsp").forward(request, response);
			}else {
				request.setAttribute("failure", "商品情報が削除できませんでした。");
				request.getRequestDispatcher("/views/delete-product-result.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
