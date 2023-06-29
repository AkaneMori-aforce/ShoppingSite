package jp.co.aforce.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.bean.AddressInfo;
import jp.co.aforce.dao.AddressInfoDAO;

/**
 * Servlet implementation class Confirm
 */
@WebServlet("/jp.co.aforce.servlet/confirm")
public class Confirm extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			request.setCharacterEncoding("UTF-8");
				
			String address_id = request.getParameter("address_select");
			String payment = request.getParameter("payment");
			
			AddressInfoDAO dao = new AddressInfoDAO();
			AddressInfo addressinfo = dao.receive_address(address_id);
			
			request.setAttribute("post_code", addressinfo.getPostCode());
			request.setAttribute("state", addressinfo.getState());
			request.setAttribute("city", addressinfo.getCity());
			request.setAttribute("address_line", addressinfo.getAddressLine());
			request.setAttribute("receiver_last_name", addressinfo.getReceiverLastName());
			request.setAttribute("receiver_first_name", addressinfo.getReceiverFirstName());
			request.setAttribute("select_payment", payment);
			request.getRequestDispatcher("/views/purchase-step2.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
