package jp.co.aforce.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.dao.AddressInfoDAO;

/**
 * Servlet implementation class DeleteProduct
 */
@WebServlet("/jp.co.aforce.servlet/delete-address")
public class DeleteAddress extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			
			String address_id = request.getParameter("id");
			
			AddressInfoDAO dao = new AddressInfoDAO();
			int line = dao.delete(address_id);
			
			if(line == 1) {
				request.setAttribute("success", "お届け先住所を削除しました。");
				request.getRequestDispatcher("/views/delete-address-result.jsp").forward(request, response);
			}else {
				request.setAttribute("failure", "お届け先住所を削除できませんでした。");
				request.getRequestDispatcher("/views/delete-address-result.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
