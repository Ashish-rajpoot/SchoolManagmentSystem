package com.user.controller;

import com.dao.Authenticate;
import com.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/login")

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		ArrayList<String> errors = new ArrayList<>();
		ArrayList<String> success = new ArrayList<>();
		String user_name = request.getParameter("username");
		String email= request.getParameter("email");
		String password = request.getParameter("password");

		Users user = null;
		if (((user_name == null || user_name.trim().isEmpty()) &&
			     (email == null || email.trim().isEmpty())) ||
			     password == null || password.trim().isEmpty()) {

			    errors.add("Please fill either username or email, and password.");
			}

		if (errors.size()>0) {
			request.setAttribute("errors", errors);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else {
			if (email.matches("^(.+)@(.+)$")) {
				user = Authenticate.getUserWithEmail(email, password);
				if (user != null) {
					HttpSession session = request.getSession();
					session.setAttribute("sessionProfile", user);
					session.setAttribute("user", user.getEmail());
					response.sendRedirect("map/home.jsp");
				} else
					try {
						if (request.getAttribute("user")==null && !request.getRequestURI().endsWith("map/login")) {
							errors.add("Invalid email or Password");
							request.setAttribute("errors", errors);
							request.getRequestDispatcher("login.jsp").forward(request, response);
						}
					} catch (ServletException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			
			}else {
				user = Authenticate.getUser(user_name, password);
				if (user != null) {
					HttpSession session = request.getSession();
					session.setAttribute("sessionProfile", user);
					session.setAttribute("user", user.getEmail());
					response.sendRedirect("map/home.jsp");
				} else
					try {
						if (request.getAttribute("user")==null && !request.getRequestURI().endsWith("map/login")) {
							errors.add("Invalid Username or Password");
							request.setAttribute("errors", errors);
							request.getRequestDispatcher("login.jsp").forward(request, response);
						}
					} catch (ServletException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		}
	}
}
