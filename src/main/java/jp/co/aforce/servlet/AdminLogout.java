package jp.co.aforce.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UserLogout
 */
@WebServlet("/jp.co.aforce.servlet/admin-logout")
public class AdminLogout extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
        session.removeAttribute("admin_id");
        session.removeAttribute("admin_name");
        request.getRequestDispatcher("/views/admin-login.jsp").forward(request, response);
	}

}
