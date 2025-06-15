package com.user.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.entity.Teachers;
import com.entity.Users;

/**
 * Servlet implementation class UpdateUser
 */
@WebServlet("/map/AdminPass")
public class UpdatePass extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UserDao userDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdatePass() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		userDao = new UserDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NumberFormatException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		ArrayList<String> errors = new ArrayList<>();
		ArrayList<String> success = new ArrayList<>();
		String oldpass = request.getParameter("password");
		String newpass = request.getParameter("npassword");
		String confnewpass = request.getParameter("cnpassword");
		int user_id = Integer.parseInt(request.getParameter("user_id"));
		Users user = UserDao.selectById(user_id);
		String password = user.getPassword();

		if (newpass == null || newpass.equals("") || oldpass == null || oldpass.equals("") || confnewpass == null
				|| confnewpass.equals("")) {
			errors.add("All fields Required ..");

		}
		;
		if (!password.equals(oldpass)) {
			errors.add("old pass is not matching");

		}
		;
		if (!newpass.equals(confnewpass)) {
			errors.add("New password and confirm password is not matching");

		}
		if (errors.size() > 0) {
			request.setAttribute("errors", errors);
			RequestDispatcher rd = request.getRequestDispatcher("ProfileServlet");
			rd.forward(request, response);
		} else {

			try {

				Users book = new Users(user_id, newpass);
				userDao.updatePassword(book);

				HttpSession session = request.getSession();
				session.invalidate();
				response.sendRedirect(request.getContextPath() + "/login.jsp");

//				success.add("Password SuccessFully reset..."); 
//				success.add("Please Login Again..."); 
//				request.setAttribute("success",success);
//				RequestDispatcher rd = request.getRequestDispatcher("ProfileServlet");
//				rd.forward(request, response);

			} catch (NumberFormatException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
