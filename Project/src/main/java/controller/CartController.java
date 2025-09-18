package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CartDao;
import dao.ProductDao;
import model.Cart;
import model.Product;

/**
 * Servlet implementation class CartController
 */
@WebServlet("/CartController")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("add")) {
			int cid = Integer.parseInt(request.getParameter("cid"));
			int pid = Integer.parseInt(request.getParameter("pid"));
			Product p = ProductDao.getProductByPid(pid);
			Cart c = new Cart();
			c.setPid(pid);
			c.setCus_id(cid);
			c.setPprice(p.getPprice());
			c.setQty(1);
			c.setTotal_price(p.getPprice());
			c.setImage(p.getImage());
			c.setPname(p.getPname());
			c.setPcategory(p.getPcategory());
			c.setPdesc(p.getPdesc());
			c.setPayment_status("pending");
			CartDao.addToCart(c);
			response.sendRedirect("product-detail.jsp?id=" + pid);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int cart_id = Integer.parseInt(request.getParameter("cart_id"));
		int qty = Integer.parseInt(request.getParameter("qty"));
		Cart c = CartDao.getCartByCartId(cart_id);
		c.setCart_id(cart_id);
		c.setQty(qty);
		c.setTotal_price(qty * c.getPprice());
		CartDao.updateCart(c);
		response.sendRedirect("cart.jsp");
	}

}
