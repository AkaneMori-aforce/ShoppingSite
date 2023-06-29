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
@WebServlet("/jp.co.aforce.servlet/regist-product")
@MultipartConfig
public class RegistProduct extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			
			String product_name = request.getParameter("product_name");
			String img_name = request.getParameter("img_name");
			String category = request.getParameter("category");
			String price = request.getParameter("price");
			int stock = Integer.parseInt(request.getParameter("stock"));
			String description = request.getParameter("description");
			
			//商品画像アップロード
			Part part = request.getPart("img_file");
			String file_path = "/img/" + part.getSubmittedFileName();
			part.write(getServletContext().getRealPath(file_path));
			
			//データベースにINSERT
			ProductInfo i = new ProductInfo();
			i.setProductName(product_name);
			i.setImgName(img_name);
			i.setCategory(category);
			i.setPrice(price);
			i.setStock(stock);
			i.setDescription(description);
			
			ProductInfoDAO dao = new ProductInfoDAO();
			int line = dao.regist(i);
			
			if (line == 1) {
				request.setAttribute("success", "商品を登録しました。");
				request.getRequestDispatcher("/views/regist-product-result.jsp").forward(request, response);
			}else {
				//遷移できない
				request.setAttribute("failure", "商品を登録できませんでした。");
				request.getRequestDispatcher("/views/regist-product-result.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
