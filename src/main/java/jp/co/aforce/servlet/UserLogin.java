package jp.co.aforce.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.bean.UserInfo;
import jp.co.aforce.dao.UserInfoDAO;

/**
 * Servlet implementation class Login
 */
@WebServlet("/jp.co.aforce.servlet/user-login")
public class UserLogin extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			request.setCharacterEncoding("UTF-8");
			
			HttpSession session = request.getSession(true);
			
			String user_id = request.getParameter("user_id");
			String password = request.getParameter("password");
			
			UserInfoDAO dao = new UserInfoDAO();
			UserInfo userinfo = dao.login(user_id, password);	
			
			if(userinfo != null) {
				session.setAttribute("user_id", userinfo.getUserId());
				session.setAttribute("password", userinfo.getPassword());
				session.setAttribute("last_name", userinfo.getLastName());
				session.setAttribute("first_name", userinfo.getFirstName());
				session.setAttribute("birth_year", userinfo.getBirthYear());
				session.setAttribute("birth_month", userinfo.getBirthMonth());
				session.setAttribute("birth_day", userinfo.getBirthDay());
				session.setAttribute("email_address", userinfo.getEmailAddress());
				session.setAttribute("phone_number", userinfo.getPhoneNumber());
				request.getRequestDispatcher("/views/top.jsp").forward(request, response);
			}else {
				request.setAttribute("failure", "※IDもしくはパスワードが違います");
				request.getRequestDispatcher("/views/user-login.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
