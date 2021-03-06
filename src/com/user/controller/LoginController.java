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
		String password = request.getParameter("password");

		Users user = null;
		if(user_name==null||user_name==""||password==null||password=="") {
			
			errors.add("Fill all the required fields...");
		}
		if (errors.size()>0) {
			request.setAttribute("errors", errors);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else {
			if (user_name.matches("^(.+)@(.+)$")) {
				user = Authenticate.getUserWithEmail(user_name, password);
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
