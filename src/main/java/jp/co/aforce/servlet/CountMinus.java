package jp.co.aforce.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.bean.CartInfo;

/**
 * Servlet implementation class Cart
 */
@WebServlet("/jp.co.aforce.servlet/count-minus")
public class CountMinus extends HttpServlet {
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String product_id = (String)request.getParameter("id");
		
		List<CartInfo> cart = (List<CartInfo>)session.getAttribute("cart");
		
		for(CartInfo i : cart) {
			if(i.getProductInfo().getProductId().equals(product_id)) {
				i.setItemCount(i.getItemCount()-1);
				request.getRequestDispatcher("/views/cart.jsp").forward(request, response);
				return;
			}
		}
		
	}

}
