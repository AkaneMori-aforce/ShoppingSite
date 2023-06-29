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
@WebServlet("/jp.co.aforce.servlet/user-logout")
public class UserLogout extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//ユーザー情報
        session.removeAttribute("user_id");
        session.removeAttribute("password");
        session.removeAttribute("last_name");
        session.removeAttribute("first_name");
        session.removeAttribute("birth_year");
        session.removeAttribute("birth_month");
        session.removeAttribute("birth_day");
        session.removeAttribute("email_address");
        session.removeAttribute("phone_number");
        //カート
        session.removeAttribute("list");
        session.removeAttribute("cart");
        request.getRequestDispatcher("/views/top.jsp").forward(request, response);
	}

}
