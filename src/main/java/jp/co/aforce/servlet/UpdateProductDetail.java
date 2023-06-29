package jp.co.aforce.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.bean.ProductInfo;
import jp.co.aforce.dao.ProductInfoDAO;

/**
 * Servlet implementation class UpdateProduct
 */
@WebServlet("/jp.co.aforce.servlet/update-product-detail")
@MultipartConfig
public class UpdateProductDetail extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			
			String product_id = request.getParameter("id");
			
			ProductInfoDAO dao = new ProductInfoDAO();
			ProductInfo info = dao.search(product_id);
			
			request.setAttribute("product_id", info.getProductId());
			request.setAttribute("product_name", info.getProductName());
			request.setAttribute("category", info.getCategory());
			request.setAttribute("price", info.getPrice());
			request.setAttribute("stock", info.getStock());
			request.setAttribute("description", info.getDescription());
			request.setAttribute("img_name", info.getImgName());
			request.getRequestDispatcher("/views/update-product.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
