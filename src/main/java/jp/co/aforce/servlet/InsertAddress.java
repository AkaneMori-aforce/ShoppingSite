package jp.co.aforce.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.bean.AddressInfo;
import jp.co.aforce.dao.AddressInfoDAO;

/**
 * Servlet implementation class RegistProduct
 */
@WebServlet("/jp.co.aforce.servlet/insert-address")
@MultipartConfig
public class InsertAddress extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			HttpSession session = request.getSession();
			
			String user_id = (String)session.getAttribute("user_id");
			String post_code = request.getParameter("post_code1") + "-" + request.getParameter("post_code2");
			String state = request.getParameter("state");
			String city = request.getParameter("city");
			String address_line = request.getParameter("address_line");
			String receiver_last_name = request.getParameter("receiver_last_name");
			String receiver_first_name = request.getParameter("receiver_first_name");
			
			//データベースにINSERT
			AddressInfo i = new AddressInfo();
			i.setUserId(user_id);
			i.setPostCode(post_code);
			i.setState(state);
			i.setCity(city);
			i.setAddressLine(address_line);
			i.setReceiverLastName(receiver_last_name);
			i.setReceiverFirstName(receiver_first_name);
			
			AddressInfoDAO dao = new AddressInfoDAO();
			int line = dao.regist(i);
			
			if (line == 1) {
				request.setAttribute("success", "新規お届け先住所を登録しました。");
				request.getRequestDispatcher("/views/insert-address-result.jsp").forward(request, response);
			}else {
				request.setAttribute("failure", "新規お届け先住所を登録できませんでした。");
				request.getRequestDispatcher("/views/insert-address-result.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
