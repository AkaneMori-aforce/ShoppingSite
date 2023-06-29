package jp.co.aforce.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.bean.CartInfo;
import jp.co.aforce.bean.ProductInfo;

/**
 * Servlet implementation class Cart
 */
@WebServlet("/jp.co.aforce.servlet/cart-add")
public class CartAdd extends HttpServlet {
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String product_id = (String)request.getParameter("id");
		int cartcount = Integer.parseInt(request.getParameter("cartcount"));
		
		List<CartInfo> cart = (List<CartInfo>)session.getAttribute("cart");
		if(cart == null) {
			cart = new ArrayList<CartInfo>();
			session.setAttribute("cart", cart);
		}
		
		for(CartInfo i : cart) {
			if(i.getProductInfo().getProductId().equals(product_id)) {
				if(i.getItemCount() < 5) {
					i.setItemCount(i.getItemCount()+cartcount);
				}
				request.getRequestDispatcher("/views/cart.jsp").forward(request, response);
				return;
			}
		}
		
		List<ProductInfo> list = (List<ProductInfo>)session.getAttribute("list");
		for(ProductInfo p : list) {
			if(p.getProductId().equals(product_id)) {
				CartInfo i = new CartInfo();
				i.setProductInfo(p);
				i.setItemCount(cartcount);
				cart.add(i);
			}
		}
		request.getRequestDispatcher("/views/cart.jsp").forward(request, response);
		
	}

}
