package jp.co.aforce.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import jp.co.aforce.bean.ProductInfo;
import jp.co.aforce.dao.ProductInfoDAO;

/**
 * Servlet implementation class RegistProduct
 */
@WebServlet("/jp.co.aforce.servlet/update-product")
@MultipartConfig
public class UpdateProduct extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			
			String product_id = request.getParameter("product_id");
			String product_name = request.getParameter("product_name");
			String img_name = request.getParameter("img_name");
			String category = request.getParameter("category");
			String price = request.getParameter("price");
			int stock = Integer.parseInt(request.getParameter("stock"));
			String description = request.getParameter("description");
			
			//商品画像アップロード
			Part part = request.getPart("img_file");
			if(part.getSize()!=0) {
				String file_path = "/img/" + part.getSubmittedFileName();
				part.write(getServletContext().getRealPath(file_path));
			}
			
			//データベース更新
			ProductInfo i = new ProductInfo();
			i.setProductName(product_name);
			i.setImgName(img_name);
			i.setCategory(category);
			i.setPrice(price);
			i.setStock(stock);
			i.setDescription(description);
			i.setProductId(product_id);
			
			ProductInfoDAO dao = new ProductInfoDAO();
			int line = dao.update(i);
			
			if (line == 1) {
				request.setAttribute("success", "商品情報を更新しました。");
				request.getRequestDispatcher("/views/update-product-result.jsp").forward(request, response);
			}else {
				request.setAttribute("failure", "商品情報が更新できませんでした。");
				request.getRequestDispatcher("/views/update-product-result.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
