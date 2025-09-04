package controller;

import java.io.IOException;
import java.util.Random;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SellerDao;
import email_send.EmailSender;
import model.Seller;

/**
 * Servlet implementation class SellerController
 */
@WebServlet("/SellerController")
public class SellerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SellerController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		System.out.println(action);
		if (action.equalsIgnoreCase("register")) {
			Seller u = new Seller();
			u.setName(request.getParameter("name"));
			u.setContact(Long.parseLong(request.getParameter("contact")));
			u.setAddress(request.getParameter("address"));
			u.setEmail(request.getParameter("email"));
			u.setPassword(request.getParameter("password"));
			System.out.println(u);
			String email = request.getParameter("email");
			boolean flag = SellerDao.checkEmail(email);
			if (flag == false) {
				SellerDao.insertSeller(u);
				response.sendRedirect("seller-login.jsp");
			} else {
				request.setAttribute("msg", "OOPS! email alredy exist...");
				request.getRequestDispatcher("seller-register.jsp").forward(request, response);
			}

		} else if (action.equalsIgnoreCase("login")) {
			Seller u = new Seller();
			u.setEmail(request.getParameter("email"));
			u.setPassword(request.getParameter("password"));
			String email = request.getParameter("email");
			boolean flag = SellerDao.checkEmail(email);
			if (flag == true) {
				Seller u1 = SellerDao.sellerLogin(u);
				if (u1 != null) {
					HttpSession session = request.getSession();
					session.setAttribute("data", u1);
					request.getRequestDispatcher("seller-home.jsp").forward(request, response);
				} else {
					request.setAttribute("msg", "Password is incorrect");
					request.getRequestDispatcher("seller-login.jsp").forward(request, response);
				}
			} else {
				request.setAttribute("msg", "OOPS! email not exist...");
				request.getRequestDispatcher("seller-login.jsp").forward(request, response);
			}
		}

		else if (action.equalsIgnoreCase("update")) {
			Seller s = new Seller();
			s.setId(Integer.parseInt(request.getParameter("id")));
			s.setName(request.getParameter("name"));
			s.setContact(Long.parseLong(request.getParameter("contact")));
			s.setAddress(request.getParameter("address"));
			s.setEmail(request.getParameter("email"));
			SellerDao.updateProfile(s);
			HttpSession session = request.getSession();
			session.setAttribute("data", s);
			request.getRequestDispatcher("seller-home.jsp").forward(request, response);
		}

		else if (action.equalsIgnoreCase("cp")) {
			String email = request.getParameter("email");
			String op = request.getParameter("op");
			String np = request.getParameter("np");
			String cnp = request.getParameter("cnp");

			boolean flag = SellerDao.checkOldPassword(email, op);
			if (flag == true) {
				if (np.equals(cnp)) {
					SellerDao.changePassword(email, np);
					response.sendRedirect("seller-home.jsp");
				} else {
					request.setAttribute("msg", "NP and CNP not mathced");
					request.getRequestDispatcher("seller-change-pass.jsp").forward(request, response);
				}
			} else {
				request.setAttribute("msg", "Old Password Incorrect");
				request.getRequestDispatcher("seller-change-pass.jsp").forward(request, response);
			}
		}

		else if (action.equalsIgnoreCase("getotp")) {
			String email = request.getParameter("email");
			boolean flag = SellerDao.checkEmail(email);
			System.out.println(flag);
			if (flag == true) {
				Random r = new Random();
				int otp = 100000 + r.nextInt(999999);
				System.out.println(otp);
				try {
					EmailSender.sendOTP(email, otp);
					System.out.println("===========> done");
					request.setAttribute("otp", otp);
					request.setAttribute("email", email);
					request.getRequestDispatcher("seller-verify-otp.jsp").forward(request, response);
				} catch (MessagingException e) {
					e.printStackTrace();
				}
			} else {
				request.setAttribute("msg", "Account does not exist");
				request.getRequestDispatcher("seller-forgot-password.jsp").forward(request, response);
			}
		}
		
		else if(action.equalsIgnoreCase("verify")) {
			
		}
	}

}
