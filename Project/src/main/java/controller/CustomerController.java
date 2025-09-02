package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CustomerDao;
import dao.SellerDao;
import model.Customer;
import model.Seller;

/**
 * Servlet implementation class CustomerController
 */
@WebServlet("/CustomerController")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		System.out.println(action);
		if (action.equalsIgnoreCase("register")) {
			Customer u = new Customer();
			u.setName(request.getParameter("name"));
			u.setContact(Long.parseLong(request.getParameter("contact")));
			u.setAddress(request.getParameter("address"));
			u.setEmail(request.getParameter("email"));
			u.setPassword(request.getParameter("password"));
			System.out.println(u);
			String email = request.getParameter("email");
			boolean flag = CustomerDao.checkEmail(email);
			if (flag == false) {
				CustomerDao.insertCustomer(u);
				response.sendRedirect("customer-login.jsp");
			} else {
				request.setAttribute("msg", "OOPS! email alredy exist...");
				request.getRequestDispatcher("customer-register.jsp").forward(request, response);
			}

		} else if (action.equalsIgnoreCase("login")) {
			Customer u = new Customer();
			u.setEmail(request.getParameter("email"));
			u.setPassword(request.getParameter("password"));
			String email = request.getParameter("email");
			boolean flag = CustomerDao.checkEmail(email);
			if (flag == true) {
				Customer u1 = CustomerDao.customerLogin(u);
				if (u1 != null) {
					HttpSession session = request.getSession();
					session.setAttribute("data", u1);
					request.getRequestDispatcher("customer-home.jsp").forward(request, response);
				} else {
					request.setAttribute("msg", "Password is incorrect");
					request.getRequestDispatcher("customer-login.jsp").forward(request, response);
				}
			} else {
				request.setAttribute("msg", "OOPS! email not exist...");
				request.getRequestDispatcher("customer-login.jsp").forward(request, response);
			}
		}
		
		else if(action.equalsIgnoreCase("update")) {
			Customer s = new Customer();
			s.setId(Integer.parseInt(request.getParameter("id")));
			s.setName(request.getParameter("name"));
			s.setContact(Long.parseLong(request.getParameter("contact")));
			s.setAddress(request.getParameter("address"));
			s.setEmail(request.getParameter("email"));
			CustomerDao.updateProfile(s);
			HttpSession session = request.getSession();
			session.setAttribute("data", s);
			request.getRequestDispatcher("customer-home.jsp").forward(request, response);
		}
		
		else if(action.equalsIgnoreCase("cp")) {
			String email = request.getParameter("email");
			String op = request.getParameter("op");
			String np = request.getParameter("np");
			String cnp = request.getParameter("cnp");
			
			boolean flag = CustomerDao.checkOldPassword(email, op);
			if(flag == true) {
				if(np.equals(cnp)) {
					CustomerDao.changePassword(email, np);
					response.sendRedirect("customer-home.jsp");
				}
				else {
					request.setAttribute("msg", "NP and CNP not mathced");
					request.getRequestDispatcher("customer-change-pass.jsp").forward(request, response);
				}
			}
			else {
				request.setAttribute("msg", "Old Password Incorrect");
				request.getRequestDispatcher("customer-change-pass.jsp").forward(request, response);
			}
		}
	}

}
