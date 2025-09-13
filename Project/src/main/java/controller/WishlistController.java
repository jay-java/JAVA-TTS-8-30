package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.WishlistDao;
import model.Wishlist;

/**
 * Servlet implementation class Wishlist
 */
@WebServlet("/Wishlist")
public class WishlistController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WishlistController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equalsIgnoreCase("add")) {
			int pid = Integer.parseInt(request.getParameter("pid"));
			int cid = Integer.parseInt(request.getParameter("cid"));
			Wishlist w =new Wishlist();
			w.setPid(pid);
			w.setCid(cid);
			boolean flag = WishlistDao.checkProductIntoWishlit(pid, cid);
			System.out.println(flag);
			if(flag == false) {
				WishlistDao.addToWishlist(w);
				response.sendRedirect("product-detail.jsp?id="+pid);
			}
			else {
				request.setAttribute("msg", "product already added");
				request.setAttribute("id",pid);
				request.getRequestDispatcher("product-detail.jsp").forward(request, response);
			}
			
		}
		
		else if(action.equalsIgnoreCase("remove")) {
			int wid = Integer.parseInt(request.getParameter("wid"));
			WishlistDao.removeFromWishlist(wid);
			response.sendRedirect("customer-wishlist.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
