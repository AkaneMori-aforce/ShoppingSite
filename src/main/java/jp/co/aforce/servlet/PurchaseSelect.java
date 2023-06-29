package jp.co.aforce.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.bean.AddressInfo;
import jp.co.aforce.dao.AddressInfoDAO;

/**
 * Servlet implementation class AddressSelect
 */
@WebServlet("/jp.co.aforce.servlet/purchase-select")
public class PurchaseSelect extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			HttpSession session = request.getSession();
			AddressInfoDAO dao = new AddressInfoDAO();
			List<AddressInfo> list = dao.address((String)session.getAttribute("user_id"));
			
			request.setAttribute("address_list", list);
			request.getRequestDispatcher("/views/purchase-step1.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
