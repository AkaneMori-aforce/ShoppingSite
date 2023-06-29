package jp.co.aforce.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.bean.AdminInfo;
import jp.co.aforce.dao.AdminInfoDAO;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/jp.co.aforce.servlet/admin-login")
public class AdminLogin extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			request.setCharacterEncoding("UTF-8");
			
			HttpSession session = request.getSession(true);
			
			String admin_id = request.getParameter("admin_id");
			String admin_password = request.getParameter("admin_password");
			
			AdminInfoDAO dao = new AdminInfoDAO();
			AdminInfo admininfo = dao.login(admin_id, admin_password);	
			
			if(admininfo != null) {
				session.setAttribute("admin_id", admininfo.getAdminId());
				session.setAttribute("admin_name", admininfo.getAdminName());
				request.getRequestDispatcher("/jp.co.aforce.servlet/admin-list").forward(request, response);
			}else {
				request.setAttribute("failure", "※IDもしくはパスワードが違います");
				request.getRequestDispatcher("/views/admin-login.jsp").forward(request, response);
			}
			
			} catch (Exception e) {
				e.printStackTrace();
		}
	}
}
